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
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int age;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}
