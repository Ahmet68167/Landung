package model.spieler;

import java.util.List;

import model.spielstein.Spielstein;

public abstract class Spieler {

	private Spielstein spielstein;
	private String name;
	private int punkte;
	private int gesamtpunkte;
	private String input;
	private String typ;

	public Spieler() {

	}

	public Spieler(String name, int spielernummer, String typ) {
		this.name = name;
		this.punkte = 0;
		this.gesamtpunkte = 0;
		this.typ = typ;
		if (spielernummer == 1) {
			this.spielstein = new Spielstein('X');
		} else {
			this.spielstein = new Spielstein('O');
		}
	}

	public abstract String getBefehl();
	
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

	/**
	 * @param spielstein
	 *            the spielstein to set
	 */
	public void setSpielstein(Spielstein spielstein) {
		this.spielstein = spielstein;
	}

	public void setGesamtpunkte(int gesamtpunkte) {
		this.gesamtpunkte = gesamtpunkte;
	}

	public int getGesamtpunkte() {
		return this.gesamtpunkte;
	}
	
	public String getInput() {
		return this.input;
	}
	
	public void setInput(String input) {
		this.input = input;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

}