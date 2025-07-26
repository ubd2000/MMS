package com.depotpay.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DongMin Kim
 *
 * 기존 FirmBankin request와 동일한 구조로 정의되어 있더라도 해당 패키지는 외부 은행과의 통신을 목적으로 하는 역할이므로 목적이 다름
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalFirmBankingRequest {
    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
}
