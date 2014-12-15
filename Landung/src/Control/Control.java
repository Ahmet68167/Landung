package Control;

import tunier.IGame;
import Main.Main;

public class Control implements IGame{
	private ControlMenu controleMenu;
	private ControlSpiel controlSpiel;
	private Main main;
	static ControlEnum STATUS;
	
	public Control(Main main) {
		this.main = main;
		this.STATUS = STATUS.HAUPTMENU;
		this.controleMenu = new ControlMenu(main,this);
		this.controlSpiel = new ControlSpiel(main);
	}
	
	// Für KI Spiel
	public Control(){
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

			return 0;
		}

		@Override
		public boolean takeYourMove(String gegnerZug) {
			this.controlSpiel.starteSpiel(gegnerZug);
			return false;
		}

		@Override
		public String getMyMove() {

			return "";
		}

		@Override
		public boolean canYouMove() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean canIMove() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void printBoard() {
			this.main.getOutput().print(this.controlSpiel.getSpielfeld().toString());

		}
}
