package Control;

import tunier.Gruppe3.IGame;
import InputOutput.Output;
import Main.Main;

public class Control {
	ControlMenu controleMenu;
	ControlSpiel controlSpiel;
	private Main main;
	public static ControlEnum STATUS;

	public Control(Main main) {
		this.main = main;
		this.STATUS = STATUS.HAUPTMENU;
		this.controleMenu = new ControlMenu(main, this);
		this.controlSpiel = new ControlSpiel(main);
	}

	public void checkInput(String input) {

		this.setupControle();
		this.controleMenu.checkInput(input);
		this.controlSpiel.starteSpiel(input);
	}

	public void printStatus() {
		this.controlSpiel.printStatus();
		this.controleMenu.printStatus();

	}

	public boolean isBeendet() {
		if (this.controleMenu.getSTATUS() == ControlEnum.ENDE) {
			return true;
		}
		return false;
	}

	protected void setupControle() {
		if (STATUS == STATUS.SPIELVORBEREITUNG) {
			if (this.controleMenu.isGegenKI()) {
				if (this.controleMenu.isBestOfOne()) {
					this.controlSpiel.setTypModus("KI", "BOO",this.controleMenu.getKiStufe());
				} else if (this.controleMenu.isBestOfThree()) {
					this.controlSpiel.setTypModus("KI", "BOT",this.controleMenu.getKiStufe());
				}

			} else if (this.controleMenu.isGegenMensch()) {
				if (this.controleMenu.isBestOfOne()) {
					this.controlSpiel.setTypModus("MENSCH", "BOO");
				} else if (this.controleMenu.isBestOfThree()) {
					this.controlSpiel.setTypModus("MENSCH", "BOT");
				}
			}
		}
	}
	
	public ControlSpiel getControlSpiel() {
		return this.controlSpiel;
	}

}
