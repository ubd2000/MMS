package org.depotpay.money.application.port.out;


import org.depotpay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import org.depotpay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import org.depotpay.money.domain.MemberMoney;
import org.depotpay.money.domain.MoneyChangingRequest;

/**
 * @author: DongMin Kim
 */
public interface IncreaseMoneyPort {
    MoneyChangingRequestJpaEntity createMoneyChangingRequest(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.MoneyChangingType moneyChangingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.MoneyChangingMoneyStatus moneyChangingMoneyStatus,
            MoneyChangingRequest.Uuid uuid
    );

    MemberMoneyJpaEntity increaseMoney(
            MemberMoney.MemberShipId memberShipId,
            int increaseMoneyAmount
    );
}
