package org.depotpay.money.adapter.in.web;

import com.depotpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.depotpay.money.application.port.in.IncreaseMoneyRequestCommand;
import org.depotpay.money.application.port.in.IncreaseMoneyRequestUseCase;
import org.depotpay.money.domain.MoneyChangingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DongMin Kim
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestMoneyChangingController {

    private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;
//    private final DecreaseMoneyRequestUseCase decreaseMoneyRequestUseCase;

    @PostMapping("/money/increase")
    MoneyChangingResultDetail increaseMoneyChingRequest(@RequestBody IncreaseMoneyChangingRequest request) {

//        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
//                .membershipId(request.getMembershipId())
//                .bankName(request.getBankName())
//                .bankAccountNumber(request.getBankAccountNumber())
//                .linkedStatusIsValid(true) // Assuming linked status is valid for this example
//                .build();

        IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
                .targetMembershipId(request.getTargetMembershipId())
                .amount(request.getAmount())
                .build();

        MoneyChangingRequest moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequest(command);
        MoneyChangingResultDetail resutDetail = new MoneyChangingResultDetail(
                moneyChangingRequest.getMoneyChangingRequestId(),
                0,
                0,
                moneyChangingRequest.getChangingMoneyAmount()
        );

        return resutDetail;
    }

    @PostMapping("/money/decrease")
    MoneyChangingResultDetail increaseMoneyChingRequest(@RequestBody DecreaseMoneyChangingRequest request) {
//
//        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
//                .membershipId(request.getMembershipId())
//                .bankName(request.getBankName())
//                .bankAccountNumber(request.getBankAccountNumber())
//                .linkedStatusIsValid(true) // Assuming linked status is valid for this example
//                .build();
//
//        RegisterBankAccount registerBankAccount = registerBankAccountUserCase.registerBankAccount(command);
//        if (registerBankAccount == null) {
//            // TODO: Error Handling
//            return null;
//        }
//        return registerBankAccount;

        return null;

    }
}
