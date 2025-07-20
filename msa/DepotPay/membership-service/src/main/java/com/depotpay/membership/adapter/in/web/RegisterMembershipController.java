package com.depotpay.membership.adapter.in.web;

import com.depotpay.common.WebAdapter;
import com.depotpay.membership.application.port.in.RegisterMembershipCommand;
import com.depotpay.membership.application.port.in.RegisterMembershipUserCase;
import com.depotpay.membership.domain.Membership;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
public class RegisterMembershipController {

    private final RegisterMembershipUserCase registerMembershipUserCase;

    @Operation(summary = "회원 등록", description = "새로운 회원을 등록합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "회원 등록 성공", 
                    content = @Content(schema = @Schema(implementation = Membership.class))),
        @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PostMapping(path = "/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        // request

        // request -> Command

        // Usecase ~~ (request x , command o)

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true) // Assuming isValid is true for this example
                .isCorp(request.isCorp())
                .build();

        return registerMembershipUserCase.registerMembership(command);

    }
}
