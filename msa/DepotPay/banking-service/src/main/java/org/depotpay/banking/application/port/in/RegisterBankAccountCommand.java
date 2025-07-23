package org.depotpay.banking.application.port.in;

import com.depotpay.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
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
    private String registeredBankAccountId;
    @NotNull
    private String membershipId;
    @NotNull
    private String bankName;
    @NotNull
    private String bankAccountNumber;
    @AssertTrue
    private Boolean linkedStatusIsValid;

}
