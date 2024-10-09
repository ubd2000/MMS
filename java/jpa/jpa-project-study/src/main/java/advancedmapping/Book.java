package advancedmapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author ubd2000
 */
@Entity
@Getter
@Setter
public class Book extends Item {
    private String author;
    private String isbn;
}
