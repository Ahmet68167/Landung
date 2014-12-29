package Control;

import Main.Main;

public class ControlMenu {
	// Speichert
	private Main main;
	private boolean gegenKI = false;
	private boolean gegenMensch = false;
	private boolean bestOfOne = false;
	private boolean bestOfThree = false;
	private Control control;
	private Spielanleitung spielanleitung;
	private String kiStufe;

	public ControlMenu(Main main, Control control) {
		this.control = control;
		this.main = main;
		this.spielanleitung = new Spielanleitung();
	}

	public void checkInput(String input) {

		if (input != null) {

			switch (Control.STATUS) {
			case HAUPTMENU:
				this.hauptmenu(input);
				break;
			case NEUESSPIEL:
				this.neuesSpiel(input);
				break;
			case SvsS:
				this.spielerGegenSpieler(input);
				break;
			case SvsKI:
				this.spielerGegenKI(input);
				break;
			case BESTOFONE:
				this.bestOfOne(input);
				break;
			case BESTOFTHREE:
				this.bestOfThree(input);
				break;
			case SPIELANLEITUNG:
				this.spielanleitung();
				break;
			case KISTUFE:
				this.kiStufe(input);
				break;

			default: // Fehler ungültiger Status;
				break;
			}
		}

	}

	private void spielanleitung() {

		this.main.getOutput().print(this.spielanleitung.getSpielanleitung());
		Control.STATUS = Control.STATUS.HAUPTMENU;
		this.checkInput("");

	}

	public ControlEnum getSTATUS() {
		return Control.STATUS;
	}

	private void spielerGegenKI(String input) {
		this.gegenKI = true;
		this.gegenMensch = false;
		// Best of One

		if (input.equals("a")) {
			Control.STATUS = Control.STATUS.BESTOFONE;
			this.control.checkInput("");
			// Best of Three
		} else if (input.equals("b")) {
			Control.STATUS = Control.STATUS.BESTOFTHREE;
			this.control.checkInput("");
		} else if (input.equals("c")) {
			Control.STATUS = Control.STATUS.NEUESSPIEL;
		} else {
			this.main.getOutput().print("Fehler: ungültige Eingabe");
		}
	}

	private void hauptmenu(String input) {

		// Highscore
		if (input.equals("c")) {
			this.ladeHighscore();
			// Laden
		} else if (input.equals("b")) {
			Control.STATUS = Control.STATUS.LADENAUSWAHL;

		} else if (input.equals("a")) {
			Control.STATUS = Control.STATUS.NEUESSPIEL;

		} else if (input.equals("e")) {
			Control.STATUS = Control.STATUS.ENDE;

		} else if (input.equals("d")) {
			this.spielanleitung();
		}

	}

	private void spielerGegenSpieler(String input) {
		this.gegenMensch = true;
		this.gegenKI = false;

		if (input.equals("a")) {
			Control.STATUS = Control.STATUS.BESTOFONE;
			this.control.checkInput("");
		} else if (input.equals("b")) {
			Control.STATUS = Control.STATUS.BESTOFTHREE;
			this.control.checkInput("");
		} else if (input.equals("c")) {
			Control.STATUS = Control.STATUS.NEUESSPIEL;
		} else {
			this.main.getOutput().print("Fehler: ungültige Eingabe");
		}

	}

	private void neuesSpiel(String input) {

		if (input.equals("a")) {
			Control.STATUS = Control.STATUS.SvsS;
		} else if (input.equals("b")) {
			Control.STATUS = Control.STATUS.SvsKI;
		} else if (input.equals("c")) {
			Control.STATUS = Control.STATUS.HAUPTMENU;
		} else {
			this.main.getOutput().print("Fehler: ungültige Eingabe");
		}

	}

	private void kiStufe(String input) {
		if (input.equals("a") || input.equals("b") || input.equals("c")) {
			Control.STATUS = Control.STATUS.SPIELVORBEREITUNG;
			this.kiStufe = input;
		}else {
			this.main.getOutput().print("Fehler: ungültige Eingabe");
		}
	}

