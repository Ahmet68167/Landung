package Control;

import Main.Main;

public class ControlMenu {
	// Speichert

	private Main main;
	private boolean gegenKI = false;
	private boolean gegenMensch = false;
	private boolean bestOfOne = false;
	private boolean bestOfThree = false;
	

	public ControlMenu(Main main) {
	 
		this.main = main;
	    
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

			default: // Fehler ung�ltiger Status;
				break;
			}
		}

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
			// Best of Three
		} else if (input.equals("b")) {
			Control.STATUS = Control.STATUS.BESTOFTHREE;
		} else if (input.equals("c")) {
			Control.STATUS = Control.STATUS.NEUESSPIEL;
		}
	}

	private void hauptmenu(String input) {

		// Highscore
		if (input.equals("c")) {
			this.ladeHighscore();
			// Laden
		} else if (input.equals("b")) {
			Control.STATUS = Control.STATUS.LADEN;

		} else if (input.equals("a")) {
			Control.STATUS = Control.STATUS.NEUESSPIEL;

		} else if (input.equals("d")) {
			Control.STATUS= Control.STATUS.ENDE;
		
		}

	}



	private void spielerGegenSpieler(String input) {
		this.gegenMensch = true;
		this.gegenKI     = false;
	
		if (input.equals("a")) {
			Control.STATUS =Control.STATUS.BESTOFONE;	
		} else if (input.equals("b")) {
			Control.STATUS =Control.STATUS.BESTOFTHREE;
		} else if (input.equals("c")) {
			Control.STATUS = Control.STATUS.NEUESSPIEL;
		}

	}

	private void neuesSpiel(String input) {
		
		if (input.equals("a")) {
			Control.STATUS = Control.STATUS.SvsS;
		} else if (input.equals("b")) {
			Control.STATUS = Control.STATUS.SvsKI;
		} else if (input.equals("c")) {
			Control.STATUS= Control.STATUS.HAUPTMENU;
		}

	}

	private void bestOfThree(String input) {
		Control.STATUS = Control.STATUS.SPIELVORBEREITUNG;
		this.bestOfOne = false;
		this.bestOfThree = true;
	
	}

	private void bestOfOne(String input) {
		Control.STATUS = Control.STATUS.SPIELVORBEREITUNG;
		this.bestOfOne = true;
		this.bestOfThree = false;
	
	}

	private void ladeHighscore() {
		
		this.main.getOutput().print(""+this.main.getHighscore().toString());
		Control.STATUS= Control.STATUS.HAUPTMENU;

	}

	public void printStatus() {

		this.main.getOutput().print(Control.STATUS.getName(), "console");

		switch (Control.STATUS) {
		case HAUPTMENU:
			this.main.getOutput().print("a)  Neues Spiel", "console");
			this.main.getOutput().print("b)  Laden", "console");
			this.main.getOutput().print("c)  Highscore", "console");
			this.main.getOutput().print("d)  Beenden", "console");

			break;
		case NEUESSPIEL:
			this.main.getOutput().print("a)  Spieler gegen Spieler", "console");
			this.main.getOutput().print("b)  Spieler gegen KI", "console");
			this.main.getOutput().print("c)  Zur�ck", "console");

			break;
		case LADEN: // ;
			this.main.getOutput().print("Spiel laden.");
			break;
		case SvsS:
			this.main.getOutput().print("a)  Best of One", "console");
			this.main.getOutput().print("b)  Best of Three", "console");
			this.main.getOutput().print("c)  Zur�ck", "console");
			break;
		case SvsKI:
			this.main.getOutput().print("a)  Best of One", "console");
			this.main.getOutput().print("b)  Best of Three", "console");
			this.main.getOutput().print("c)  Zur�ck", "console");
			break;
		case BESTOFONE:

			break;
		case BESTOFTHREE:

			break;
	

		default: // Fehler ung�ltiger Status;
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
