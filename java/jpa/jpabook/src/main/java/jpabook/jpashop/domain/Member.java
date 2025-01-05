package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DongMin Kim
 */
@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private long id;
    @NotEmpty
    private String name;
    @Embedded
    private Address address;
    //mappedBy: 내가 연관관계의 주인이 아니라는 것을 의미
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
