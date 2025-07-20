package com.depotpay.membership.application.port.in;

import com.depotpay.common.UseCase;
import com.depotpay.membership.domain.Membership;

/**
 * @author: DongMin Kim
 */
@UseCase
public interface FindMembershipUserCase {
    Membership findMembership(FindMembershipCommand command);
}
