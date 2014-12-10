package model.spieler;

import java.util.List;

import model.spielstein.Spielstein;

public abstract class Spieler {

	private List<Spielstein> spielSteinListe;
	private String name;
	private int punkte;
	private int gesamtpunkte;
	
	public Spieler() {
		
	}	
	public Spieler(String name, List list) {
		this.name = name;
		this.spielSteinListe = list;
		this.punkte = 0;
		this.gesamtpunkte = 0;
	}

	public int getSpielSteinListeSize() {
		return spielSteinListe.size();
	}

	public void addSpielstein(Spielstein spielstein) {
		this.spielSteinListe.add(spielstein);
	}

	public Spielstein getSpielstein() {
		return this.spielSteinListe.remove(0);
	}
	
	public char getSymbol() {
		return this.spielSteinListe.get(0).getSymbol();
	}

	public boolean pruefeSpielstein(Spielstein spielstein){	
	
		return this.spielSteinListe.contains(spielstein);
	}

	public String getName() {
		return this.name;
	}

	/**
	 * @return the spielSteinListe
	 */
	public List<Spielstein> getSpielSteinListe() {
		return spielSteinListe;
	}
	/**
	 * @param spielSteinListe the spielSteinListe to set
	 */
	public void setSpielSteinListe(List<Spielstein> spielSteinListe) {
		this.spielSteinListe = spielSteinListe;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param gesamtpunkte the gesamtpunkte to set
	 */
	public void setGesamtpunkte(int gesamtpunkte) {
		this.gesamtpunkte = gesamtpunkte;
	}
	public int getPunkte() {
		return this.punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public int getGesamtpunkte() {
		return this.gesamtpunkte;
	}

	public void getGesamtpunkte(int gesamtpunkte) {
		this.gesamtpunkte = gesamtpunkte;
	}

}