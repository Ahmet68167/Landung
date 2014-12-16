package Control;

import tunier.IGame;
import InputOutput.Output;
import Main.Main;

public class Control implements IGame {
	private ControlMenu controleMenu;
	private ControlSpiel controlSpiel;
	private Main main;
	private Output output;
	static ControlEnum STATUS;

	public Control(Main main) {
		this.main = main;
		this.STATUS = STATUS.HAUPTMENU;
		this.controleMenu = new ControlMenu(main, this);
		this.controlSpiel = new ControlSpiel(main);
	}

	// Für KI Spiel
	public Control() {
		this.output = new Output();
		this.controlSpiel = new ControlSpiel();
		this.STATUS = STATUS.SPIELVORBEREITUNG;
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
					this.controlSpiel.setTypModus("KI", "BOO");
				} else if (this.controleMenu.isBestOfThree()) {
					this.controlSpiel.setTypModus("KI", "BOT");
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

	// ///////// Interface Methoden /////////////////

	@Override
	public void youAreSecond() {
		this.controlSpiel.naechsterSpieler();

	}

	@Override
	public boolean isRunning() {
		if (Control.STATUS == Control.STATUS.SPIELRUNDE) {
			return true;
		}
		return false;
	}

	@Override
	public int whoWon() {

		return this.controlSpiel.getHasWon();
	}

	@Override
	public boolean takeYourMove(String gegnerZug) {

		this.controlSpiel.starteSpiel(gegnerZug);
		return true;
	}

	@Override
	public String getMyMove() {

		return this.controlSpiel.getLetzterBefehl();
	}

	@Override
	public boolean canYouMove() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canIMove() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void printBoard() {
		if (this.controlSpiel.getSpielfeld() != null) {
			this.output.print(this.controlSpiel.getSpielfeld().toString());
		}
	}
}
