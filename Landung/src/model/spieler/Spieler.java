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

	public Spieler(String name, int spielernummer) {
		this.name = name;

		this.punkte = 0;
		this.gesamtpunkte = 0;
		if (spielernummer == 1) {
			this.spielstein = new Spielstein('X');
		} else {
			this.spielstein = new Spielstein('O');
		}
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

}