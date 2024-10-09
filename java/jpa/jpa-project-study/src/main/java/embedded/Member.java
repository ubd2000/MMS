package embedded;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author ubd2000
 */
@Getter
@Setter
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Embedded
    private Period workPeriod;
    @Embedded
    private Address homeAddress;
    //한 엔티티에서 같은 값 타입을 사용할 때는 @AttributeOverrides, @AttributeOverride를 사용해서 컬럼명을 재정의해야 한다.
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "COMPANY_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "COMPANY_ZIPCODE"))
    })
    private Address companyAddress;
}
