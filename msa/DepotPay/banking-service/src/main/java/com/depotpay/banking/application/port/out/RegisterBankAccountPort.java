package com.depotpay.banking.application.port.out;


import com.depotpay.banking.adapter.out.persistence.RegisterBankAccountJpaEntity;
import com.depotpay.banking.domain.RegisterBankAccount;

/**
 * @author: DongMin Kim
 */
public interface RegisterBankAccountPort {
    RegisterBankAccountJpaEntity createRegisterBankAccount(RegisterBankAccount.MembershipId membershipId,
                                                           RegisterBankAccount.BankName bankName,
                                                           RegisterBankAccount.BankAccountNumber bankAccountNumber,
                                                           RegisterBankAccount.LinkedStatusIsValid linkedStatusIsValid);
}
