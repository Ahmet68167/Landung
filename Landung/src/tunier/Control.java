package tunier;
import tunier.IGame;

public class Control implements IGame {

	private ControlSpiel controlSpiel;
	static ControlEnum STATUS;


	// Für KI Spiel
	public Control() {

		this.controlSpiel = new ControlSpiel();
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

        if(gegnerZug != null){
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
	
		return this.controlSpiel.canYouMove;
	}
	@Override
	public boolean canIMove() {

		return this.controlSpiel.canIMove;
	}
	@Override
	public void printBoard() {
		if (this.controlSpiel.getSpielfeld() != null) {
			System.out.println(this.controlSpiel.getSpielfeld().toString());
		}
	}
}
