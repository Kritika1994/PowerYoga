package PowerYogaApp.Tournament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PowerYogaApp.Tournament.Tournament;

@Service
public class TournamentService {
	
	/*
	 * private List<Tournament> tournamentsList = new ArrayList<>(Arrays.asList(new
	 * Tournament("Tournament-A"), new Tournament("Tournament-B")));
	 * 
	 * 
	 * public void updateTournament(String tournamentId, Tournament tournament) {
	 * for(int i=0;i<tournamentsList.size();i++) {
	 * if(tournamentsList.get(i).getId().equalsIgnoreCase(tournamentId))
	 * tournamentsList.set(i, tournament); } }
	 * 
	 * public List<Tournament> getAllTournaments() { return tournamentsList; }
	 * 
	 * public Tournament getTournament(String id) { return
	 * tournamentsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	 * }
	 * 
	 * public void deleteTournament(String id) { for(int
	 * i=0;i<tournamentsList.size();i++) {
	 * if(tournamentsList.get(i).getId().equalsIgnoreCase(id))
	 * tournamentsList.remove(i); } } public void addTournament(Tournament
	 * tournament) { tournamentsList.add(tournament);
	 * 
	 * }
	 */
	
	@Autowired
	TournamentRepository tournamentRepo;
	
	public void updateTournament(int tournamentId, Tournament tournament) {
		tournamentRepo.save(tournament);
	}

	public List<Tournament> getAllTournaments() {
		List<Tournament> tournamentsList = new ArrayList<Tournament>();
		tournamentRepo.findAll().forEach(tournamentsList::add);
		return tournamentsList;
	}

	public Optional<Tournament> getTournament(int id) {
		return tournamentRepo.findById(id);
	}

	public void deleteTournament(int id) {
		 tournamentRepo.deleteById(id);
	}
	public void addTournament(Tournament tournament) {
		tournamentRepo.save(tournament);
	}

}
