package model.spieler;

import model.spielstein.Spielstein;

public class KISpieler extends Spieler {

	private int schwierigkeitsstufe;
	
	public KISpieler() {
		
	}
	
	public KISpieler(String name, int spielernummer, int schwierigkeitsstufe) {
		super(name, spielernummer);
		this.schwierigkeitsstufe = schwierigkeitsstufe;
	}
	
	public int getSchwierigkeitsstufe() {
		return this.schwierigkeitsstufe;
	}

}
