package com.depotpay.membership.adapter.out.persistence;

import com.depotpay.membership.application.port.out.RegisterMembershipPort;
import com.depotpay.membership.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

/**
 * @author: DongMin Kim
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort {

    private final SpringDataMembershipRepository springDataMembershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipValid membershipValid, Membership.MembershipCorp membershipCorp) {
        return springDataMembershipRepository.save(new MembershipJpaEntity(
                membershipName.getName(),
                membershipEmail.getEmail(),
                membershipAddress.getAddress(),
                membershipValid.isValid(),
                membershipCorp.isCorp()
        ));
    }
}
