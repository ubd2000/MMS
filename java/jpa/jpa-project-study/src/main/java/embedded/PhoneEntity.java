package embedded;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ubd2000
 */
@Entity
public class PhoneEntity {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