	private void bestOfThree(String input) {
		if (this.gegenKI) {
			Control.STATUS = Control.STATUS.KISTUFE;
		} else {
			Control.STATUS = Control.STATUS.SPIELVORBEREITUNG;
		}

		this.bestOfOne = false;
		this.bestOfThree = true;
	}

	/**
	 * @return the kiStufe
	 */
	public String getKiStufe() {
		return kiStufe;
	}

	/**
	 * @param kiStufe the kiStufe to set
	 */
	public void setKiStufe(String kiStufe) {
		this.kiStufe = kiStufe;
	}

	private void bestOfOne(String input) {
		if (this.gegenKI) {
			Control.STATUS = Control.STATUS.KISTUFE;
		} else {
			Control.STATUS = Control.STATUS.SPIELVORBEREITUNG;
		}
		this.bestOfOne = true;
		this.bestOfThree = false;
	}

	private void ladeHighscore() {
		this.main.getHighscore().ladeListe();
		this.main.getOutput().print(
		        "Highscore\n" + this.main.getHighscore().toString());
		Control.STATUS = Control.STATUS.HAUPTMENU;
	}

	public void printStatus() {

		switch (Control.STATUS) {
		case HAUPTMENU:
			this.main.getOutput().print(Control.STATUS.getName(), "console");
			this.main.getOutput().print("[a]  Neues Spiel", "console");
			this.main.getOutput().print("[b]  Laden", "console");
			this.main.getOutput().print("[c]  Highscore", "console");
			this.main.getOutput().print("[d]  Spielanleitung", "console");
			this.main.getOutput().print("[e]  Beenden", "console");
			this.main
			        .getOutput()
			        .print("\n Info:\t Speichern nur wärend des Spiels.\n\t Druch Eingabe von \"speichern\"",
			                "console");
			break;
		case NEUESSPIEL:
			this.main.getOutput().print(Control.STATUS.getName(), "console");
			this.main.getOutput()
			        .print("[a]  Spieler gegen Spieler", "console");
			this.main.getOutput().print("[b]  Spieler gegen KI", "console");
			this.main.getOutput().print("[c]  Zurück", "console");
			break;
		case SvsS:
			this.main.getOutput().print(Control.STATUS.getName(), "console");
			this.main.getOutput().print("[a]  Best of One", "console");
			this.main.getOutput().print("[b]  Best of Three", "console");
			this.main.getOutput().print("[c]  Zurück", "console");
			break;
		case SvsKI:
			this.main.getOutput().print(Control.STATUS.getName(), "console");
			this.main.getOutput().print("[a]  Best of One", "console");
			this.main.getOutput().print("[b]  Best of Three", "console");
			this.main.getOutput().print("[c]  Zurück", "console");
			break;

		case BESTOFONE:

			break;
		case BESTOFTHREE:

			break;
		case KISTUFE:
			this.main.getOutput().print(Control.STATUS.getName(), "console");
			this.main.getOutput().print("Bitte die Stufe der KI angeben:");
			this.main.getOutput().print("[a] leicht");
			this.main.getOutput().print("[b] mittel");
			this.main.getOutput().print("[c] schwer");
			break;
		default: // Fehler ungültiger Status;
			break;
		}
	}

	/**
	 * @return the gegenKI
	 */
	protected boolean isGegenKI() {
		return gegenKI;
	}

	/**
	 * @return the gegenMensch
	 */
	protected boolean isGegenMensch() {
		return gegenMensch;
	}

	/**
	 * @return the bestOfOne
	 */
	protected boolean isBestOfOne() {
		return bestOfOne;
	}

	/**
	 * @return the bestOfThree
	 */
	protected boolean isBestOfThree() {
		return bestOfThree;
	}

	void reset() {
		this.gegenKI = false;
		this.gegenMensch = false;
		this.bestOfOne = false;
		this.bestOfThree = false;
	}

}
