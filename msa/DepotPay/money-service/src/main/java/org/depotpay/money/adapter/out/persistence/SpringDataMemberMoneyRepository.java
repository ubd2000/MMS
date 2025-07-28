package org.depotpay.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author: DongMin Kim
 */
public interface SpringDataMemberMoneyRepository extends JpaRepository<MemberMoneyJpaEntity, Long> {

    @Query("SELECT m FROM MemberMoneyJpaEntity m WHERE m.membershipId = :memberShipId")
    List<MemberMoneyJpaEntity> findByMemberShipId(@Param("membershipId") Long membershipId);
}
