package Control;

import InputOutput.Output;

public class ControlMenu {
	// Speichert
	private ControlEnum STATUS;
	private Output output;
	private boolean gegenKI = false;
	private boolean gegenMensch = false;
	private boolean bestOfOne = false;
	private boolean bestOfThree = false;

	public ControlMenu(Output output) {
		this.output = output;
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
		System.out.println("Hier kommt die Highscore hin.");
		this.STATUS = STATUS.HAUPTMENU;

	}

	public void printStatus() {

		this.output.print(STATUS.getName(), "console");

		switch (STATUS) {
		case HAUPTMENU:
			this.output.print("a)  Neues Spiel", "console");
			this.output.print("b)  Laden", "console");
			this.output.print("c)  Highscore", "console");
			this.output.print("d)  Beenden", "console");

			break;
		case NEUESSPIEL:
			this.output.print("a)  Spieler gegen Spieler", "console");
			this.output.print("b)  Spieler gegen KI", "console");
			this.output.print("c)  Zurück", "console");

			break;
		case LADEN: // ;

			break;
		case SvsS:
			this.output.print("a)  Best of One", "console");
			this.output.print("b)  Best of Three", "console");
			this.output.print("c)  Zurück", "console");
			break;
		case SvsKI:
			this.output.print("a)  Best of One", "console");
			this.output.print("b)  Best of Three", "console");
			this.output.print("c)  Zurück", "console");
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
