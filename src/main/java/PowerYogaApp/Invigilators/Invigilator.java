package PowerYogaApp.Invigilators;

import javax.validation.constraints.NotNull;

public class Invigilator {

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
	@NotNull
	private String id;
	private String name;
	
	public Invigilator() {
		++currID;
		id="Invig"+currID;
	}
	public Invigilator(String name) {
		super();
		++currID;
		id="Invig"+currID;
		this.name = name;
	}
	static int currID=0;
	
}
