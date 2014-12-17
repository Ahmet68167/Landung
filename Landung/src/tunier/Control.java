package tunier;
import tunier.IGame;

public class Control implements IGame {

	private ControlSpiel controlSpiel;
	static ControlEnum STATUS;


	// Für KI Spiel
	public Control() {

		this.controlSpiel = new ControlSpiel();
		this.STATUS = STATUS.SPIELVORBEREITUNG;
	}

	public void checkInput(String input) {

		this.setupControle();
		this.controlSpiel.starteSpiel(input);
	}

	public void printStatus() {
		this.controlSpiel.printStatus();
	}
	protected void setupControle() {
		if (STATUS == STATUS.SPIELVORBEREITUNG) {
		
			this.controlSpiel.setTypModus("KI", "BOO");
		
		}
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
		this.controlSpiel.gegenerZug = gegnerZug;
        this.controlSpiel.starteSpiel("");
		return true;
	}

	@Override
	public String getMyMove() {
	    this.controlSpiel.starteSpiel("");
		return this.controlSpiel.getLetzterBefehl();
	}

	@Override
	public boolean canYouMove() {	
		return true;
	}
	@Override
	public boolean canIMove() {
		return true;
	}
	@Override
	public void printBoard() {
		if (this.controlSpiel.getSpielfeld() != null) {
			System.out.println(this.controlSpiel.getSpielfeld().toString());
		}
	}
}
