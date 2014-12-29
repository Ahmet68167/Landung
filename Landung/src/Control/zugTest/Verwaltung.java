package Control.zugTest;

import java.util.LinkedList;
import java.util.List;
import Control.ControlZug;
import model.spieler.Spieler;
import model.spielfeld.Spielfeld;

public class Verwaltung {

	private ControlZug controlzug;
	
	public Verwaltung(ControlZug controlzug) {
		this.controlzug = controlzug;
	}
	
	public ControlZug getControlZug() {
		return this.controlzug;
	}
	
	public void setControlZug(ControlZug controlzug) {
		this.controlzug = controlzug;
	}
	
	public List alleZuege() {
		return alleZuege(this.controlzug, this.controlzug.getControlSpiel().getIstDran(), 0);
	}
	
	private List alleZuege(ControlZug controlzug, Spieler spieler, int anzahl) {
		int[] start = new int[2];
		int[] ziel = new int[2];
		int bewertung;
		List<Zug> zuege = new LinkedList<>();
		Spielfeld tmp = controlzug.getControlSpiel().getSpielfeld();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				start[0] = i;
				start[1] = j;
				
				if(controlzug.getControlSpiel().getRundeZug() < 3) {
					if(controlzug.getControlSpiel().getSpielfeld().isEmpty(start)) {
						Spielfeld spiel = new Spielfeld();
						spiel.clone(controlzug.getControlSpiel().getSpielfeld());
						controlzug.getControlSpiel().setSpielfeld(spiel);
						spiel.setzeSpielstein(spieler.getSpielstein(), start);
						
						if(anzahl < 1) {
							bewertung = alleZuege(controlzug, spieler, anzahl+1).size();
							this.controlzug.getControlSpiel().naechsterSpieler();
							bewertung -= alleZuege(controlzug, spieler, anzahl+1).size();
							this.controlzug.getControlSpiel().naechsterSpieler();
						} else 
							bewertung = 0;
						Zug zug = new Zug("" + ( (char) (start[0] + 'a') ) + (start[1] + 1), bewertung);
						zuege.add(zug);
						controlzug.getControlSpiel().setSpielfeld(tmp);
					}
					
				}
				
				for (int k = 0; k < 5; k++) {
					for (int m = 0; m < 5; m++) {
						
						ziel[0] = k;
						ziel[1] = m;
						
						 if(controlzug.getControlSpiel().getRundeZug() >= 3) {
							if (controlzug.gueltigerZug(start, ziel)) {
								
								Spielfeld spiel = new Spielfeld();
								spiel.clone(controlzug.getControlSpiel().getSpielfeld());
								controlzug.getControlSpiel().setSpielfeld(spiel);
								String eingabe = "" + (char) (start[0] + 'a') 
										+ (start[1] + 1) + (char) (ziel[0] + 'a') 
										+ (ziel[1] + 1);
								controlzug.macheZug(eingabe);
								
								if(anzahl < 1) {
									bewertung = alleZuege(controlzug, spieler, anzahl+1).size();
									this.controlzug.getControlSpiel().naechsterSpieler();
									bewertung -= alleZuege(controlzug, spieler, anzahl+1).size();
									this.controlzug.getControlSpiel().naechsterSpieler();
								} else 
									bewertung = 0;
								
								Zug zug = new Zug("" + ( (char) (start[0] + 'a') ) 
										+ (start[1] + 1) + ( (char) (ziel[0] + 'a') ) 
										+ (ziel[1] + 1), bewertung);
								zuege.add(zug);
								controlzug.getControlSpiel().setSpielfeld(tmp);
							}
							
						}
					}
				}
			}
		}
		
		controlzug.getControlSpiel().setSpielfeld(tmp);
		zuege.sort(new ZugComparator());
		return zuege;
	}
	
}
