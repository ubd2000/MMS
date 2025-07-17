package com.depotpay.membership.adapter.in.web;

import com.depotpay.membership.application.port.in.FindMembershipCommand;
import com.depotpay.membership.application.port.in.FindMembershipUserCase;
import com.depotpay.membership.domain.Membership;
import common.WebAdapter;
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
@Tag(name = "Membership", description = "회원 관리 API")
@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUserCase findMembershipUserCase;

    @Operation(summary = "회원 조회", description = "회원 ID로 회원 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "회원 조회 성공", 
                    content = @Content(schema = @Schema(implementation = Membership.class))),
        @ApiResponse(responseCode = "404", description = "회원을 찾을 수 없음"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @GetMapping(path = "/membership/{membershipId}")
    public Membership findMembership(@Parameter(description = "회원 ID", required = true, example = "1") 
                                   @PathVariable String membershipId) {
        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(membershipId)
                .build();

        return findMembershipUserCase.findMembership(command);
    }
}
