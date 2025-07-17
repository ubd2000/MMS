package com.depotpay.membership.application.port.out;

import com.depotpay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.depotpay.membership.domain.Membership;

/**
 * @author: DongMin Kim
 */
public interface FindMembershipPort {
    MembershipJpaEntity findMembership(Membership.MembershipId membershipId);
}
