package com.depotpay.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * @author: DongMin Kim
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Membership {

    private final String membershipId;
    private final String name;
    private final String email;
    private final String address;
    private final boolean isValid;
    private final boolean isCorp;

    // Membership
    // 오염이 되면 안되는 클래스. 고객 정보 - 핵심 도메인

    public static Membership generateMember(MembershipId membershipId,
                                            MembershipName name,
                                            MembershipEmail email,
                                            MembershipAddress address,
                                            MembershipValid isValid,
                                            MembershipCorp isCorp) {
        return new Membership(membershipId.membershipId,
                name.name,
                email.email,
                address.address,
                isValid.isValid,
                isCorp.isCorp);
    }

    @Value
    public static class MembershipId {
        public MembershipId(String membershipId) {
            this.membershipId = membershipId;
        }

        String membershipId;
    }

    @Value
    public static class MembershipName {
        private final String name;

        public MembershipName(String name) {
            this.name = name;
        }
    }

    @Value
    public static class MembershipEmail {
        private final String email;

        public MembershipEmail(String email) {
            this.email = email;
        }
    }

    @Value
    public static class MembershipAddress {
        private final String address;

        public MembershipAddress(String address) {
            this.address = address;
        }
    }

    @Value
    public static class MembershipValid {
        private final boolean isValid;

        public MembershipValid(boolean isValid) {
            this.isValid = isValid;
        }
    }

    @Value
    public static class MembershipCorp {
        private final boolean isCorp;

        public MembershipCorp(boolean isCorp) {
            this.isCorp = isCorp;
        }
    }
}
