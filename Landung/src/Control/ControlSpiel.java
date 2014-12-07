package Control;

import Main.Main;
import model.spieler.MenschSpieler;
import model.spieler.Spieler;


public class ControlSpiel {

	private Main main;
	private String nameSpieler1;
	private String nameSpieler2;
	private boolean isNameSpieler;
	private boolean vobereitung;
	private ControlZug controlZug;
	private int runde = 0;
	 Spieler spieler1;
	 Spieler spieler2;

	public ControlSpiel(Main main) {

		this.main = main;
		this.isNameSpieler = false;
		this.controlZug = new ControlZug(this);
	}

	public void starteSpiel(String input, String typ, String modus) {

		if (!vobereitung) {
			if (typ.equals("KI")) {
				this.nameSpieler1 = "KI";
			}

			if (modus.equals("BOO")) {
				this.runde = 1;
			} else if (modus.equals("BOOT")) {
				this.runde = 3;
			}

			if (!isNameSpieler) {
				this.setSpielerNamen(input);
			} else {
				this.vobereitung = true;
			}

			this.initSpielMaterial();

		} else {

			this.controlZug.nexterZug();

		}

	}

	private void initSpielMaterial() {
		this.spieler1 = new MenschSpieler(nameSpieler1, null);
		this.spieler2 = new MenschSpieler(nameSpieler2, null);

	}

	private void setSpielerNamen(String input) {

		this.main.getOutput().print("Bitte Namen eingeben.\n");

		if (this.nameSpieler1 == null) {
			this.main.getOutput().print("Name Spieler 1: ");

			this.nameSpieler1 = input;

		} else if (this.nameSpieler2 == null) {
			this.main.getOutput().print("Name Spieler 2: ");

			this.nameSpieler2 = input;
			this.isNameSpieler = true;
			this.main.getOutput().print("Die Eingegebenen Namen: ");
			this.main.getOutput().print("Spieler 1 :" + this.nameSpieler1);
			this.main.getOutput().print("Spieler 2 :" + this.nameSpieler2);
		}

	}

}
