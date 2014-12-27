package model.spieler;

import java.util.List;

import Control.ControlSpiel;
import Control.zugTest.Verwaltung;
import Control.zugTest.Zug;

public class SchlaueKi {

	private ControlSpiel controlspiel;
	private Verwaltung zug;
	
	public SchlaueKi(ControlSpiel controlspiel) {
		this.controlspiel = controlspiel;
		this.zug = new Verwaltung(this.controlspiel);
	}
	
	public String getKiBefehl() {
		List liste;
		liste = zug.alleZuege(this.controlspiel.getSpielfeld(), this.controlspiel.getIstDran());
		Zug a = (Zug) liste.get(0);
		return a.getZug();
	}
	
	public ControlSpiel getControlSpiel() {
		return this.controlspiel;
	}
	
	public void setControlSpiel(ControlSpiel controlspiel) {
		this.controlspiel = controlspiel;
	}
	
}
