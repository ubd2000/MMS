package org.depotpay.banking.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DongMin Kim
 */
@Entity
@Table(name = "bank_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountJpaEntity {
    @Id
    @GeneratedValue
    private String registeredBankAccountId;
    private String membershipId;
    private String bankName;
    private String bankAccountNumber;
    private Boolean linkedStatusIsValid;

    @Override
    public String toString() {
        return "BankAccountJpaEntity{" +
                "registeredBankAccountId='" + registeredBankAccountId + '\'' +
                ", membershipId='" + membershipId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", linkedStatusIsValid=" + linkedStatusIsValid +
                '}';
    }
}
