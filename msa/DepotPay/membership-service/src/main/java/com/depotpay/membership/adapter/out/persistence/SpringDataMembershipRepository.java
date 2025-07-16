package com.depotpay.membership.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: DongMin Kim
 */
public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {

}
