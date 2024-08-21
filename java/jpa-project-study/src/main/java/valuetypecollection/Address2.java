package valuetypecollection;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * @author ubd2000
 */
@Embeddable
@Getter
@Setter
public class Address2 {
    private String city;
    private String street;
    private String zipcode;

    public Address2() {
    }

    public Address2(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address2 address2 = (Address2) o;
        return Objects.equals(getCity(), address2.getCity()) && Objects.equals(getStreet(), address2.getStreet()) && Objects.equals(getZipcode(), address2.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
