package Control;

import InputOutput.Output;
import Main.Main;

public class ControlMenu {
	// Speichert
	private ControlEnum STATUS;
	private Main main;
	private boolean gegenKI = false;
	private boolean gegenMensch = false;
	private boolean bestOfOne = false;
	private boolean bestOfThree = false;

	public ControlMenu(Main main) {
		this.main = main;
		this.STATUS = STATUS.HAUPTMENU;
	}

	public void checkInput(String input) {

		if (input != null) {

			switch (STATUS) {
			case HAUPTMENU:
				this.hauptmenu(input);
				break;
			case NEUESSPIEL:
				this.neuesSpiel(input);
				break;
			case LADEN: // ;
				this.ladeSpiel();
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

			default: // Fehler ungültiger Status;
				break;
			}
		}

	}

	public ControlEnum getSTATUS() {
		return STATUS;
	}

	private void spielerGegenKI(String input) {
		this.gegenKI = true;
		this.gegenMensch = false;
		// Best of One
		if (input.equals("a")) {
			this.STATUS = STATUS.BESTOFONE;
			// Best of Three
		} else if (input.equals("b")) {
			this.STATUS = STATUS.BESTOFTHREE;
		} else if (input.equals("c")) {
			this.STATUS = STATUS.NEUESSPIEL;
		}
	}

	private void hauptmenu(String input) {

		// Highscore
		if (input.equals("c")) {
			this.ladeHighscore();
			// Laden
		} else if (input.equals("b")) {
			this.ladeSpiel();

		} else if (input.equals("a")) {
			this.STATUS = STATUS.NEUESSPIEL;

		} else if (input.equals("d")) {
			this.STATUS = STATUS.ENDE;
			this.beenden();
		}

	}

	private void beenden() {

	}

	private void ladeSpiel() {
		STATUS = STATUS.SPIELLAEUFT;
	}

	private void spielerGegenSpieler(String input) {
		this.gegenMensch = true;
		this.gegenKI     = false;
	
		if (input.equals("a")) {
			this.STATUS = STATUS.BESTOFONE;	
		} else if (input.equals("b")) {
			this.STATUS = STATUS.BESTOFTHREE;
		} else if (input.equals("c")) {
			this.STATUS = STATUS.NEUESSPIEL;
		}

	}

	private void neuesSpiel(String input) {
		
		if (input.equals("a")) {
			this.STATUS = STATUS.SvsS;
		} else if (input.equals("b")) {
			this.STATUS = STATUS.SvsKI;
		} else if (input.equals("c")) {
			this.STATUS = STATUS.HAUPTMENU;
		}

	}

	private void bestOfThree(String input) {
		this.STATUS = STATUS.SPIELLAEUFT;
		this.bestOfOne = false;
		this.bestOfThree = true;
	
	}

	private void bestOfOne(String input) {
		this.STATUS = STATUS.SPIELLAEUFT;
		this.bestOfOne = true;
		this.bestOfThree = false;
	
	}

	private void ladeHighscore() {
		
		this.main.getOutput().print(this.main.getHighscore().toString());
		this.STATUS = STATUS.HAUPTMENU;

	}

	public void printStatus() {

		this.main.getOutput().print(STATUS.getName(), "console");

		switch (STATUS) {
		case HAUPTMENU:
			this.main.getOutput().print("a)  Neues Spiel", "console");
			this.main.getOutput().print("b)  Laden", "console");
			this.main.getOutput().print("c)  Highscore", "console");
			this.main.getOutput().print("d)  Beenden", "console");

			break;
		case NEUESSPIEL:
			this.main.getOutput().print("a)  Spieler gegen Spieler", "console");
			this.main.getOutput().print("b)  Spieler gegen KI", "console");
			this.main.getOutput().print("c)  Zurück", "console");

			break;
		case LADEN: // ;
			this.main.getOutput().print("Spiel laden.");
			break;
		case SvsS:
			this.main.getOutput().print("a)  Best of One", "console");
			this.main.getOutput().print("b)  Best of Three", "console");
			this.main.getOutput().print("c)  Zurück", "console");
			break;
		case SvsKI:
			this.main.getOutput().print("a)  Best of One", "console");
			this.main.getOutput().print("b)  Best of Three", "console");
			this.main.getOutput().print("c)  Zurück", "console");
			break;
		case BESTOFONE:

			break;
		case BESTOFTHREE:

			break;
		case SPIELLAEUFT:

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


}
