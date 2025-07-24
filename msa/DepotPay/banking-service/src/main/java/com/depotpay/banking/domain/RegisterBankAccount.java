package com.depotpay.banking.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * @author: DongMin Kim
 */
@Schema(description = "등록된 은행 계좌 정보")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RegisterBankAccount {

    @Schema(description = "등록된 은행 계좌 ID", example = "BANK_ACC_001")
    private final String registeredBankAccountId;
    
    @Schema(description = "회원 ID", example = "MEMBER001")
    private final String membershipId;
    
    @Schema(description = "은행명", example = "국민은행")
    private final String bankName;
    
    @Schema(description = "계좌번호", example = "123456-78-901234")
    private final String bankAccountNumber;
    
    @Schema(description = "연결 상태 유효성", example = "true")
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
