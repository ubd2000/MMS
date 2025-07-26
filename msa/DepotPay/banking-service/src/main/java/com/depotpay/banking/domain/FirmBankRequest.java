package com.depotpay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

/**
 * @author: DongMin Kim
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class FirmBankRequest {

    private final String firmBankRequestId; // 실물계좌 요청 ID
    private final String fromBankName; // 실물계좌를 요청할 은행명
    private final String fromBankAccountNumber; // 실물계좌를 요청할 계좌번호
    private final String toBankName; // b -> a 실물계좌로 요청을 하기 위한 Request 클래스
    private final String toBankAccountNumber; // b -> a 실물계좌로 요청을
    private final int moneyAmount; // 실물계좌로 요청할 금액
    private final int firmBankingStatus; // 실물계좌 요청 상태
    private final UUID uuid;

    public static FirmBankRequest generateFirmBankRequest(
            FirmBankRequest.FirmBankRequestId firmBankRequestId,
            FirmBankRequest.FormBankName formBankName,
            FirmBankRequest.FormBankAccountNumber formBankAccountNumber,
            FirmBankRequest.ToBankName toBankName,
            FirmBankRequest.ToBankAccountNumber toBankAccountNumber,
            FirmBankRequest.MoneyAmount moneyAmount,
            FirmBankRequest.FirmBankingStatus firmBankingStatus,
            UUID uuid) {
        return new FirmBankRequest(
                firmBankRequestId.firmBankRequestId,
                formBankName.formBankName,
                formBankAccountNumber.formBankAccountNumber,
                toBankName.toBankName,
                toBankAccountNumber.toBankAccountNumber,
                moneyAmount.moneyAmount,
                firmBankingStatus.firmBankingStatus,
                uuid
        );
    }

    @Value
    public static class FirmBankRequestId {
        String firmBankRequestId;

        public FirmBankRequestId(String firmBankRequestId) {
            this.firmBankRequestId = firmBankRequestId;
        }
    }

    @Value
    public static class FormBankName {
        String formBankName;

        public FormBankName(String formBankName) {
            this.formBankName = formBankName;
        }
    }

    @Value
    public static class FormBankAccountNumber {
        String formBankAccountNumber;

        public FormBankAccountNumber(String formBankAccountNumber) {
            this.formBankAccountNumber = formBankAccountNumber;
        }
    }

    @Value
    public static class ToBankName {
        String toBankName;

        public ToBankName(String toBankName) {
            this.toBankName = toBankName;
        }
    }

    @Value
    public static class ToBankAccountNumber {
        String toBankAccountNumber;

        public ToBankAccountNumber(String toBankAccountNumber) {
            this.toBankAccountNumber = toBankAccountNumber;
        }
    }

    @Value
    public static class MoneyAmount {
        int moneyAmount;

        public MoneyAmount(int moneyAmount) {
            this.moneyAmount = moneyAmount;
        }
    }

    @Value
    public static class FirmBankingStatus {
        int firmBankingStatus;

        public FirmBankingStatus(int firmBankingStatus) {
            this.firmBankingStatus = firmBankingStatus;
        }
    }
}
