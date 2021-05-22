package PowerYogaApp.Tournament;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import PowerYogaApp.Participant.Participant;
import PowerYogaApp.Round.Round;
import PowerYogaApp.Team.Team;

@Entity
@Table(name = "tournament")
public class Tournament {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tournament_id")
	private Integer id;
	@Column(name="tournament_name")
	private String name;
	
	@OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY)
	List<Team> teams;
	
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name="tournament_id") List<Round> rounds;
	 */
	public Tournament() {
		super();
		teams = new ArrayList<Team>();
		//rounds = new ArrayList<Round>();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
