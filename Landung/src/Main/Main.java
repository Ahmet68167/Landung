package Main;

import model.highscore.HighScoreListe;

import Control.Control;
import InputOutput.Input;
import InputOutput.Output;

public class Main {

	private Input input;
	private Output output;
	private Control control;
	private HighScoreListe highscore;
	private boolean spielBeendet;

	public Main() {
		this.init();
		this.run();
	}

	/**
	 * @return the spielBeendet
	 */
	public boolean isSpielBeendet() {
		return spielBeendet;
	}

	/**
	 * @param spielBeendet the spielBeendet to set
	 */
	public void setSpielBeendet(boolean spielBeendet) {
		this.spielBeendet = spielBeendet;
	}

	private void run() {
		
		while (true) {
			this.control.printStatus();
			if(!this.spielBeendet){
			this.control.checkInput(this.input.read());}
			if (control.isBeendet()) {
				this.output.print("Spiel beendet");
				break;
			}
			if(this.spielBeendet){
				this.spielBeendet = false;
			}
		}
	}

	private void init() {
		this.input = new Input();
		this.output = new Output();
		this.highscore = new HighScoreListe();
		this.control = new Control(this);
	}

	/**
	 * @return the input
	 */
	public Input getInput() {
		return input;
	}

	/**
	 * @return the output
	 */
	public Output getOutput() {
		return output;
	}

	/**
	 * @return the highscore
	 */
	public HighScoreListe getHighscore() {
		return highscore;
	}

}
