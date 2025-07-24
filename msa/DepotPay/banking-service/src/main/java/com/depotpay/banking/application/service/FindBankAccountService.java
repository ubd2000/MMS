package com.depotpay.banking.application.service;

import com.depotpay.banking.adapter.out.persistence.RegisterBankAccountJpaEntity;
import com.depotpay.banking.adapter.out.persistence.RegisterBankAccountMapper;
import com.depotpay.banking.application.port.in.FindBankAccountCommand;
import com.depotpay.banking.application.port.in.FindBankAccountUserCase;
import com.depotpay.banking.application.port.out.FindBankAccountPort;
import com.depotpay.banking.domain.RegisterBankAccount;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: DongMin Kim
 */
@Service
@RequiredArgsConstructor
@Transactional
public class FindBankAccountService implements FindBankAccountUserCase {

    private final FindBankAccountPort findBankAccountPort;
    private final RegisterBankAccountMapper registerBankAccountMapper;

    @Override
    public RegisterBankAccount findBankAccount(FindBankAccountCommand command) {
        RegisterBankAccountJpaEntity entity = findBankAccountPort.findRegisterBankAccount(new RegisterBankAccount.MembershipId(command.getMembershipId()));

        return registerBankAccountMapper.mapToDomainEntity(entity);
    }

}
