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

	public Main() {
		this.init();
		this.run();
	}

	private void run() {

		
		while (true) {
			this.control.printStatus();
			this.control.checkInput(this.input.read());
			if (control.isBeendet()) {
				this.output.print("Spiel beendet");
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
