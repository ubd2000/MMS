package com.depotpay.banking.application.port.in;

import com.depotpay.banking.domain.FirmBankRequest;
import com.depotpay.common.UseCase;

/**
 * @author: DongMin Kim
 */
@UseCase
public interface RequestFirmBankingUserCase {
    FirmBankRequest requestFirmBanking(FirmBankingRequestCommand command);
}
