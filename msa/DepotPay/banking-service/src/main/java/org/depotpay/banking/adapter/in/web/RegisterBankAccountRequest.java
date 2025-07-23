package org.depotpay.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DongMin Kim
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountRequest {
    private String registeredBankAccountId;
    private String membershipId;
    private String bankName;
    private String bankAccountNumber;
    private Boolean linkedStatusIsValid;
}
