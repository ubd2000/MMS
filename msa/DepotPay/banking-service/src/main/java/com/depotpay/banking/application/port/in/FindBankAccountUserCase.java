package com.depotpay.banking.application.port.in;

import com.depotpay.banking.domain.RegisterBankAccount;
import com.depotpay.common.UseCase;

/**
 * @author: DongMin Kim
 */
@UseCase
public interface FindBankAccountUserCase {
    RegisterBankAccount findBankAccount(FindBankAccountCommand command);
}
