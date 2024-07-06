package AdvancedMapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author ubd2000
 */
@Entity
@Getter
@Setter
//@Inheritance(strategy=InheritanceType.JOINED) //조인 전략
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //단순 테이블 전략
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) //구현 클래스마다 테이블 전략
@DiscriminatorColumn
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String name;
    private int price;

}
