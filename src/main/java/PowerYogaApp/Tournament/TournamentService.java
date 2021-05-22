package PowerYogaApp.Tournament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

import PowerYogaApp.Tournament.Tournament;

@Service
public class TournamentService {
	
	private List<Tournament> tournamentsList = new ArrayList<>(Arrays.asList(new Tournament("Tournament-A"),
				new Tournament("Tournament-B")));
	
	
	public void updateTournament(String tournamentId, Tournament tournament) {		
		for(int i=0;i<tournamentsList.size();i++) {
			if(tournamentsList.get(i).getId().equalsIgnoreCase(tournamentId))
				tournamentsList.set(i, tournament);
		}
	}

	public List<Tournament> getAllTournaments() {
		return tournamentsList;
	}

	public Tournament getTournament(String id) {
		return tournamentsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();	
	}

	public void deleteTournament(String id) {
		for(int i=0;i<tournamentsList.size();i++) {
			if(tournamentsList.get(i).getId().equalsIgnoreCase(id))
				tournamentsList.remove(i);
		}
	}
	public void addTournament(Tournament tournament) {
		tournamentsList.add(tournament);
		
	}

}
