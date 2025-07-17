package com.depotpay.membership.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DongMin Kim
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMembershipRequest {
    private String membershipId;
}
