package com.depotpay.banking.application.port.out;


import com.depotpay.banking.adapter.out.persistence.RegisterBankAccountJpaEntity;
import com.depotpay.banking.domain.RegisterBankAccount;

/**
 * @author: DongMin Kim
 */
public interface FindBankAccountPort {
    RegisterBankAccountJpaEntity findRegisterBankAccount(RegisterBankAccount.MembershipId membershipId);
}
