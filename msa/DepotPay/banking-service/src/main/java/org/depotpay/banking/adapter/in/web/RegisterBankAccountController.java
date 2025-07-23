package org.depotpay.banking.adapter.in.web;

import com.depotpay.common.WebAdapter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.depotpay.banking.application.port.in.RegisterBankAccountCommand;
import org.depotpay.banking.application.port.in.RegisterBankAccountUserCase;
import org.depotpay.banking.domain.RegisterBankAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DongMin Kim
 *
 * WebAdapter
 */
@Tag(name = "Membership", description = "회원 관리 API")
@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUserCase registerBankAccountUserCase;

    @PostMapping("/bankaccount/register")
    RegisterBankAccount registerMembership(@RequestBody RegisterBankAccountRequest request) {

        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .registeredBankAccountId(request.getRegisteredBankAccountId())
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .linkedStatusIsValid(true) // Assuming linked status is valid for this example
                .build();

        return registerBankAccountUserCase.registerBankAccount(command);

    }
}
