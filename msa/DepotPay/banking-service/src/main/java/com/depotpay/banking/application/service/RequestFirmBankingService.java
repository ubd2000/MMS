package com.depotpay.banking.application.service;

import com.depotpay.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.depotpay.banking.adapter.out.external.bank.FirmBankingResult;
import com.depotpay.banking.adapter.out.persistence.FirmBankingRequestJpaEntity;
import com.depotpay.banking.adapter.out.persistence.FirmBankingRequestMapper;
import com.depotpay.banking.application.port.in.FirmBankingRequestCommand;
import com.depotpay.banking.application.port.in.RequestFirmBankingUserCase;
import com.depotpay.banking.application.port.out.RequestExternalFirmBankingPort;
import com.depotpay.banking.application.port.out.RequestFirmBankingPort;
import com.depotpay.banking.domain.FirmBankRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: DongMin Kim
 */
@Service
@RequiredArgsConstructor
@Transactional
public class RequestFirmBankingService implements RequestFirmBankingUserCase {
    private final RequestFirmBankingPort requestFirmBankingPort;
    private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;
    private final FirmBankingRequestMapper mapper;

    @Override
    public FirmBankRequest requestFirmBanking(FirmBankingRequestCommand command) {

        // 비즈니스 로직 수행
        // a -> b 계좌

        // 1. 요청에 대해 정보를 먼저 write . "요청" 상태로
        FirmBankingRequestJpaEntity requestEntity = requestFirmBankingPort.createFirmBankingRequest(
                new FirmBankRequest.FormBankName(command.getFormBankName()),
                new FirmBankRequest.FormBankAccountNumber(command.getFormBankAccountNumber()),
                new FirmBankRequest.ToBankName(command.getToBankName()),
                new FirmBankRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                new FirmBankRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmBankRequest.FirmBankingStatus(0) // 요청 상태로 초기화
        );

        // 2. 외부 믕냏에 펌뱅킹 요청
        FirmBankingResult result = requestExternalFirmBankingPort.requestExternalFirmBanking(
                new ExternalFirmBankingRequest(
                        command.getFormBankName(),
                        command.getFormBankAccountNumber(),
                        command.getToBankName(),
                        command.getToBankAccountNumber()
                )
        );

        // Transaction UUID
        UUID randomUUID = UUID.randomUUID();
        requestEntity.setUuid(randomUUID);

        // 3. 결과에 따라서 1번에서 작성했던 FirmBankingReqeust 상태를 변경
        if (result.getResultCode() == 0) {
            requestEntity.setFirmBankingStatus(1); // 성공 상태로 변경
        } else {
            requestEntity.setFirmBankingStatus(2); // 실패 상태로 변경
        }

        // 4. 결과를 리턴하기전에 바뀐 상태 값을 기준으로 다시 save

        return mapper.mapToDomainEntity(requestFirmBankingPort.modifyFirmBankingRequest(requestEntity), UUID.randomUUID());
    }
}
