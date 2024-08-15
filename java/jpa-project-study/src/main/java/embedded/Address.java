package embedded;

import javax.persistence.Embeddable;

/**
 * @author ubd2000
 */
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;

    //Embeddable 선언 시, 다른 엔티티에 포함될 수 있음
    private PhoneEntity phoneEntity;

    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
