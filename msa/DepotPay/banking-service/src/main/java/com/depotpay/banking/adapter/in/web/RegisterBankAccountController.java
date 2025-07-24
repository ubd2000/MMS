package com.depotpay.banking.adapter.in.web;

import com.depotpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import com.depotpay.banking.application.port.in.RegisterBankAccountCommand;
import com.depotpay.banking.application.port.in.RegisterBankAccountUserCase;
import com.depotpay.banking.domain.RegisterBankAccount;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DongMin Kim
 */
@Tag(name = "Bank Account", description = "은행 계좌 등록 API")
@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUserCase registerBankAccountUserCase;

    @Operation(
            summary = "은행 계좌 등록",
            description = "회원의 은행 계좌 정보를 등록하고 연결 상태를 관리합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "은행 계좌 등록 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RegisterBankAccount.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "잘못된 요청 데이터",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "이미 등록된 계좌",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 내부 오류",
                    content = @Content
            )
    })
    @PostMapping("/banking/account/register")
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
