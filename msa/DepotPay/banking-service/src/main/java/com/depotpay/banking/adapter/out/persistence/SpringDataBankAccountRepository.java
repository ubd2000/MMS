package com.depotpay.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * @author: DongMin Kim
 */
public interface SpringDataBankAccountRepository extends JpaRepository<RegisterBankAccountJpaEntity, Long> {

    // membershipId로 은행 계좌 조회
    Optional<RegisterBankAccountJpaEntity> findByMembershipId(String membershipId);
    
}
