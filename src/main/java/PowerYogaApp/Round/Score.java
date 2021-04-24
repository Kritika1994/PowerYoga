package PowerYogaApp.Round;

public class Score {

	public Score(int teamScore) {
		super();
		this.teamScore = teamScore;
		this.teamStatus = Status.NOTPLAYED;
	}
	
	public Score() {
		super();
		this.teamScore = 0;
		this.teamStatus = Status.NOTPLAYED;
	}
	public int teamScore;
	public enum Status { NOTPLAYED, PLAYING, PLAYED } 
	Status teamStatus;
}
