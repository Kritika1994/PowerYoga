package PowerYogaApp.Participant;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant,Integer>{

	List<Participant> findByTeamId(int tournamentId);
}
