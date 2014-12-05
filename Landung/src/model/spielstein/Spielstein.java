package model.spielstein;

public class Spielstein {
	
	private char spielstein;
	private int[] pos;
	
	public Spielstein(char spielstein) {
		this.spielstein = spielstein;
		int[] pos = {0, 0};
	}
	
	public char getSpielstein() {
		return this.spielstein;
	}
	
	public void setSpielstein(char spielstein) {
		this.spielstein = spielstein;
	}
	
	public int[] getPos() {
		return this.pos;
	}
	
	public void setPos(int[] pos) {
		this.pos = pos;
	}
	
}
