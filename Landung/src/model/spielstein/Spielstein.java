package model.spielstein;

import java.util.LinkedList;
import java.util.List;

public class Spielstein {
	
	private char symbol;
	private int[] pos;
	
	public Spielstein(char spielstein) {
		this.symbol = spielstein;
		int[] pos = {0, 0};
	}
	
	public List<Spielstein> getSpielsteinListe(int anzahl) {
		List<Spielstein> liste = new LinkedList<Spielstein>();
		
		for(int i = 0; i < anzahl; i++) {
			liste.add(new Spielstein(this.symbol));
		}
		
		return liste;
	}
	
	public List<Spielstein> getSpielsteinListe() {
		return getSpielsteinListe(9);
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
