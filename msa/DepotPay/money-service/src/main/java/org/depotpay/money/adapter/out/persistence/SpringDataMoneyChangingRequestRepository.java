package org.depotpay.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: DongMin Kim
 */
public interface SpringDataMoneyChangingRequestRepository extends JpaRepository<MoneyChangingRequestJpaEntity, Long> {
}
