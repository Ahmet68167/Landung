package Control;

import java.util.LinkedList;

import Main.Main;
import model.spieler.MenschSpieler;
import model.spieler.Spieler;
import model.spielstein.Spielstein;

public class ControlSpiel {

	private Main main;
	private String nameSpieler1;
	private String nameSpieler2;

	private ControlZug controlZug;
	private int runde = 0;
	Spieler spieler1;
	Spieler spieler2;
	private ControlEnum STATUS;
	private String typ;
	private String modus;

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

		default: // Fehler ungültiger Status;
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
			LinkedList<Spielstein> tmp = new LinkedList<>();
			tmp.add(new Spielstein('X'));
			tmp.add(new Spielstein('X'));
			this.spieler1 = new MenschSpieler(nameSpieler1, tmp);
			this.spieler2 = new MenschSpieler(nameSpieler2, tmp);
		}

	}

	private void setSpielerNamen(String input) {

		if (this.nameSpieler1 == null && input.length() > 0) {

			this.nameSpieler1 = input;

		} else if (this.nameSpieler2 == null && input.length() > 0) {

			this.nameSpieler2 = input;

		} else if (this.nameSpieler2 != null && this.nameSpieler1 != null) {

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

		default: // Fehler ungültiger Status;
			break;
		}
	}
}
