package AdvancedMapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author ubd2000
 */
@Entity
@Getter
@Setter
public class Album extends Item {
    private String artist;
}
