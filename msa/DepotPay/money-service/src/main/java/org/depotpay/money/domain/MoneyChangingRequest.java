package org.depotpay.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Date;
import java.util.UUID;


/**
 * @author: DongMin Kim
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MoneyChangingRequest {

    private final String moneyChangingRequestId;
    // 어떤 고객의 증액/감액 요청을 요청했는지의 멤버 정보
    private final String targetMembershipId;
    // 그 요청이 증액 요청인지 / 감액 요청인지
    private final int moneyChangingType; // enum. 0: 증액, 1: 감액
    // 증액 또는 감액 요청의 금액
    private final int changingMoneyAmount;
    // 머니 변액 요청에 대한 상태
    private final int changingMoneyStatus; // enum 0: 요청, 1: 성공, 2: 실패
    private final String uuid;
    private final Date createdAt;

    public static MoneyChangingRequest generateMoneyChangingRequest(
            MoneyChangingRequest.MoneyChangingRequestId moneyChangingRequestId,
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.MoneyChangingType moneyChangingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.MoneyChangingMoneyStatus changingMoneyStatus,
            MoneyChangingRequest.Uuid uuid
    ) {
        return new MoneyChangingRequest(
                moneyChangingRequestId.getMoneyChangingRequestId(),
                targetMembershipId.getTargetMembershipId(),
                moneyChangingType.getMoneyChangingType(),
                changingMoneyAmount.getChangingMoneyAmount(),
                changingMoneyStatus.getChangingMoneyStatus(),
                uuid.getUuid(),
                new Date()
        );

    }


    @Value
    public static class MoneyChangingRequestId {
        public MoneyChangingRequestId(String moneyChangingRequestId) {
            this.moneyChangingRequestId = moneyChangingRequestId;
        }

        String moneyChangingRequestId;
    }

    @Value
    public static class TargetMembershipId {
        public TargetMembershipId(String targetMembershipId) {
            this.targetMembershipId = targetMembershipId;
        }

        String targetMembershipId;
    }

    @Value
    public static class MoneyChangingType {
        private final int moneyChangingType;

        public MoneyChangingType(int moneyChangingType) {
            this.moneyChangingType = moneyChangingType;
        }
    }

    @Value
    public static class ChangingMoneyAmount {
        private final int changingMoneyAmount;

        public ChangingMoneyAmount(int changingMoneyAmount) {
            this.changingMoneyAmount = changingMoneyAmount;
        }
    }

    @Value
    public static class MoneyChangingMoneyStatus {
        private final int changingMoneyStatus;

        public MoneyChangingMoneyStatus(int changingMoneyStatus) {
            this.changingMoneyStatus = changingMoneyStatus;
        }
    }

    @Value
    public static class Uuid {
        public Uuid(UUID uuid) {
            this.uuid = uuid.toString();
        }

        String uuid;
    }

    @Value
    public static class CreatedAt {
        public CreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        Date createdAt;
    }
}