package jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author dongm
 */
@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private int orderAmount;
    @Embedded
    private Address address;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
