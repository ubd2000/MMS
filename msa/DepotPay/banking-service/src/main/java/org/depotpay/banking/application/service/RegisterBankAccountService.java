package org.depotpay.banking.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.depotpay.banking.adapter.out.persistence.BankAccountJpaEntity;
import org.depotpay.banking.adapter.out.persistence.BankAccountMapper;
import org.depotpay.banking.application.port.in.RegisterBankAccountCommand;
import org.depotpay.banking.application.port.in.RegisterBankAccountUserCase;
import org.depotpay.banking.application.port.out.RegisterBankAccountPort;
import org.depotpay.banking.domain.RegisterBankAccount;
import org.springframework.stereotype.Service;

/**
 * @author: DongMin Kim
 */
@Service
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUserCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final BankAccountMapper bankAccountMapper;

    @Override
    public RegisterBankAccount registerBankAccount(RegisterBankAccountCommand command) {
        BankAccountJpaEntity jpaEntity = registerBankAccountPort.createBankAccount(
                new RegisterBankAccount.RegisteredBankAccountId(command.getRegisteredBankAccountId()),
                new RegisterBankAccount.MembershipId(command.getMembershipId()),
                new RegisterBankAccount.BankName(command.getBankName()),
                new RegisterBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                new RegisterBankAccount.LinkedStatusIsValid(command.getLinkedStatusIsValid())
        );

        return bankAccountMapper.mapToDomainEntity(jpaEntity);
    }
}
