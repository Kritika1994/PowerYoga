package PowerYogaApp.Tournament;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import PowerYogaApp.Tournament.Tournament;
import PowerYogaApp.Tournament.TournamentService;

public class TournamentController {
	@Autowired
	private TournamentService TournamentService;

	@RequestMapping("/tournaments")
	public List<Tournament> getAllTournaments() {
		return TournamentService.getAllTournaments();

	}

	@RequestMapping("/tournament/{id}")
	public Tournament getTournament(@PathVariable String id) {
		return TournamentService.getTournament(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/tournament")
	public void addTournament(@RequestBody Tournament user) {
		TournamentService.addTournament(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/tournament/{id}")
	public void updateTournament(@RequestBody Tournament user, @PathVariable String id) {
		TournamentService.updateTournament(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/tournament/{id}")
	public void deleteTournament(@PathVariable String id) {
		TournamentService.deleteTournament(id);
	}
}
