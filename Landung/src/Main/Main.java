package Main;

import Control.Control;
import InputOutput.Input;
import InputOutput.Output;

public class Main {

	private Input input;
	private Output output;
	private Control control;
	private String eingabe;

	public Main() {

		this.init();
		this.run();

	}

	private void run() {

		this.output.print("Willkommen", "console");

		while (true) {

			this.control.printStatus();
			this.eingabe = this.input.read();		
			this.control.checkInput(this.eingabe);
			
			if(control.isBeendet()){
				break;
			}
	
		}

	}

	private void init() {
		this.input = new Input();
		this.output = new Output();
		this.control = new Control(this.output);
	}

}
