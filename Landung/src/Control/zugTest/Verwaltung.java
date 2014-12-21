package Control.zugTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import Control.ControlSpiel;
import Control.ControlZug;
import model.spieler.MenschSpieler;
import model.spieler.Spieler;
import model.spielfeld.Spielfeld;
import model.spielstein.Spielstein;

public class Verwaltung {

	private ControlSpiel controlspiel;
	
	public Verwaltung(ControlSpiel controlspiel) {
		this.controlspiel = controlspiel;
	}
	
	public ControlSpiel getControlSpiel() {
		return this.controlspiel;
	}
	
	public void setControlSpiel(ControlSpiel controlspiel) {
		this.controlspiel = controlspiel;
	}
	
	public static List alleZuege(Spielfeld spielfeld, Spieler spieler, 
			ControlSpiel controlspiel, int anzahl) {
		int[] start = new int[2];
		int[] ziel = new int[2];
		int bewertung;
		List<Zug> zuege = new LinkedList<>();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				start[0] = i;
				start[1] = j;
				
				if(controlspiel.getRundeZug() < 3) {
					if(spielfeld.isEmpty(start)) {
						Spielfeld spiel = new Spielfeld();
						spiel.clone(spielfeld);
						spiel.setzeSpielstein(spieler.getSpielstein(), start);
						
						// Wenn Spieler == Spieler1 dann alleZuege von 
						// Spieler1 - alle Zuege von Spieler2 abziehen 
						// um die Bewertung auszurechnen
						if(anzahl < 1)
							bewertung = alleZuege(spiel, spieler, controlspiel, anzahl+1).size();
						else 
							bewertung = 0;
						Zug zug = new Zug("" + ( (char) (start[0] + 'a') ) + (start[1] + 1), bewertung);
						zuege.add(zug);
					}
					
				}
				
				for (int k = 0; k < 5; k++) {
					for (int m = 0; m < 5; m++) {
						
						ziel[0] = k;
						ziel[1] = m;
						
						 if(controlspiel.getRundeZug() >= 3) {
							if (gueltigerZug(start, ziel, spielfeld, spieler, controlspiel)) {
								
								Spielfeld spiel = new Spielfeld();
								spiel.clone(spielfeld);
								spiel.setzeSpielstein(spieler.getSpielstein(), ziel);
								
								if(anzahl < 1)
									bewertung = alleZuege(spiel, spieler, controlspiel, anzahl+1).size();
								else
									bewertung = 0;
								
								Zug zug = new Zug("" + ( (char) (start[0] + 'a') ) 
										+ (start[1] + 1) + ( (char) (ziel[0] + 'a') ) 
										+ (ziel[1] + 1), bewertung);
									zuege.add(zug);
							}
							
						}
					}
				}
			}
		}
		
		zuege.sort(new ZugComparator());
		return zuege;
	}
	
	
	public static boolean gueltigerZug(int[] start, int[] ziel, Spielfeld spielfeld,
			Spieler spieler, ControlSpiel controlspiel) {
		// Pruefe start
		if (spielfeld.fetchSpielstein(start).getSymbol() != spieler.getSymbol())
			return false;

		// Pruefe ziel
		if (!spielfeld.isEmpty(ziel))
			return false;

		// Teste Vertikal
		if (start[0] == ziel[0] && Math.abs(start[1] - ziel[1]) > 2) {
			if (start[1] - ziel[1] < 0)
				return testeVertikal(start, ziel, spielfeld);
			else if (start[1] - ziel[1] > 0)
				return testeVertikal(ziel, start, spielfeld);

			// Teste Horizontal
		} else if (start[1] == ziel[1] && Math.abs(start[0] - ziel[0]) > 2) {
			if (start[0] - ziel[0] < 0)
				return testeHorizontal(start, ziel, spielfeld);
			else if (start[0] - ziel[0] > 0)
				return testeHorizontal(ziel, start, spielfeld);

			// Teste Diagonal
		} else if (Math.abs(start[0] - ziel[0]) == 3
		        && Math.abs(start[1] - ziel[1]) == 3
		        || Math.abs(start[0] - ziel[0]) == 4
		        && Math.abs(start[1] - ziel[1]) == 4) {

			if (start[0] - ziel[0] < 0 && start[1] - ziel[1] < 0)
				return testeDiagonalOben(start, ziel, spielfeld);
			else if (start[0] - ziel[0] < 0 && start[1] - ziel[1] > 0)
				return testeDiagonalUnten(start, ziel, spielfeld);
			else if (start[0] - ziel[0] > 0 && start[1] - ziel[1] < 0)
				return testeDiagonalUnten(ziel, start, spielfeld);
			else if (start[0] - ziel[0] > 0 && start[1] - ziel[1] > 0)
				return testeDiagonalOben(ziel, start, spielfeld);
		}

		return false;
	}

	public static boolean testeVertikal(int[] start, int[] ziel, Spielfeld spielfeld) {
		int[] pos = new int[2];

		for (int i = 1; i < ziel[1] - start[1]; i++) {
			pos[0] = start[0];
			pos[1] = start[1] + i;
			if (!spielfeld.isEmpty(pos))
				return false;
		}

		return true;
	}

	public static boolean testeHorizontal(int[] start, int[] ziel, Spielfeld spielfeld) {
		int[] pos = new int[2];

		for (int i = 1; i < ziel[0] - start[0]; i++) {
			pos[0] = start[0] + i;
			pos[1] = start[1];
			if (!spielfeld.isEmpty(pos))
				return false;
		}

		return true;
	}

	public static boolean testeDiagonalOben(int[] start, int[] ziel, Spielfeld spielfeld) {
		int[] pos = new int[2];

		for (int i = 1; i < ziel[0] - start[0]; i++) {
			pos[0] = start[0] + i;
			pos[1] = start[1] + i;
			if (!spielfeld.isEmpty(pos))
				return false;
		}

		return true;
	}

	public static boolean testeDiagonalUnten(int[] start, int[] ziel, Spielfeld spielfeld) {
		int[] pos = new int[2];

		for (int i = 1; i <= ziel[0] - start[0]; i++) {
			pos[0] = start[0] + i;
			pos[1] = start[1] - i;
			if (!spielfeld.isEmpty(pos))
				return false;
		}

		return true;
	}
	
}
