package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author DongMin Kim
 */
@Entity
@Getter
@Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
    private Address address;
    //Enumerated: Enum 타입을 매핑할 때 사용(ORDINAL: 숫자로 저장, STRING: 문자열로 저장)
    //String으로 저장하는 것을 권장
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}