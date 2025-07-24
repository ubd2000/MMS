package com.depotpay.banking.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.depotpay.banking.adapter.out.external.bank.BankAccount;
import com.depotpay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.depotpay.banking.adapter.out.persistence.RegisterBankAccountJpaEntity;
import com.depotpay.banking.adapter.out.persistence.RegisterBankAccountMapper;
import com.depotpay.banking.application.port.in.RegisterBankAccountCommand;
import com.depotpay.banking.application.port.in.RegisterBankAccountUserCase;
import com.depotpay.banking.application.port.out.RegisterBankAccountPort;
import com.depotpay.banking.application.port.out.RequestBankAccountInfoPort;
import com.depotpay.banking.domain.RegisterBankAccount;
import org.springframework.stereotype.Service;

/**
 * @author: DongMin Kim
 */
@Service
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUserCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RegisterBankAccountMapper registerBankAccountMapper;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisterBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // 은행 계좌를 등록해야하는 서비스 (비즈니스 로직)
        // command.getMembershipId()

        // (멤버 서비스도 확인?) 여기서는 skip

        // 1. 외부 실제 은행에 등록이 가능한 계좌인지(정상인지) 확인한다.
        // 외부의 은행에 이 계좌 정상인지? 확인
        // Biz Logic -> External System
        // Port -> Adapter -> External System
        // Port
        // 실제 외부의 은행계좌 정보를 Get
        BankAccount bankAccountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        Boolean linkedStatusIsValid = bankAccountInfo.getLinkedStatusIsValid();

        // 2. 등록가능한 계좌라면, 등록한다. 성공하면, 등록에 성공한 등록 정보를 리턴
        // 2-1. 등록가능하지 않은 계좌라면. 에러를 리턴
        if (linkedStatusIsValid) {
            //등록 정보 저장
            RegisterBankAccountJpaEntity registerBankAccount = registerBankAccountPort.createRegisterBankAccount(
                    new RegisterBankAccount.MembershipId(command.getMembershipId() + ""),// MembershipId는 String으로 변환
                    new RegisterBankAccount.BankName(command.getBankName()),
                    new RegisterBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisterBankAccount.LinkedStatusIsValid(command.getLinkedStatusIsValid()));

            return registerBankAccountMapper.mapToDomainEntity(registerBankAccount);

        } else {
            return null;
        }

    }
}
