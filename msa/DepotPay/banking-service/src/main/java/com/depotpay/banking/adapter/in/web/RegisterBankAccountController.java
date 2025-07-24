package com.depotpay.banking.adapter.in.web;

import com.depotpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import com.depotpay.banking.application.port.in.RegisterBankAccountCommand;
import com.depotpay.banking.application.port.in.RegisterBankAccountUserCase;
import com.depotpay.banking.domain.RegisterBankAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DongMin Kim
 *
 * WebAdapter
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUserCase registerBankAccountUserCase;

    @PostMapping("/banking/acoount/register")
    RegisterBankAccount registerBankAccount(@RequestBody RegisterBankAccountRequest request) {

        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .linkedStatusIsValid(true) // Assuming linked status is valid for this example
                .build();

        RegisterBankAccount registerBankAccount = registerBankAccountUserCase.registerBankAccount(command);
        if (registerBankAccount == null) {
            // TODO: Error Handling
            return null;
        }
        return registerBankAccount;

    }
}
