package PowerYogaApp.Tournament;

import javax.validation.constraints.NotNull;

public class Tournament {

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
	
	public Tournament() {
		++currID;
		id="Tournament"+currID;
	}
	public Tournament(String name) {
		super();
		++currID;
		id="Invig"+currID;
		this.name = name;
	}
	static int currID=0;
}
