package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.Team;

/**
 * @author DongMin Kim
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

}
