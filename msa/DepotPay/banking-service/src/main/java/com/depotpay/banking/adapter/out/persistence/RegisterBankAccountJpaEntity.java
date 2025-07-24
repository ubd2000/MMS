package com.depotpay.banking.adapter.out.persistence;

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
@Table(name = "registered_bank_account")
@Data
@NoArgsConstructor
public class RegisterBankAccountJpaEntity {
    @Id
    @GeneratedValue
    private Long registeredBankAccountId;
    private String membershipId;
    private String bankName;
    private String bankAccountNumber;
    private Boolean linkedStatusIsValid;

    public RegisterBankAccountJpaEntity(String membershipId, String bankName, String bankAccountNumber, Boolean linkedStatusIsValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }

    @Override
    public String toString() {
        return "RegisterBankAccountJpaEntity{" +
                "registeredBankAccountId='" + registeredBankAccountId + '\'' +
                ", membershipId='" + membershipId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", linkedStatusIsValid=" + linkedStatusIsValid +
                '}';
    }
}
