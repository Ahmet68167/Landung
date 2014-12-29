package model.spieler;

import java.util.List;

import Control.ControlZug;
import Control.zugTest.Verwaltung;
import Control.zugTest.Zug;

public class SchlaueKi {

	private ControlZug controlzug;
	private Verwaltung zug;
	
	public SchlaueKi(ControlZug controlzug) {
		this.controlzug = controlzug;
		this.zug = new Verwaltung(this.controlzug);
	}
	
	public String getBefehl() {
		List liste;
		liste = zug.alleZuege();
		Zug a = (Zug) liste.get(0);
		
		if(liste.size() == 0){
			return "";
		}
		return a.getZug();
	}
	
	public ControlZug getControlZug() {
		return this.controlzug;
	}
	
	public void setControlZug(ControlZug controlspiel) {
		this.controlzug = controlspiel;
	}
	
	public Verwaltung getZug() {
		return this.zug;
	}
	
	public void setZug(Verwaltung zug) {
		this.zug = zug;
	}
	
}
