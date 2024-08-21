package valuetypecollection;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * @author ubd2000
 */
@Embeddable
@Getter
@Setter
public class Period2 {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Period2() {
    }

    public Period2(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
