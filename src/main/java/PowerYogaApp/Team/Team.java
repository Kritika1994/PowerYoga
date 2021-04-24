package PowerYogaApp.Team;

import java.util.ArrayList;
import java.util.List;

import PowerYogaApp.Participant.Participant;

public class Team {

	String id;
	String name;
	List<Participant> participants;
	static int MAX_CAPACITY=15;
	
	public Team(String id, String name, List<Participant> participants) {
		super();
		this.id = id;
		this.name = name;
		this.participants = participants == null? new ArrayList<Participant>(): participants;
	}
	
	public Team() {
		
		
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
	public List<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
}
