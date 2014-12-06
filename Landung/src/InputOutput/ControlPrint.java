package InputOutput;

import Control.ControlEnum;
import Control.ControlMenu;

public class ControlPrint {

	private ControlEnum STATUS;
	private Output output;

	public ControlPrint(ControlMenu controlMenu, Output output) {
		this.STATUS = controlMenu.getSTATUS();
		this.output = output;

	}

	public void print() {

	

		switch (STATUS) {

		case HAUPTMENU:
			this.output.print("a)  Highscore", "console");
			this.output.print("b)  Laden", "console");
			this.output.print("c)  Neues Spiel", "console");
			this.output.print("d)  Beenden", "console");

			break;
		case NEUESSPIEL:
			this.output.print("a)  Spieler gegen Spieler", "console");
			this.output.print("b)  Spieler gegen KI", "console");
			this.output.print("c)  Hauptmenu", "console");

			break;
		case HIGHSCORE:

			break;
		case LADEN:

			break;
		case SvsS:

			break;
		case SvsKI:

			break;
		case BESTOFONE:

			break;
		case BESTOFTHREE:

			break;
		case SPIELLAEUFT:

			break;

		default:
			break;
		}
	}

}
