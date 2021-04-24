package PowerYogaApp.Invigilators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import PowerYogaApp.Participant.Participant;

@Service
public class InvigilatorService {

	List<Invigilator> invigilatorsList =  new ArrayList<>(Arrays.asList(new Invigilator("Invigilator1")));
	public List<Invigilator> getAllUsers() {
		return invigilatorsList;
	}

	public Invigilator getUser(String id) {
		return invigilatorsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();	
	}

	public void addInvigilator(Invigilator user) {
		invigilatorsList.add(user);
		
	}

	public void updateInvigilator(Invigilator user, String id) {		
		for(int i=0;i<invigilatorsList.size();i++) {
			if(invigilatorsList.get(i).getId().equalsIgnoreCase(id)) {
				invigilatorsList.set(i, user);
			}
		}
	}
	
}
