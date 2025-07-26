package com.depotpay.banking.adapter.out.persistence;

import com.depotpay.banking.application.port.out.RequestFirmBankingPort;
import com.depotpay.banking.domain.FirmBankRequest;
import com.depotpay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * @author: DongMin Kim
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class FirmBankingRequestPersistenceAdapter implements RequestFirmBankingPort {

    private final SpringDataFirmBankingRequestRepository springDataFirmBankingRequestRepository;

    @Override
    public FirmBankingRequestJpaEntity createFirmBankingRequest(FirmBankRequest.FormBankName formBankName, FirmBankRequest.FormBankAccountNumber formBankAccountNumber, FirmBankRequest.ToBankName toBankName, FirmBankRequest.ToBankAccountNumber toBankAccountNumber, FirmBankRequest.MoneyAmount moneyAmount, FirmBankRequest.FirmBankingStatus firmBankingStatus) {
        return springDataFirmBankingRequestRepository.save(
                new FirmBankingRequestJpaEntity(
                        formBankName.getFormBankName(),
                        formBankAccountNumber.getFormBankAccountNumber(),
                        toBankName.getToBankName(),
                        toBankAccountNumber.getToBankAccountNumber(),
                        moneyAmount.getMoneyAmount(),
                        firmBankingStatus.getFirmBankingStatus(),
                        UUID.randomUUID()
                )
        );
    }

    @Override
    public FirmBankingRequestJpaEntity modifyFirmBankingRequest(FirmBankingRequestJpaEntity entity) {
        return springDataFirmBankingRequestRepository.save(entity);
    }
}
