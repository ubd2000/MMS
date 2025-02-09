package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore //양방향 연관관계에서 한쪽을 JsonIgnore로 설정해야 한다.
    private Order order;

    private Address address;

    //Enumerated: Enum 타입을 매핑할 때 사용(ORDINAL: 숫자로 저장, STRING: 문자열로 저장)
    //String으로 저장하는 것을 권장
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}