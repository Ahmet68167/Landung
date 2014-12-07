package model.spieler;

import java.util.List;

import model.spielstein.Spielstein;

public abstract class Spieler {
	
	private List<Spielstein> spielSteinListe;
	private final String name;
	     
	public Spieler(String name, List list) {     
		this.name = name;    
	    this.spielSteinListe = list;
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
	
	public String getName() {
		return this.name;
	}
	
}