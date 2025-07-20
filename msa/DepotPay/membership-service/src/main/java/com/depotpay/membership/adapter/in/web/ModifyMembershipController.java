package com.depotpay.membership.adapter.in.web;

import com.depotpay.common.WebAdapter;
import com.depotpay.membership.application.port.in.ModifyMembershipCommand;
import com.depotpay.membership.application.port.in.ModifyMembershipUserCase;
import com.depotpay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
public class ModifyMembershipController {

    private final ModifyMembershipUserCase modifyMembershipUserCase;

    @PostMapping(path = "/membership/modify")
    ResponseEntity<Membership> registerMembership(@RequestBody ModifyMembershipRequest modifyMembershipRequest) {

        ModifyMembershipCommand modifyMembershipCommand = ModifyMembershipCommand.builder()
                .membershipId(modifyMembershipRequest.getMembershipId())
                .name(modifyMembershipRequest.getName())
                .address(modifyMembershipRequest.getAddress())
                .email(modifyMembershipRequest.getEmail())
                .isValid(modifyMembershipRequest.isValid())
                .isCorp(modifyMembershipRequest.isCorp())
                .build();

        return ResponseEntity.ok(modifyMembershipUserCase.modifyMembership(modifyMembershipCommand));
    }
}
