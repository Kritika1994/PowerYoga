package PowerYogaApp.Participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import PowerYogaApp.Team.Team;
import PowerYogaApp.Team.TeamRepository;
import PowerYogaApp.Tournament.Tournament;
import PowerYogaApp.Tournament.TournamentRepository;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository participantRepository;
	
	@Autowired
	private TeamRepository teamDao;
	
	public void addParticipant(Participant user, int teamId) {
		Optional<Team> byId = teamDao.findById(teamId);
        if (!byId.isPresent()) {
        	throw new ResponseStatusException(
        			  HttpStatus.NOT_FOUND, "Team with id " + teamId + " not found"
        			);
        }
        Team team = byId.get();
        user.setTeam(team);
        participantRepository.save(user);
	}
	
	public void updateParticipant(Participant user, int teamId, int id) {
		Optional<Team> byId = teamDao.findById(teamId);
        if (!byId.isPresent()) {
        	throw new ResponseStatusException(
        			  HttpStatus.NOT_FOUND, "Team with id " + teamId + " not found"
        			);
        }
        Team team = byId.get();
        
        if (!participantRepository.existsById(id)) {
            throw new ResourceAccessException("Participant with id " + id + " not found");
        }
        user.setTeam(team);
        user.setId(id);
        participantRepository.save(user);
	}
	
	public void deleteParticipant(int id) {
		participantRepository.deleteById(id);
	}

	public List<Participant> getAllParticipants() {
		List<Participant> usersList = new ArrayList<Participant>();
		participantRepository.findAll().forEach(usersList::add);
		return usersList;
	}

	public List<Participant> getParticipantByTeam(int teamId) {
		return participantRepository.findByTeamId(teamId);
	}

	public Optional<Participant> getParticipantById(int id) {
		return participantRepository.findById(id);
	}
}
