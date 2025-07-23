package org.depotpay.banking.adapter.out.persistence;

import org.depotpay.banking.domain.RegisterBankAccount;
import org.springframework.stereotype.Component;

/**
 * @author: DongMin Kim
 */
@Component
public class BankAccountMapper {

    public RegisterBankAccount mapToDomainEntity(BankAccountJpaEntity bankAccountJpaEntity) {
        return RegisterBankAccount.generateRegisteredBankAccount(
                new RegisterBankAccount.RegisteredBankAccountId(bankAccountJpaEntity.getRegisteredBankAccountId()),
                new RegisterBankAccount.MembershipId(bankAccountJpaEntity.getMembershipId()),
                new RegisterBankAccount.BankName(bankAccountJpaEntity.getBankName()),
                new RegisterBankAccount.BankAccountNumber(bankAccountJpaEntity.getBankAccountNumber()),
                new RegisterBankAccount.LinkedStatusIsValid(bankAccountJpaEntity.getLinkedStatusIsValid()
                ));
    }
}
