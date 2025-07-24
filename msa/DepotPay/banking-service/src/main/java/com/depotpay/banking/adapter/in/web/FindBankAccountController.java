package com.depotpay.banking.adapter.in.web;

import com.depotpay.banking.application.port.in.FindBankAccountCommand;
import com.depotpay.banking.application.port.in.FindBankAccountUserCase;
import com.depotpay.banking.domain.RegisterBankAccount;
import com.depotpay.common.WebAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DongMin Kim
 */
@Tag(name = "Bank Account", description = "은행 계좌 조회 API")
@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindBankAccountController {

    private final FindBankAccountUserCase findBankAccountUserCase;

    @Operation(
            summary = "회원 은행 계좌 조회",
            description = "회원 ID를 통해 등록된 은행 계좌 정보를 조회합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "은행 계좌 조회 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RegisterBankAccount.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "해당 회원의 은행 계좌를 찾을 수 없습니다",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 내부 오류",
                    content = @Content
            )
    })
    @GetMapping("/banking/account/{membershipId}")
    RegisterBankAccount findBankAccount(
            @Parameter(
                    description = "회원 ID", 
                    required = true,
                    example = "MEMBER001"
            )
            @PathVariable String membershipId) {

        FindBankAccountCommand command = FindBankAccountCommand.builder()
                .membershipId(membershipId)
                .build();

        return findBankAccountUserCase.findBankAccount(command);
    }
}
