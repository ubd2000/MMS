package com.depotpay.banking.adapter.in.web;

import com.depotpay.banking.application.port.in.FirmBankingRequestCommand;
import com.depotpay.banking.application.port.in.RequestFirmBankingUserCase;
import com.depotpay.banking.domain.FirmBankRequest;
import com.depotpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DongMin Kim
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

    private final RequestFirmBankingUserCase requestFirmBankingUserCase;

    @PostMapping("/banking/firmbanking/register")
    FirmBankRequest requestFirmBankingRequest(@RequestBody final RequestFirmBankingRequest request) {

        FirmBankingRequestCommand command = FirmBankingRequestCommand.builder()
                .formBankName(request.getFromBankName())
                .formBankAccountNumber(request.getFromBankAccountNumber())
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();

        return requestFirmBankingUserCase.requestFirmBanking(command);

    }
}
