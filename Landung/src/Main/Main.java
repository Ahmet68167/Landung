package Main;

import Control.Control;
import InputOutput.Input;
import InputOutput.Output;

public class Main {
	
	private Input input;
	private Output output;
	private Control control;
	private String eingabe;

	public Main(){
		
		this.init();
		this.run();
		
		
	}

	private void run() {
		
	  	this.output.print("Willkommen","console");
   
		
	    while(true){	  
	    	
	    	this.eingabe  =  this.input.read();
	    	this.output.print(this.eingabe,"console");
	    	this.control.checkInput(this.eingabe);
	    	this.control.
	
	    }
	    
    }

	private void init() {
	    this.input = new Input();
	    this.output = new Output();
	    this.control = new Control(this.output);	    
    }

}
