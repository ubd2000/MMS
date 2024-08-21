package embedded;

/**
 * @author ubd2000
 */
public class ValueMain {
    public static void main(String[] args) {
        Address address = new Address("city", "street", "zipcode");
        Address address2 = new Address("city", "street", "zipcode");
        System.out.println("address equals = " + address.equals(address2));
        System.out.println("address = " + address.hashCode());
    }
}
