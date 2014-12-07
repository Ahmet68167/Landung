package Control;


import InputOutput.Output;

public class Control {

	private ControlMenu controleMenu;
	private ControlSpiel controlSpiel;
	private Output output;

	public Control(Output output) {
		this.controleMenu = new ControlMenu(output);	
		this.controlSpiel = new ControlSpiel();
		this.output = output;

	}	

	public void checkInput(String input) {	

		if (this.chekForUpperCase(input)) {
			
			this.controleMenu.checkInput(input);

			if (this.controleMenu.getSTATUS() == ControlEnum.SPIELLAEUFT) {

			}
		
		}	
	}

	private boolean chekForUpperCase(String input) {
		return true;
	}


	public void printStatus() {
	
		this.controleMenu.printStatus();
	    
    }
	


}
