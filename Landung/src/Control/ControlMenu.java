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
		}
		
	}

	/**
	 * @return the sTATUS
	 */
	public ControlEnum getSTATUS() {
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
		this.checkInput(input);
	}

	private void hauptmenu(String input) {

		// Highscore
		if (input.equals("a")) {
			this.STATUS = STATUS.HIGHSCORE;
			// Laden
		} else if (input.equals("b")) {
			this.STATUS = STATUS.LADEN;
			
		} else if (input.equals("c")) {
			this.STATUS = STATUS.NEUESSPIEL;
		}else if(input.equals("d")){
			this.STATUS = STATUS.ENDE;
		}
		this.checkInput(input);
	}

	private void spielLaden() {
		STATUS = STATUS.SPIELLAEUFT;

	}

	private void spielerGegenSpieler(String input) {
		this.output.print("a)  Best of Three","console");
		this.output.print("b)  Best of One","console");
		this.output.print("c)  Hauptmenu","console");
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
