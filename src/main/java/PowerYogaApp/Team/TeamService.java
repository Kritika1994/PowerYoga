package PowerYogaApp.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import PowerYogaApp.Participant.Participant;
import PowerYogaApp.Participant.ParticipantService;
import PowerYogaApp.Tournament.Tournament;
import PowerYogaApp.Tournament.TournamentRepository;
import PowerYogaApp.Tournament.TournamentService;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TournamentRepository tournamentDao;
	/*
	 * public void addParticipant(int tournamentId,String teamId, String userId)
	 * throws Exception { Optional<Tournament> tournaments =
	 * tournamentService.getTournament(tournamentId); for(int
	 * i=0;i<teamsList.size();i++) {
	 * if(teamsList.get(i).getId().equalsIgnoreCase(teamId)) { List<Participant>
	 * participants = teamsList.get(i).getParticipants();
	 * if(participants.size()<=Team.MAX_CAPACITY)
	 * participants.add(participantService.getUser(userId)); else throw new
	 * Exception("Can't add more than 15 participants"); return; } } }
	 */
	
	public void addTeam(Team team, int tournamentId) {
		
		Optional<Tournament> byId = tournamentDao.findById(tournamentId);
        if (!byId.isPresent()) {
        	throw new ResponseStatusException(
        			  HttpStatus.NOT_FOUND, "Tournament with id " + tournamentId + " not found"
        			);
        }
        Tournament tournament = byId.get();
        team.setTournament(tournament);
        teamRepository.save(team);
	}
	
	public void deleteTeam(int teamId) {	
		teamRepository.deleteById(teamId);
	}
	
	public void updateTeam(int tournamentId, Team team) {
		
	}

	public List<Team> getAllTeams() {
		List<Team> teamsList = new ArrayList<Team>();
		teamRepository.findAll().forEach(teamsList::add);
		return teamsList;
	}
	
	public List<Team> getAllTeams(int tournamentId) {
		return teamRepository.findByTournamentId(tournamentId);
	}

	public Optional<Team> getTeamById(int id) {
		return teamRepository.findById(id);
	}

	public List<Team> getTeamByTournament(int tournamentId) {
		return teamRepository.findByTournamentId(tournamentId);
	}

	public void updateTeam(int tournamentId, int id, Team team) {
		Optional<Tournament> byId = tournamentDao.findById(tournamentId);
        if (!byId.isPresent()) {
        	throw new ResponseStatusException(
        			  HttpStatus.NOT_FOUND, "Tournament with id " + tournamentId + " not found"
        			);
        }
        Tournament tournament = byId.get();
        
        if (!teamRepository.existsById(id)) {
            throw new ResourceAccessException("Team with id " + id + " not found");
        }
        Optional<Team> temp = teamRepository.findById(id);

        Team original = temp.get();
        original.setName(team.getName());
        original.setTournament(tournament);
        teamRepository.save(original);
	}
}
