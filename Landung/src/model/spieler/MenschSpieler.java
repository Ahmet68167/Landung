package model.spieler;

import model.spielstein.Spielstein;

public class MenschSpieler extends Spieler {

	public MenschSpieler() {
		
	}
	
	public MenschSpieler(String name, int spielernummer) {
		super(name, spielernummer);
	}

	@Override
	public String getBefehl() {
		return null;
	}

}
