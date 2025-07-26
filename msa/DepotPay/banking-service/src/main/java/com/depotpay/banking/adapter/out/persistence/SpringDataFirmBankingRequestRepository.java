package com.depotpay.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: DongMin Kim
 */
public interface SpringDataFirmBankingRequestRepository extends JpaRepository<FirmBankingRequestJpaEntity, Long> {
}
