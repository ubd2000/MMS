package valuetypecollection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code
        try {

            Member2 member = new Member2();
            member.setUsername("member1");
            member.setHomeAddress(new Address2("homeCity", "street1", "zipcode1"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddress2History().add(new AddressEntity("old1", "street", "zipcode"));
            member.getAddress2History().add(new AddressEntity("old2", "street", "zipcode"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("===========START============");
            Member2 findMember = em.find(Member2.class, member.getId());

            List<AddressEntity> address2History = findMember.getAddress2History();
            for (AddressEntity address2 : address2History) {
                System.out.println("address2 = " + address2.getAddress2().getCity());
            }

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }

            //homeCity -> newCity
            //값 타입 수정에 대한 안좋은 예시
//            findMember.getHomeAddress().setCity("newCity");

            //값 타입의 수정은 무조건 새로운 인스턴스를 만들어서 넣어줘야 한다.
            Address2 a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address2("newCity", a.getStreet(), a.getZipcode()));

            //치킨 -> 한식  (컬렉션 수정)
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            findMember.getAddress2History().remove(new AddressEntity("old1", "street", "zipcode"));
            findMember.getAddress2History().add(new AddressEntity("newCity1", "street", "zipcode"));

            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }

    }
}
