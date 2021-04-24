package PowerYogaApp.Participant;

import java.util.List;

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
	
	@RequestMapping("/participant")
	public List<Participant> getAllUsers() {
		return participantService.getAllUsers();
		
	}
	
	@RequestMapping("/participant/{id}")
	public Participant getUser(@PathVariable String id) {
		return participantService.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/participant")
	public void addParticipant(@RequestBody Participant user) {
		 participantService.addParticipant(user);	
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/participant/{id}")
	public void updateParticipant(@RequestBody Participant user, @PathVariable String id) {
		 participantService.updateParticipant(user, id);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/participant/{id}")
	public void deleteParticipant(@PathVariable String id) {
		 participantService.deleteParticipant(id);	
	}
}
