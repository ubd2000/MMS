package org.depotpay.money.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: kdm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

    private String moneyChangingRequestId;
    //증액, 감액
    private int moneyChangingType;
    private int moneyChangingResultStatus; // 0: 증액, 1: 감액
    private int amount;
}