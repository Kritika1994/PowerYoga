package PowerYogaApp.Participant;

import PowerYogaApp.Round.Score.Status;

public class Participant {

	
	String id;
	String name;
	String district;
	String email;
	String phoneNumber;
	public enum Gender { Male,Female } 
	Gender gender;
	static int currID=0;
	
	public Participant(String name,  String email, String phoneNumber,String district, String gender) {
		super();
		++currID;
		id="Participant"+currID;
		this.name = name;
		this.district = district;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender= gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("Male")? Gender.Male:Gender.Female;
	}

	
	public Participant() {
		++currID;
		id="Participant"+currID;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
