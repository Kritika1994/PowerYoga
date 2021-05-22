package PowerYogaApp.Team;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import PowerYogaApp.Participant.Participant;
import PowerYogaApp.Tournament.Tournament;
import PowerYogaApp.Tournament.TournamentRepository;
import PowerYogaApp.Tournament.TournamentService;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	/*
	 * @RequestMapping(method=RequestMethod.POST , value="/team/{id}") public void
	 * addParticipant(@RequestBody String teamId,@PathVariable int
	 * tournamentId, @PathVariable String participantId) throws Exception {
	 * teamService.addParticipant(tournamentId, teamId, participantId); }
	 */
	@RequestMapping("/teams")
	public List<Team> getAllTeams() {
		return teamService.getAllTeams();
		
	}
	 
	@RequestMapping("/teams/{tournamentId}")
	public List<Team> getTeamByTournament(@PathVariable int tournamentId) {
		return teamService.getTeamByTournament(tournamentId);
	}
	
	@RequestMapping("/team/{id}")
	public Optional<Team> getTeamById(@PathVariable int id) {
		return teamService.getTeamById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/team/{tournamentId}")
	public void addTeam(@RequestBody Team team, @PathVariable int tournamentId) {
		teamService.addTeam(team, tournamentId);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/team/{tournamentId}/{id}")
	public void updateTeam(@RequestBody Team team,@PathVariable int tournamentId, @PathVariable int id) {
		teamService.updateTeam(tournamentId,id, team);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/team/{id}")
	public void deleteTeam(@PathVariable int id) {
		teamService.deleteTeam(id);	
	}
}
