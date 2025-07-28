package org.depotpay.money.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DongMin Kim
 */
@Entity
@Table(name = "member_money")
@Data
@NoArgsConstructor
public class MemberMoneyJpaEntity {
    @Id
    @GeneratedValue
    private Long memberMoneyId;
    private String membershipId;
    private int balance;

    public MemberMoneyJpaEntity(String membershipId, int balance) {
        this.membershipId = membershipId;
        this.balance = balance;
    }
}
