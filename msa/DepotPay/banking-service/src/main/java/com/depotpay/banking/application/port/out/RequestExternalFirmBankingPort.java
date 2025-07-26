package com.depotpay.banking.application.port.out;

import com.depotpay.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.depotpay.banking.adapter.out.external.bank.FirmBankingResult;

/**
 * @author: DongMin Kim
 */
public interface RequestExternalFirmBankingPort {
    FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request);
}
