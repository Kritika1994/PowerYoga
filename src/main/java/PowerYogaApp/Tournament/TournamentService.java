package PowerYogaApp.Tournament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import PowerYogaApp.Tournament.Tournament;

@Service
public class TournamentService {
	
	@Autowired
	TournamentRepository tournamentRepo;
	
	public void updateTournament(int tournamentId, Tournament tournament) {
		if (!tournamentRepo.existsById(tournamentId)) {
            throw new ResourceAccessException("Tournament with id " + tournamentId + " not found");
        }
        Optional<Tournament> author = tournamentRepo.findById(tournamentId);

        Tournament tour = author.get();
        tour.setName(tournament.getName());
        tournamentRepo.save(tour);
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
