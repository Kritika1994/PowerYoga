package PowerYogaApp.Invigilators;

public class Invigilator {

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String id;
	String name;
	
	public Invigilator(String name) {
		super();
		++currID;
		id="Invig"+currID;
		this.name = name;
	}
	static int currID=0;
	
}
