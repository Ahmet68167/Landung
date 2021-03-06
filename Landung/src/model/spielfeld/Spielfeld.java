package model.spielfeld;

import model.spielstein.Spielstein;

public class Spielfeld {
	
	private final char EMPTY = '�';
	private final Spielstein LEER = new Spielstein(EMPTY);
	private int groesse;
	private Spielstein[][] spielbrett;
	
	/**
	 * @param spielbrett the spielbrett to set
	 */
	public void setSpielbrett(Spielstein[][] spielbrett) {
		this.spielbrett = spielbrett;
	}

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
		for(int zeile = 0; zeile < spielbrett.length; zeile++) {
			for(int spalte = 0; spalte < spielbrett[zeile].length; spalte++) {
				
				this.spielbrett[zeile][spalte] = LEER;
				
			}		
		}
	}

	public void setzeSpielstein(Spielstein spielstein, int[] pos) {
		this.spielbrett[pos[0]][pos[1]] = spielstein;
	}
	
	public Spielstein fetchSpielstein(int[] pos) {
		return this.spielbrett[pos[0]][pos[1]];
	}
	
	public void zieheSpielstein(int[] start, int[] ziel) {
		this.spielbrett[ziel[0]][ziel[1]] = entferneSpielstein(start);
	}
	
	public Spielstein entferneSpielstein(int[] pos) {
		Spielstein spielstein;
		spielstein = fetchSpielstein(pos);
		this.spielbrett[pos[0]][pos[1]] = LEER;
		return spielstein;
	}
	
	public boolean isEmpty() {
		boolean leer = true;
		int[] pos = new int[2];
		
		for(int zeile = 0; zeile < this.spielbrett.length; zeile++) {
			for(int spalte = 0; spalte < this.spielbrett[zeile].length; spalte++) {
				
				pos[0] = zeile;
				pos[1] = spalte;
				if(!isEmpty(pos))
					leer = false;
				
			}
		}
		
		return leer;
	}
	
	public boolean isEmpty(int[] pos) {
		return this.spielbrett[pos[0]][pos[1]].getSymbol() == EMPTY;
	}
	
	public int getAnzahlLeererFelder() {
		int anzahl = 0;
		int[] pos = new int[2];
		
		for(int zeile = 0; zeile < this.spielbrett.length; zeile++) {
			for(int spalte = 0; spalte < this.spielbrett[zeile].length; spalte++) {
				
				pos[0] = zeile;
				pos[1] = spalte;
				if(isEmpty(pos))
					anzahl++;				
			}
		}		
		return anzahl;
	}
	
	public int getGroesse() {
		return this.groesse;
	}
	
	public Spielstein[][] getSpielbrett() {
		return this.spielbrett;
	}
	
	public void clone(Spielfeld spielfeld) {
		for(int i = 0; i < this.spielbrett.length; i++) {
			this.spielbrett[i] = spielfeld.spielbrett[i].clone();
		}
	}
	
	public String toString() {
		String txt = "\n";
		
		for (int zeile = 0; zeile < this.spielbrett.length; zeile++) {
			txt += this.spielbrett.length - zeile + " ";
			
			for (int spalte = 0; spalte < this.spielbrett[zeile].length ; spalte++) {
				txt += this.spielbrett[spalte][this.spielbrett[zeile].length - 1 - zeile].getSymbol() + " ";
			}			
			txt += "\n";
		}		
		txt += "  a b c d e";
		
		return txt;
	}
	
	
}
