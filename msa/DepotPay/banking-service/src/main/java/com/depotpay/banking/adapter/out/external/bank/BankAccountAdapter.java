package com.depotpay.banking.adapter.out.external.bank;

import com.depotpay.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;
import com.depotpay.banking.application.port.out.RequestBankAccountInfoPort;

/**
 * @author: DongMin Kim
 */
@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

        // 실제로 외부 은행에 http 을 통해서
        // 실제 은행 계좌 정보를 가져오고

        // 실제 은행 계좌 -> BankAccount 객체로 변환하여 반환

        return new BankAccount(request.getBankName(), request.getBankaccountNumber(), true);
    }
}
