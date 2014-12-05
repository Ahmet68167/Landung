package model.spielstein;

public class Spielstein {
	
	private char symbol;
	private int[] pos;
	
	public Spielstein(char spielstein) {
		this.symbol = spielstein;
		int[] pos = {0, 0};
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public void setSymbol(char spielstein) {
		this.symbol = spielstein;
	}
	
	public int[] getPos() {
		return this.pos;
	}
	
	public void setPos(int[] pos) {
		this.pos = pos;
	}
	
}
