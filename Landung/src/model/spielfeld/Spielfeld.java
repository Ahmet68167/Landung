package model.spielfeld;

import model.spielstein.Spielstein;

public class Spielfeld {
	
	private int groesse;
	private Spielstein[][] spielbrett;
	
	public Spielfeld(int groesse) {
		this.groesse = groesse;
		initialisiereSpielbrett();
	}
	
	public Spielfeld() {
		this(5);
	}
	
	private void initialisiereSpielbrett() {
		this.spielbrett = new Spielstein[this.groesse][this.groesse];
		leeren();
	}
	
	public void leeren() {
		Spielstein leer = new Spielstein('_');
		
		for(int zeile = 0; zeile < spielbrett.length; zeile++) {
			for(int spalte = 0; spalte < spielbrett[zeile].length; spalte++) {
				
				this.spielbrett[zeile][spalte] = leer;
				
			}		
		}
	}
	
	public void setzeSpielstein(Spielstein spielstein, int[] pos) {
		this.spielbrett[pos[0]][pos[1]] = spielstein;
	}
	
	public void entferneSpielstein(int[] pos) {
		Spielstein leer = new Spielstein('_');
		this.spielbrett[pos[0]][pos[1]] = leer;
	}
	
	public int getGroesse() {
		return this.groesse;
	}
	
	public Spielstein[][] getSpielstein() {
		return this.spielbrett;
	}
	
}
