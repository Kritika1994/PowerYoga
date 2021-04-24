package PowerYogaApp.Team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PowerYogaApp.Participant.Participant;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@RequestMapping(method=RequestMethod.POST , value="/team/{id}")
	public void addParticipant(@RequestBody String userId, @PathVariable String id) throws Exception {
		 teamService.addParticipant(id, userId);	
	}
	
	@RequestMapping("/teams")
	public List<Team> getAllTeams() {
		return teamService.getAllTeams();
		
	}
	
	@RequestMapping("/team/{id}")
	public Team getTeam(@PathVariable String id) {
		return teamService.getTeam(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/team")
	public void addTeam(@RequestBody Team user) {
		teamService.addTeam(user);	
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/team/{id}")
	public void updateTeam(@RequestBody Team user, @PathVariable String id) {
		teamService.updateTeam(id, user);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/team/{id}")
	public void deleteTeam(@PathVariable String id) {
		teamService.deleteTeam(id);	
	}
}
