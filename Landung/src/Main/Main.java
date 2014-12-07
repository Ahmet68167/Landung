package Main;

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


	public Main() {

		this.init();
		this.run();

	}

	private void run() {

		this.output.print("Willkommen", "console");

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

}
