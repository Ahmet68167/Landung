package Main;

import model.highscore.HighScore;
import model.highscore.HighScoreListe;
import model.spieler.Spieler;
import model.spielfeld.Spielfeld;
import model.spielstein.Spielstein;
import Control.Control;
import InputOutput.Input;
import InputOutput.Output;

public class Main {

	private Input input;
	private Output output;
	private Control control;
	private HighScoreListe highscore;

	public Main() {
		this.init();
		this.run();
	}

	private void run() {

		this.output.print("Willkommen", "console");
		
		// HighScore TEST

		this.highscore.neuerHighScore("Bob", 100);
		this.highscore.schreibeInDatei();

		while (true) {
			this.control.printStatus();
			this.control.checkInput(this.input.read());
			if (control.isBeendet()) {
				break;
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
