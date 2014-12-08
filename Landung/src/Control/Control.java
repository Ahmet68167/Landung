package Control;

import Main.Main;

public class Control {

	private ControlMenu controleMenu;
	private ControlSpiel controlSpiel;
	private Main main;
	private ControlEnum STATUS;

	public Control(Main main) {
		this.main = main;
		this.STATUS = STATUS.HAUPTMENU;
		this.controleMenu = new ControlMenu(main,this.STATUS);
		this.controlSpiel = new ControlSpiel(main,this.STATUS);
	

	}

	public void checkInput(String input) {

		if (this.controleMenu.getSTATUS() == ControlEnum.SPIELLAEUFT) {
			if (this.controleMenu.isGegenKI()) {
				if (this.controleMenu.isBestOfOne()) {
					this.controlSpiel.starteSpiel(input, "KI", "BOO");
				} else if (this.controleMenu.isBestOfThree()) {
					this.controlSpiel.starteSpiel(input, "KI", "BOT");
				}

			} else if (this.controleMenu.isGegenMensch()) {
				if (this.controleMenu.isBestOfOne()) {
					this.controlSpiel.starteSpiel(input, "MENSCH", "BOO");
				} else if (this.controleMenu.isBestOfThree()) {
					this.controlSpiel.starteSpiel(input, "MENSCH", "BOT");
				}
			}

		} else {
			this.controleMenu.checkInput(input);
		}

	}

	public void printStatus() {
		if (this.controleMenu.getSTATUS() != ControlEnum.SPIELLAEUFT) {
			this.controleMenu.printStatus();
		}else{
			this.controlSpiel.printStatus();
			
		}
	}

	public boolean isBeendet() {
		if (this.controleMenu.getSTATUS() == ControlEnum.ENDE) {
			return true;
		}
		return false;
	}

}
