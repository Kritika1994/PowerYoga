package PowerYogaApp.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PowerYogaApp.Participant.Participant;
import PowerYogaApp.Participant.ParticipantService;

@Service
public class TeamService {

	@Autowired
	private ParticipantService participantService;
	
	private List<Team> teamsList = new ArrayList<>(Arrays.asList(new Team("teamid1", "Team-A",null),
				new Team("teamid2", "Team-B", null)));
	
	public void addParticipant(String teamId, String userId) {
		for(int i=0;i<teamsList.size();i++) {
			if(teamsList.get(i).getId().equalsIgnoreCase(teamId))
			{
				List<Participant> participants = teamsList.get(i).getParticipants();
				participants.add(participantService.getUser(userId));
				return;
			}
		}
	}
	
	public void addTeam(Team team) {		
		teamsList.add(team);
	}
	
	public void deleteTeam(String teamId) {		
		for(int i=0;i<teamsList.size();i++) {
			if(teamsList.get(i).getId().equalsIgnoreCase(teamId))
				teamsList.remove(i);
		}
	}
	
	public void updateTeam(String teamId, Team team) {		
		for(int i=0;i<teamsList.size();i++) {
			if(teamsList.get(i).getId().equalsIgnoreCase(teamId))
				teamsList.set(i, team);
		}
	}

	public List<Team> getAllTeams() {
		return teamsList;
	}

	public Team getTeam(String id) {
		return teamsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();	
	}


}
