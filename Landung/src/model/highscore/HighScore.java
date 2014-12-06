package model.highscore;

public class HighScore {
	
	private String name;
	private int punkte;
	
	public HighScore(String name, int punkte) {
		this.name = name;
		this.punkte = punkte;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPunkte() {
		return this.punkte;
	}
	
	public String toString() {
		return this.name + " " + this.punkte;
	}
	
}
