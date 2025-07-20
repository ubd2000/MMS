package com.depotpay.membership.application.port.out;

import com.depotpay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.depotpay.membership.domain.Membership;

/**
 * @author: DongMin Kim
 */
public interface ModifyMembershipPort {
    MembershipJpaEntity modifyMembership(
            Membership.MembershipId id,
            Membership.MembershipName name,
            Membership.MembershipEmail email,
            Membership.MembershipAddress address,
            Membership.MembershipValid isValid,
            Membership.MembershipCorp isCorp);
}
