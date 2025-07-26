package com.depotpay.banking.adapter.out.persistence;

import com.depotpay.banking.domain.FirmBankRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: DongMin Kim
 */
@Component
public class FirmBankingRequestMapper {

    public FirmBankRequest mapToDomainEntity(FirmBankingRequestJpaEntity firmBankingRequestJpaEntity, UUID uuid) {
        return FirmBankRequest.generateFirmBankRequest(
                new FirmBankRequest.FirmBankRequestId(firmBankingRequestJpaEntity.getFirmBankRequestId() + ""),
                new FirmBankRequest.FormBankName(firmBankingRequestJpaEntity.getFromBankName()),
                new FirmBankRequest.FormBankAccountNumber(firmBankingRequestJpaEntity.getFromBankAccountNumber()),
                new FirmBankRequest.ToBankName(firmBankingRequestJpaEntity.getToBankName()),
                new FirmBankRequest.ToBankAccountNumber(firmBankingRequestJpaEntity.getToBankAccountNumber()),
                new FirmBankRequest.MoneyAmount(firmBankingRequestJpaEntity.getMoneyAmount()),
                new FirmBankRequest.FirmBankingStatus(firmBankingRequestJpaEntity.getFirmBankingStatus()),
                uuid
        );

    }
}
