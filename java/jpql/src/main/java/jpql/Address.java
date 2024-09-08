package jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * @author dongm
 */
@Getter
@Setter
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
