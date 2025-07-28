package org.depotpay.money.adapter.out.persistence;

import com.depotpay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.depotpay.money.application.port.out.IncreaseMoneyPort;
import org.depotpay.money.domain.MemberMoney;
import org.depotpay.money.domain.MoneyChangingRequest;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @author: DongMin Kim
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

    private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;
    private final SpringDataMemberMoneyRepository memberMoneyRepository;

    @Override
    public MoneyChangingRequestJpaEntity createMoneyChangingRequest(MoneyChangingRequest.TargetMembershipId targetMembershipId, MoneyChangingRequest.MoneyChangingType moneyChangingType, MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount, MoneyChangingRequest.MoneyChangingMoneyStatus moneyChangingMoneyStatus, MoneyChangingRequest.Uuid uuid) {
        return moneyChangingRequestRepository.save(
                new MoneyChangingRequestJpaEntity(
                        targetMembershipId.getTargetMembershipId(),
                        moneyChangingType.getMoneyChangingType(),
                        changingMoneyAmount.getChangingMoneyAmount(),
                        new Timestamp(System.currentTimeMillis()),
                        moneyChangingMoneyStatus.getChangingMoneyStatus(),
                        UUID.randomUUID()
                )
        );
    }

    @Override
    public MemberMoneyJpaEntity increaseMoney(MemberMoney.MemberShipId memberShipId, int increaseMoneyAmount) {
        MemberMoneyJpaEntity entity;

        try {
            List<MemberMoneyJpaEntity> entityList = memberMoneyRepository.findByMemberShipId(Long.parseLong(memberShipId.getMemberShipId()));
            entity = entityList.get(0);

            entity.setBalance(entity.getBalance() + increaseMoneyAmount);
            return memberMoneyRepository.save(entity);

        } catch (Exception e) {
            // 예외 발생 시, 해당 멤버의 머니 정보가 없다고 간주
            entity = new MemberMoneyJpaEntity(
                    memberShipId.getMemberShipId(),
                    increaseMoneyAmount
            );
            entity = memberMoneyRepository.save(entity);
            return entity;
        }

    }
}
