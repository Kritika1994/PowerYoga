package PowerYogaApp.Participant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import PowerYogaApp.Round.Score.Status;
import PowerYogaApp.Team.Team;
import PowerYogaApp.Tournament.Tournament;

enum Gender { MALE, FEMALE }
@Entity
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "participant_id")
	int id;
	String name;
	String district;
	String email;
	String phoneNumber;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;
	
	public Participant() {
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
