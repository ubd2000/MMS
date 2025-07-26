package com.depotpay.banking.application.port.in;

import com.depotpay.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
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
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

    @NotNull
    private final String registeredBankAccountId;
    @NotNull
    private final String membershipId;
    @NotNull
    private final String bankName;
    @NotNull
    private final String bankAccountNumber;
    @AssertTrue
    private final Boolean linkedStatusIsValid;

}
