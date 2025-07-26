package com.depotpay.banking.application.port.out;

import com.depotpay.banking.adapter.out.persistence.FirmBankingRequestJpaEntity;
import com.depotpay.banking.domain.FirmBankRequest;

/**
 * @author: DongMin Kim
 */
public interface RequestFirmBankingPort {
    FirmBankingRequestJpaEntity createFirmBankingRequest(
            FirmBankRequest.FormBankName formBankName,
            FirmBankRequest.FormBankAccountNumber formBankAccountNumber,
            FirmBankRequest.ToBankName toBankName,
            FirmBankRequest.ToBankAccountNumber toBankAccountNumber,
            FirmBankRequest.MoneyAmount moneyAmount,
            FirmBankRequest.FirmBankingStatus firmBankingStatus
    );

    FirmBankingRequestJpaEntity modifyFirmBankingRequest(
            FirmBankingRequestJpaEntity entity
    );
}
