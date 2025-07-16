package com.depotpay.membership.adapter.out.persistence;

import com.depotpay.membership.domain.Membership;
import org.springframework.stereotype.Component;

/**
 * @author: DongMin Kim
 */
@Component
public class MembershipMapper {

    public Membership mapToDomainEntity(MembershipJpaEntity membershipJpaEntity) {
        return Membership.generateMember(
                new Membership.MembershipId(membershipJpaEntity.getMembershipId() + ""),
                new Membership.MembershipName(membershipJpaEntity.getName()),
                new Membership.MembershipEmail(membershipJpaEntity.getEmail()),
                new Membership.MembershipAddress(membershipJpaEntity.getAddress()),
                new Membership.MembershipValid(membershipJpaEntity.isValid()),
                new Membership.MembershipCorp(membershipJpaEntity.isCorp()
                ));
    }
}
