package com.depotpay.membership.application.port.in;

import common.SelfValidating;
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
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    @NotNull
    private final String name;
    @NotNull
    @NotBlank
    private final String address;
    @NotNull
    private final String email;
    @AssertTrue
    private final boolean isValid;
    @NotNull
    private final boolean isCorp;

    public RegisterMembershipCommand(String name, String address, String email, boolean isValid, boolean isCorp) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;

        // Validate the command
        this.validateSelf();
    }
}
