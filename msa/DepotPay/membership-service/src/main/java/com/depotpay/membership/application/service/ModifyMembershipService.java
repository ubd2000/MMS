package com.depotpay.membership.application.service;

import com.depotpay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.depotpay.membership.adapter.out.persistence.MembershipMapper;
import com.depotpay.membership.application.port.in.ModifyMembershipCommand;
import com.depotpay.membership.application.port.in.ModifyMembershipUserCase;
import com.depotpay.membership.application.port.out.ModifyMembershipPort;
import com.depotpay.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: DongMin Kim
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUserCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipValid(command.isValid()),
                new Membership.MembershipCorp(command.isCorp())
        );

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
