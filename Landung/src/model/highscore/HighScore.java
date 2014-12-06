package model.highscore;

public class HighScore {

	private String name;
	private int punkte;
	
	public HighScore() {
		
	}
	
	public HighScore(String name, int punkte) {
		this.name = name;
		this.punkte = punkte;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPunkte() {
		return this.punkte;
	}
	
	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
	
	public String toString() {
		return this.name + " " + this.punkte;
	}

	
}
