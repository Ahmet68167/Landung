package Control;

import java.util.List;
import Main.Main;
import model.spieler.MenschSpieler;
import model.spieler.Spieler;
import model.spielfeld.Spielfeld;
import model.spielstein.Spielstein;

public class ControlSpiel {

	private Main main;
	private ControlZug controlZug;
	private int runde = 0;
	Spieler spieler1;
	Spieler spieler2;
	private String nameSpieler1;
	private String nameSpieler2;
	private char symbol1 = 'A';
	private char symbol2 = 'Z';
	private ControlEnum STATUS;
	private String typ;
	private String modus;
	private Spielfeld spielfeld;

	public ControlSpiel(Main main) {
		this.STATUS = STATUS.SPIELVORBEREITUNG;
		this.main = main;
		this.controlZug = new ControlZug(this);
	}

	public void starteSpiel(String input, String typ, String modus) {

		switch (STATUS) {

		case SPIELVORBEREITUNG:
			this.setTypModus(typ, modus);
			this.setSpielerNamen(input);
			this.initSpielMaterial();
			break;
		case SPIELRUNDE: // ;
			this.controlZug.nexterZug();
			break;
		case SPIELRUNDENENDE:
			this.runde--;
			
			break;
			
		default: // Fehler ung�ltiger Status;
			break;
		}

	}

	private void setTypModus(String typ, String modus) {
		if (this.typ == null && this.modus == null) {

			this.typ = typ;
			this.modus = modus;

			if (typ.equals("KI")) {
				this.nameSpieler1 = "KI";
			}

			if (modus.equals("BOO")) {
				this.runde = 1;
			} else if (modus.equals("BOOT")) {
				this.runde = 3;
			}
		}

	}

	private void initSpielMaterial() {
		if (nameSpieler1 != null && nameSpieler2 != null) {		
	
			this.spieler1 = new MenschSpieler(nameSpieler1,getSpielsteinListe(this.symbol1));
			this.spieler2 = new MenschSpieler(nameSpieler2,getSpielsteinListe(this.symbol2));
		}
		if(this.spielfeld == null){
			
			this.spielfeld = new Spielfeld();
			
		}

	}

	private List<Spielstein> getSpielsteinListe(char sym) {
		Spielstein liste = new Spielstein(sym);			
		return liste.getSpielsteinListe(9);
	}


	private void setSpielerNamen(String input) {

		if (this.nameSpieler1 == null && input.length() > 0) {

			this.nameSpieler1 = input;

		} else if (this.nameSpieler2 == null && input.length() > 0) {

			this.nameSpieler2 = input;

		} else if (this.nameSpieler2 != null && this.nameSpieler1 != null) {
			this.main.getOutput().print("Spieler 1:"+this.nameSpieler1);
			this.main.getOutput().print("Spieler 2:"+this.nameSpieler2);
			this.STATUS = STATUS.SPIELRUNDE;
		}
	}

	public void printStatus() {
		switch (STATUS) {

		case SPIELVORBEREITUNG:
			if (this.nameSpieler1 == null) {
				this.main.getOutput().print(
				        "Bitte Namen fuer Spieler 1 eingeben.\n");

			} else if (this.nameSpieler2 == null) {
				this.main.getOutput().print(
				        "Bitte Namen fuer Spieler 2 eingeben.\n");

			}
			break;
		case SPIELRUNDE: // ;
			this.controlZug.nexterZug();
			break;

		default: // Fehler ung�ltiger Status;
			break;
		}
	}

	/**
	 * @return the spieler1
	 */
	protected Spieler getSpieler1() {
		return spieler1;
	}

	/**
	 * @return the spieler2
	 */
	protected Spieler getSpieler2() {
		return spieler2;
	}

	/**
	 * @return the spielfeld
	 */
	protected Spielfeld getSpielfeld() {
		return spielfeld;
	}
}
