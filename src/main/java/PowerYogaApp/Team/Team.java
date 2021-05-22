package PowerYogaApp.Team;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import PowerYogaApp.Participant.Participant;
import PowerYogaApp.Tournament.Tournament;
@Entity
@Table(name = "team")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="team_id")
	int id;
	@Column(name="team_name")
	String name;
	
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name="team_id" , referencedColumnName="team_id")
	 * List<Participant> participants;
	 */
	static int MAX_CAPACITY=15;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tournament tournament;
	
	public Tournament getTournament() {
		return tournament;
	}
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	public Team() {
		//this.participants = new ArrayList<Participant>();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * public List<Participant> getParticipants() { return participants; } public
	 * void setParticipants(List<Participant> participants) { this.participants =
	 * participants; }
	 */
}
