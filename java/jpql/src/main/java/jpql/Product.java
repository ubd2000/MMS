package jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author dongm
 */
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;
    private int stockAmount;
}
