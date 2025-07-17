package com.depotpay.membership.application.port.in;

import com.depotpay.membership.domain.Membership;
import common.UseCase;

/**
 * @author: DongMin Kim
 */
@UseCase
public interface FindMembershipUserCase {
    Membership findMembership(FindMembershipCommand command);
}
