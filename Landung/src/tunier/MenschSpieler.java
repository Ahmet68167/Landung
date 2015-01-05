package tunier;


public class MenschSpieler extends Spieler {
	
	public MenschSpieler() {
		
	}
	
	public MenschSpieler(String name, int spielernummer) {
		super(name, spielernummer, "Mensch");
	}

	@Override
	public String getBefehl() {
		return super.getInput();
	}

}
