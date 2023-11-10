package univ.mql.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import univ.mql.entities.Match_foot;

public interface MatchRepository extends JpaRepository<Match_foot, Long> {
	List<Match_foot> findByDateMatch(LocalDate dateMatch);

	List<Match_foot> findByDateMatchBefore(LocalDate dateMatch);
}
