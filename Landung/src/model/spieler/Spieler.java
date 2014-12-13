package model.spieler;

import java.util.List;

import model.spielstein.Spielstein;

public abstract class Spieler {

	private Spielstein spielstein;
	private String name;
	private int punkte;
	private int gesamtpunkte;
	
	public Spieler() {
		
	}	
	public Spieler(String name, Spielstein spielstein) {
		this.name = name;
		this.spielstein = spielstein;
		this.punkte = 0;
		this.gesamtpunkte = 0;
	}

	public Spielstein getSpielstein() {
		return this.spielstein;
	}
	
	public char getSymbol() {
		return this.spielstein.getSymbol();
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

	public void setGesamtpunkte(int gesamtpunkte) {
		this.gesamtpunkte = gesamtpunkte;
	}
	
	public int getGesamtpunkte() {
		return this.gesamtpunkte;
	}


}