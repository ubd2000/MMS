package com.depotpay.banking.adapter.out.external.bank;

import lombok.Data;

/**
 * @author: DongMin Kim
 */
@Data
public class GetBankAccountRequest {

    private String bankName;
    private String bankaccountNumber;

    public GetBankAccountRequest(String bankName, String bankaccountNumber) {
        this.bankName = bankName;
        this.bankaccountNumber = bankaccountNumber;
    }
}
