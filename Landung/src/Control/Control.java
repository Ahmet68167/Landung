package Control;

import InputOutput.ControlPrint;
import InputOutput.Output;

public class Control {

	private ControlMenu controleMenu;
	private Output output;
	private ControlPrint contolePrint;

	public Control(Output output) {
		this.controleMenu = new ControlMenu(output);
		this.contolePrint = new ControlPrint(controleMenu, output);
		this.output = output;

	}
	

	public boolean checkInput(String input) {
		
		this.output.print(this.controleMenu.getSTATUS().getName(),"console");
		

		if (this.chekForUpperCase(input)) {
			
			this.controleMenu.checkInput(input);

			if (this.controleMenu.getSTATUS() == ControlEnum.SPIELLAEUFT) {

			}
			
			return true;
		}
		return false;
	}

	private boolean chekForUpperCase(String input) {
		return true;
	}
	
	public void print(){
		this.contolePrint.print();
	}

}
