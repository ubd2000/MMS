package com.depotpay.membership.application.service;

import com.depotpay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.depotpay.membership.adapter.out.persistence.MembershipMapper;
import com.depotpay.membership.application.port.in.FindMembershipCommand;
import com.depotpay.membership.application.port.in.FindMembershipUserCase;
import com.depotpay.membership.application.port.out.FindMembershipPort;
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
public class FindMembershipService implements FindMembershipUserCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));

        return membershipMapper.mapToDomainEntity(entity);
    }
}
