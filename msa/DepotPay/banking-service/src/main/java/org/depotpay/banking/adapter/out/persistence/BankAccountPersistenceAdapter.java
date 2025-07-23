package org.depotpay.banking.adapter.out.persistence;

import com.depotpay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.depotpay.banking.application.port.out.RegisterBankAccountPort;
import org.depotpay.banking.domain.RegisterBankAccount;

/**
 * @author: DongMin Kim
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class BankAccountPersistenceAdapter implements RegisterBankAccountPort {

    SpringDataBankAccountRepository springDataBankAccountRepository;

    @Override
    public BankAccountJpaEntity createBankAccount(RegisterBankAccount.RegisteredBankAccountId registeredBankAccountId, RegisterBankAccount.MembershipId membershipId, RegisterBankAccount.BankName bankName, RegisterBankAccount.BankAccountNumber bankAccountNumber, RegisterBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
        return springDataBankAccountRepository.save(new BankAccountJpaEntity(
                registeredBankAccountId.getRegisteredBankAccountId(),
                membershipId.getMembershipId(),
                bankName.getBankName(),
                bankAccountNumber.getBankAccountNumber(),
                linkedStatusIsValid.getLinkedStatusIsValid()
        ));
    }
}
