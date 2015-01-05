package tunier;

import tunier.IGame;

public class Control implements IGame {

	private ControlSpiel controlSpiel;
	public int hasWon;
	static ControlEnum STATUS;

	// F�r KI Spiel
	public Control() {
		this.hasWon = 0;
		this.controlSpiel = new ControlSpiel(this);
		this.STATUS = STATUS.SPIELRUNDE;
	}

	public void checkInput(String input) {
		this.controlSpiel.starteSpiel(input);
	}

	// ///////// Interface Methoden /////////////////
	@Override
	public void youAreSecond() {
		this.controlSpiel.isSecond = true;

	}

	@Override
	public boolean isRunning() {

		return true;

	}

	@Override
	public int whoWon() {
	
		return this.hasWon;
	}

	@Override
	public boolean takeYourMove(String gegnerZug) {

		if (gegnerZug != null) {
			this.controlSpiel.starteSpiel(gegnerZug);
			return true;
		}
		return false;
	}

	@Override
	public String getMyMove() {
		this.controlSpiel.starteSpiel("");

		return this.controlSpiel.getLetzterBefehl();
	}

	@Override
	public boolean canYouMove() {
		
		return this.controlSpiel.controlZug.canIMove();
	}

	@Override
	public boolean canIMove() {
		
		return this.controlSpiel.controlZug.canIMove();
	}

	@Override
	public void printBoard() {
	/*	if (this.controlSpiel.getSpielfeld() != null) {
			System.out.println(this.controlSpiel.getSpielfeld().toString());
		}*/
	}

	@Override
	public void youAreFirst() {
		this.controlSpiel.isFirst = true;

	}
}
