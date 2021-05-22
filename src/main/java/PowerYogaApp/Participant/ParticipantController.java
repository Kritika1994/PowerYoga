package PowerYogaApp.Participant;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;
	
	@RequestMapping("/participants")
	public List<Participant> getAllParticipants() {
		return participantService.getAllParticipants();
	}
	
	@RequestMapping("/participants/{id}")
	public List<Participant> getParticipantByTeam(@PathVariable int teamId) {
		return participantService.getParticipantByTeam(teamId);
	}
	
	@RequestMapping("/participant/{id}")
	public Optional<Participant> getParticipantById(@PathVariable int id) {
		return participantService.getParticipantById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/participant/{teamId}")
	public void addParticipant(@RequestBody Participant user, @PathVariable int teamId) {
		 participantService.addParticipant(user,teamId);	
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/participant/{teamId}/{id}")
	public void updateParticipant(@RequestBody Participant user,@PathVariable int teamId, @PathVariable int id) {
		 participantService.updateParticipant(user,teamId, id);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/participant/{id}")
	public void deleteParticipant(@PathVariable int id) {
		 participantService.deleteParticipant(id);	
	}
}
