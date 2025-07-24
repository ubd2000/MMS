package com.depotpay.banking.adapter.out.persistence;

import com.depotpay.banking.domain.RegisterBankAccount;
import org.springframework.stereotype.Component;

/**
 * @author: DongMin Kim
 */
@Component
public class RegisterBankAccountMapper {

    public RegisterBankAccount mapToDomainEntity(RegisterBankAccountJpaEntity registerBankAccountJpaEntity) {
        return RegisterBankAccount.generateRegisteredBankAccount(
                new RegisterBankAccount.RegisteredBankAccountId(registerBankAccountJpaEntity.getRegisteredBankAccountId() + ""),
                new RegisterBankAccount.MembershipId(registerBankAccountJpaEntity.getMembershipId()),
                new RegisterBankAccount.BankName(registerBankAccountJpaEntity.getBankName()),
                new RegisterBankAccount.BankAccountNumber(registerBankAccountJpaEntity.getBankAccountNumber()),
                new RegisterBankAccount.LinkedStatusIsValid(registerBankAccountJpaEntity.getLinkedStatusIsValid()
                ));
    }
}
