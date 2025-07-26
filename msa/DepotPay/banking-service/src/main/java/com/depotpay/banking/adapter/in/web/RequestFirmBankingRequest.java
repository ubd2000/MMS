package com.depotpay.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DongMin Kim
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestFirmBankingRequest {
    // a -> b 실물계좌로 요청을 하기 위한 Request 클래스

    private String fromBankName; // 실물계좌를 요청할 은행명
    private String fromBankAccountNumber; // 실물계좌를 요청할 계좌번호
    private String toBankName; // b -> a 실물계좌로 요청을 하기 위한 Request 클래스
    private String toBankAccountNumber; // b -> a 실물계좌로 요청을
    private int moneyAmount; // 실물계좌로 요청할 금액
}
