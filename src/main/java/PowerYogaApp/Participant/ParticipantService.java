package PowerYogaApp.Participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

	private List<Participant> participantList = new ArrayList<>( Arrays.asList(new Participant("Kritika", "k@gmail.com","32423154231", "5,laxman colony", "F"),
			new Participant("Maggie","m@gmail.com","3243215321", "5,laxmancolony","F")));
	public List<Participant> getAllUsers() {
		return participantList;
		
	}
	
	public Participant getUser(String id) {
		return participantList.stream().filter(t -> t.getId().equals(id)).findFirst().get();	
	}
	
	public void addParticipant(Participant user) {
		participantList.add(user);
	}
	
	public void updateParticipant(Participant user, String id) {
		for(int i=0;i<participantList.size();i++) {
			if(participantList.get(i).getId().equalsIgnoreCase(id)) {
				participantList.set(i, user);
			}
		}
	}
	
	public void deleteParticipant(String id) {
		for(int i=0;i<participantList.size();i++) {
			if(participantList.get(i).getId().equalsIgnoreCase(id)) {
				participantList.remove(i);
			}
		}
		
	}
}
