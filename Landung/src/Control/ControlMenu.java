package Control;

import InputOutput.Output;

public class ControlMenu {
	// Speichert
	private ControlEnum STATUS;
	private Output output;

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
			case HIGHSCORE: // laden der HighScore und dann zurück zum Hauptmenu
				this.ladeHighscore();
				break;
			case LADEN: // ;
				this.spielLaden();
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
			case SPIELLAEUFT:
				this.spielLaeuft(input);
				break;

			default: // Fehler ungültiger Status;
				break;
			}
		}else{
			this.hauptmenu("");
		}
	}

	/**
	 * @return the sTATUS
	 */
	protected ControlEnum getSTATUS() {
		return STATUS;
	}

	/**
	 * @param sTATUS
	 *            the sTATUS to set
	 */
	protected void setSTATUS(ControlEnum sTATUS) {
		STATUS = sTATUS;
	}

	private void spielLaeuft(String input) {
		// TODO Auto-generated method stub

	}

	private void starteSpiel(String input, ControlEnum spielTyp) {

		// / Aufruf

	}

	private void spielerGegenKI(String input) {
		this.STATUS = STATUS.SPIELLAEUFT;
		this.starteSpiel(input, STATUS.SvsKI);

	}

	private void hauptmenu(String input) {

		this.output.print("a)  Highscore","console");
		this.output.print("b)  Laden","console");
		this.output.print("c)  Neues Spiel","console");
		this.output.print("d)  Beenden","console");
	
		// Highscore
		if (input.equals("a")) {
			this.STATUS = STATUS.HIGHSCORE;
			// Laden
		} else if (input.equals("b")) {
			this.STATUS = STATUS.LADEN;
			// Neues Spiel
		} else if (input.equals("c")) {
			this.STATUS = STATUS.NEUESSPIEL;
		}else if(input.equals("d")){
			this.STATUS = STATUS.ENDE;
		}

	}

	private void spielLaden() {
		// TODO Auto-generated method stub

	}

	private void spielerGegenSpieler(String input) {
		// Best of One
		if (input.equals("a")) {
			this.STATUS = STATUS.BESTOFONE;
			// Best of Three
		} else if (input.equals("b")) {
			this.STATUS = STATUS.BESTOFTHREE;
		}
	}

	private void neuesSpiel(String input) {
		// Spieler gegen Spieler
		if (input.equals("a")) {
			this.STATUS = STATUS.SvsS;
			// Spieler gegen KI
		} else if (input.equals("b")) {
			this.STATUS = STATUS.SvsKI;
		}

	}

	private void bestOfThree(String input) {
		this.STATUS = STATUS.SPIELLAEUFT;
		this.starteSpiel(input, STATUS.BESTOFTHREE);
	}

	private void bestOfOne(String input) {
		this.STATUS = STATUS.SPIELLAEUFT;
		this.starteSpiel(input, STATUS.BESTOFTHREE);
	}

	private void ladeHighscore() {
		System.out.println("Hier kommt die Highscore hin.");
		this.STATUS = STATUS.HAUPTMENU;

	}
}
