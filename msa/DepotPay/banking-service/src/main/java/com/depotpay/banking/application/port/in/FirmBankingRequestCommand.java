package com.depotpay.banking.application.port.in;

import com.depotpay.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: DongMin Kim
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FirmBankingRequestCommand extends SelfValidating<FirmBankingRequestCommand> {

    @NotNull
    private final String formBankName; // 실물계좌를 요청할 은행명
    @NotNull
    private final String formBankAccountNumber; // 실물계좌를 요청할 계좌번호
    @NotNull
    private final String toBankName; // b -> a 실물계좌로 요청을 하기 위한 Request 클래스
    @NotNull
    private final String toBankAccountNumber; // b -> a 실물계좌로 요청을
    private final int moneyAmount; // 실물계좌로 요청할 금액

}
