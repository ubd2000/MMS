package com.depotpay.banking.adapter.out.persistence;

import com.depotpay.banking.application.port.out.FindBankAccountPort;
import com.depotpay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import com.depotpay.banking.application.port.out.RegisterBankAccountPort;
import com.depotpay.banking.domain.RegisterBankAccount;

/**
 * @author: DongMin Kim
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class RegisterBankAccountPersistenceAdapter implements RegisterBankAccountPort, FindBankAccountPort {

    private final SpringDataBankAccountRepository springDataBankAccountRepository;

    @Override
    public RegisterBankAccountJpaEntity createRegisterBankAccount(RegisterBankAccount.MembershipId membershipId, RegisterBankAccount.BankName bankName, RegisterBankAccount.BankAccountNumber bankAccountNumber, RegisterBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
        return springDataBankAccountRepository.save(new RegisterBankAccountJpaEntity(
                membershipId.getMembershipId(),
                bankName.getBankName(),
                bankAccountNumber.getBankAccountNumber(),
                linkedStatusIsValid.getLinkedStatusIsValid()
        ));
    }

    @Override
    public RegisterBankAccountJpaEntity findRegisterBankAccount(RegisterBankAccount.MembershipId membershipId) {
        return springDataBankAccountRepository.findByMembershipId(membershipId.getMembershipId())
                .orElseThrow(() -> new IllegalArgumentException("등록된 계좌가 없습니다. 회원 ID: " + membershipId.getMembershipId()));
    }
}
