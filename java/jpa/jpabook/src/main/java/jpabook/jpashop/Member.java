package jpabook.jpashop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ubd2000
 */
@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    private long id;
    private String userName;

}
