package com.depotpay.banking.application.port.out;

import com.depotpay.banking.adapter.out.external.bank.BankAccount;
import com.depotpay.banking.adapter.out.external.bank.GetBankAccountRequest;

/**
 * @author: DongMin Kim
 */
public interface RequestBankAccountInfoPort {
    public BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
