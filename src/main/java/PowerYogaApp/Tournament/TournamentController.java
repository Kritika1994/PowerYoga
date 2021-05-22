package PowerYogaApp.Tournament;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PowerYogaApp.Tournament.Tournament;
import PowerYogaApp.Tournament.TournamentService;

@RestController
public class TournamentController {
	/*
	 * @Autowired private TournamentService TournamentService;
	 * 
	 * @RequestMapping("/tournaments") public List<Tournament> getAllTournaments() {
	 * return TournamentService.getAllTournaments();
	 * 
	 * }
	 * 
	 * @RequestMapping("/tournament/{id}") public Tournament
	 * getTournament(@PathVariable String id) { return
	 * TournamentService.getTournament(id); }
	 * 
	 * @RequestMapping(method = RequestMethod.POST, value = "/tournament") public
	 * void addTournament(@RequestBody Tournament user) {
	 * TournamentService.addTournament(user); }
	 * 
	 * @RequestMapping(method = RequestMethod.PUT, value = "/tournament/{id}")
	 * public void updateTournament(@RequestBody Tournament user, @PathVariable
	 * String id) { TournamentService.updateTournament(id, user); }
	 * 
	 * @RequestMapping(method = RequestMethod.DELETE, value = "/tournament/{id}")
	 * public void deleteTournament(@PathVariable String id) {
	 * TournamentService.deleteTournament(id); }
	 */
	
	@Autowired
	private TournamentService tournamentService;

	@RequestMapping("/tournaments")
	public List<Tournament> getAllTournaments() {
		return tournamentService.getAllTournaments();

	}

	@RequestMapping("/tournament/{id}")
	public Optional<Tournament> getTournament(@PathVariable int id) {
		return tournamentService.getTournament(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/tournament")
	public void addTournament(@RequestBody Tournament user) {
		tournamentService.addTournament(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/tournament/{id}")
	public void updateTournament(@RequestBody Tournament user, @PathVariable int id) {
		tournamentService.updateTournament(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/tournament/{id}")
	public void deleteTournament(@PathVariable int id) {
		tournamentService.deleteTournament(id);
	}
}
