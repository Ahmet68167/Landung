package Control;

import Main.Main;

public class Control {

	private ControlMenu controleMenu;
	private ControlSpiel controlSpiel;
	private Main main;

	public Control(Main main) {
		this.main = main;
		this.controleMenu = new ControlMenu(main.getOutput());
		this.controlSpiel = new ControlSpiel(main);

	}

	public void checkInput(String input) {

		if (this.controleMenu.getSTATUS() == ControlEnum.SPIELLAEUFT) {
			if (this.controleMenu.isGegenKI()) {
				if (this.controleMenu.isBestOfOne()) {
					this.main.getOutput().print("STARTE GEGEN KI und BEST OF ONE");
					this.controlSpiel.starteSpiel(input,"KI","BOO");
				} else if (this.controleMenu.isBestOfOne()) {
					this.main.getOutput().print("STARTE GEGEN KI und BEST OF THREE");
					this.controlSpiel.starteSpiel(input,"KI","BOT");
				}

			} else if (this.controleMenu.isGegenMensch()) {
				if (this.controleMenu.isBestOfOne()) {
					this.main.getOutput().print("STARTE GEGEN MENSCHE und BEST OF ONE");
					this.controlSpiel.starteSpiel(input,"MENSCH","BOO");
				} else if (this.controleMenu.isBestOfOne()) {
					this.main.getOutput().print("STARTE GEGEN MENSCH und BEST OF THREE");
					this.controlSpiel.starteSpiel(input,"MENSCH","BOT");
				}
			}

		} else {
			this.controleMenu.checkInput(input);
		}

	}

	public void printStatus() {

		this.controleMenu.printStatus();

	}

	public boolean isBeendet() {
		if (this.controleMenu.getSTATUS() == ControlEnum.ENDE) {
			return true;
		}
		return false;
	}

}
