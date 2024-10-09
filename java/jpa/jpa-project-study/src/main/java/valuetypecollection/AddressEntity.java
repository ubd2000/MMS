package valuetypecollection;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ubd2000
 */
@Getter
@Setter
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id @GeneratedValue
    private Long id;
    private Address2 address2;

    public AddressEntity() {
    }

    public AddressEntity(String old2, String street, String zipcode) {
        this.address2 = new Address2(old2, street, zipcode);
    }

    public AddressEntity(Address2 address2) {
        this.address2 = address2;
    }
}
