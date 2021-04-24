package PowerYogaApp.Participant;

public class Participant {

	
	String id;
	String name;
	String Address;
	String PhoneNumber;
	
	public Participant(String id, String name, String address, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
		PhoneNumber = phoneNumber;
	}
	
	public Participant() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
}
