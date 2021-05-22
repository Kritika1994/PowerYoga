package PowerYogaApp.Team;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team,Integer>{

	List<Team> findByTournamentId(int tournamentId);
}
