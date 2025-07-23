package org.depotpay.banking.application.port.out;


import org.depotpay.banking.adapter.out.persistence.BankAccountJpaEntity;
import org.depotpay.banking.domain.RegisterBankAccount;

/**
 * @author: DongMin Kim
 */
public interface RegisterBankAccountPort {
    BankAccountJpaEntity createBankAccount(RegisterBankAccount.RegisteredBankAccountId registeredBankAccountId,
                                           RegisterBankAccount.MembershipId membershipId,
                                           RegisterBankAccount.BankName bankName,
                                           RegisterBankAccount.BankAccountNumber bankAccountNumber,
                                           RegisterBankAccount.LinkedStatusIsValid linkedStatusIsValid);
}
