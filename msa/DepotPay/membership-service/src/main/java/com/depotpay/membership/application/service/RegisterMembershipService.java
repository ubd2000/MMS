package com.depotpay.membership.application.service;

import com.depotpay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.depotpay.membership.adapter.out.persistence.MembershipMapper;
import com.depotpay.membership.application.port.in.RegisterMembershipCommand;
import com.depotpay.membership.application.port.in.RegisterMembershipUserCase;
import com.depotpay.membership.application.port.out.RegisterMembershipPort;
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
public class RegisterMembershipService implements RegisterMembershipUserCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        //??
        // command -> DB

        // biz logic -> DB 통신
        // external system (외부 통신)
        //port, adapter

        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipValid(command.isValid()),
                new Membership.MembershipCorp(command.isCorp())
        );

        // entity -> Membership 도메인 객체로 변환
        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
