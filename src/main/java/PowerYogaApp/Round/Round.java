package PowerYogaApp.Round;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;

import PowerYogaApp.Team.Team;

//@Entity
public class Round {

	String id;
	String name;
	HashMap<Team, Score> participantTeams;
	
	public int MAX_SCORE;
	public Round(String id, String name,int score, List<Team> participantTeams) {
		super();
		this.id = id;
		this.name = name;
		this.MAX_SCORE = score;
		for(Team t: participantTeams) {
			this.participantTeams.put(t, new Score());
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object[] getParticipantTeams() {
		return participantTeams.keySet().toArray();
	}
	
}
