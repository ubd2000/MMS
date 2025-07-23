package org.depotpay.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: DongMin Kim
 */
public interface SpringDataBankAccountRepository extends JpaRepository<BankAccountJpaEntity, Long> {

}
