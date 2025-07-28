package org.depotpay.money.application.port.in;

import com.depotpay.common.UseCase;
import org.depotpay.money.domain.MoneyChangingRequest;

/**
 * @author: DongMin Kim
 */
@UseCase
public interface IncreaseMoneyRequestUseCase {
    MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);
}
