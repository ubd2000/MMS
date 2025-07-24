package com.depotpay.banking.adapter.out.external.bank;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DongMin Kim
 */
@Data
@NoArgsConstructor
public class BankAccount {
    private String bankName;
    private String bankAccountNumber;
    private Boolean linkedStatusIsValid;

    public BankAccount(String bankName, String bankAccountNumber, Boolean linkedStatusIsValid) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }
}
