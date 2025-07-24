package com.depotpay.banking.application.port.in;

import com.depotpay.common.UseCase;
import com.depotpay.banking.domain.RegisterBankAccount;

/**
 * @author: DongMin Kim
 */
@UseCase
public interface RegisterBankAccountUserCase {
    RegisterBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
