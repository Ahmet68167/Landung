package model.spieler;

import java.util.List;

import Control.ControlSpiel;
import Control.zugTest.Verwaltung;
import Control.zugTest.Zug;

public class ZufallsKi {

	private ControlSpiel controlspiel;
	private Verwaltung zug;
	
	public ZufallsKi(ControlSpiel controlspiel) {
		this.controlspiel = controlspiel;
		this.zug = new Verwaltung(this.controlspiel);
	}
	
	public String getKiBefehl() {
		List liste;
		liste = zug.alleZuege(this.controlspiel.getSpielfeld(), this.controlspiel.getIstDran());
		Zug a = (Zug) liste.get( (int) (Math.random()*liste.size()) );
		return a.getZug();
	}
	
	public ControlSpiel getControlSpiel() {
		return this.controlspiel;
	}
	
	public void setControlSpiel(ControlSpiel controlspiel) {
		this.controlspiel = controlspiel;
	}
	
}
