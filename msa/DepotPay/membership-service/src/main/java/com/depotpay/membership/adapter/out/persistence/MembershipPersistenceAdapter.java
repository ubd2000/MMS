package com.depotpay.membership.adapter.out.persistence;

import com.depotpay.common.PersistenceAdapter;
import com.depotpay.membership.application.port.out.FindMembershipPort;
import com.depotpay.membership.application.port.out.ModifyMembershipPort;
import com.depotpay.membership.application.port.out.RegisterMembershipPort;
import com.depotpay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

/**
 * @author: DongMin Kim
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipValid membershipValid, Membership.MembershipCorp membershipCorp) {
        return membershipRepository.save(new MembershipJpaEntity(
                membershipName.getName(),
                membershipEmail.getEmail(),
                membershipAddress.getAddress(),
                membershipValid.isValid(),
                membershipCorp.isCorp()
        ));
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getReferenceById(Long.parseLong(membershipId.getMembershipId()));
    }

    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId id, Membership.MembershipName name, Membership.MembershipEmail email, Membership.MembershipAddress address, Membership.MembershipValid isValid, Membership.MembershipCorp isCorp) {
        MembershipJpaEntity membershipJpaEntity = membershipRepository.getReferenceById(Long.parseLong(id.getMembershipId()));

        membershipJpaEntity.setName(name.getName());
        membershipJpaEntity.setEmail(email.getEmail());
        membershipJpaEntity.setAddress(address.getAddress());
        membershipJpaEntity.setValid(isValid.isValid());
        membershipJpaEntity.setCorp(isCorp.isCorp());

        return membershipRepository.save(membershipJpaEntity);
    }
}
