package Control;

import Main.Main;

public class ControlSpiel {

	private Main main;
	private String nameSpieler1;
	private String nameSpieler2;
	private boolean isNameSpieler;

	public ControlSpiel(Main main) {

		this.main = main;
		this.isNameSpieler = false;
	}

	public void starteSpiel(String input, String typ, String modus) {

		if (typ.equals("KI")) {
			this.nameSpieler1 = "KI";
		} 
		
		if (!isNameSpieler) {
			this.setSpielerNamen(input);
		}
		
	

	}

	private void setSpielerNamen(String input) {
		
		this.main.getOutput().print("Bitte Namen eingeben.\n");

		if (this.nameSpieler1 == null) {
			this.main.getOutput().print("Name Spieler 1: ");

			this.nameSpieler1 = input;

		} else if (this.nameSpieler2 == null)  {
			this.main.getOutput().print("Name Spieler 2: ");

			this.nameSpieler2 = input;
			this.isNameSpieler = true;
			this.main.getOutput().print("Die Eingegebenen Namen: ");
			this.main.getOutput().print("Spieler 1 :"+this.nameSpieler1);
			this.main.getOutput().print("Spieler 2 :"+this.nameSpieler2);
		}



	}

}
