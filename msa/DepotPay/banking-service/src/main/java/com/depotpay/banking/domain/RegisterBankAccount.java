package com.depotpay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * @author: DongMin Kim
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RegisterBankAccount {

    private final String registeredBankAccountId;
    private final String membershipId;
    private final String bankName;
    private final String bankAccountNumber;
    private final Boolean linkedStatusIsValid;

    public static RegisterBankAccount generateRegisteredBankAccount(
            RegisterBankAccount.RegisteredBankAccountId registeredBankAccountId,
            RegisterBankAccount.MembershipId membershipId,
            RegisterBankAccount.BankName bankName,
            RegisterBankAccount.BankAccountNumber bankAccountNumber,
            RegisterBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
        return new RegisterBankAccount(
                registeredBankAccountId.registeredBankAccountId,
                membershipId.membershipId,
                bankName.bankName,
                bankAccountNumber.bankAccountNumber,
                linkedStatusIsValid.linkedStatusIsValid);
    }

    @Value
    public static class RegisteredBankAccountId {
        String registeredBankAccountId;

        public RegisteredBankAccountId(String registeredBankAccountId) {
            this.registeredBankAccountId = registeredBankAccountId;
        }
    }

    @Value
    public static class MembershipId {
        String membershipId;

        public MembershipId(String membershipId) {
            this.membershipId = membershipId;
        }
    }

    @Value
    public static class BankName {
        String bankName;

        public BankName(String bankName) {
            this.bankName = bankName;
        }
    }

    @Value
    public static class BankAccountNumber {
        String bankAccountNumber;

        public BankAccountNumber(String bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
        }
    }

    @Value
    public static class LinkedStatusIsValid {
        Boolean linkedStatusIsValid;

        public LinkedStatusIsValid(Boolean linkedStatusIsValid) {
            this.linkedStatusIsValid = linkedStatusIsValid;
        }
    }
}
