package org.depotpay.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;


/**
 * @author: DongMin Kim
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MemberMoney {

    private final String memberMoneyId;
    private final String memberShipId;
    private final int balance;

    public static MemberMoney generateMemberMoney(
            MemberMoney.MemberMoneyId memberMoneyId,
            MemberMoney.MemberShipId memberShipId,
            MemberMoney.MemberBalance memberBalance
    ) {
        return new MemberMoney(
                memberMoneyId.getMemberMoneyId(),
                memberShipId.getMemberShipId(),
                memberBalance.getMemberBalance()
        );
    }

    @Value
    public static class MemberMoneyId {
        public MemberMoneyId(String memberMoneyId) {
            this.memberMoneyId = memberMoneyId;
        }

        String memberMoneyId;
    }

    @Value
    public static class MemberShipId {
        public MemberShipId(String memberShipId) {
            this.memberShipId = memberShipId;
        }

        String memberShipId;
    }

    @Value
    public static class MemberBalance {
        public MemberBalance(int memberBalance) {
            this.memberBalance = memberBalance;
        }

        int memberBalance;
    }
}