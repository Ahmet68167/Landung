package model.spieler;

import model.spielstein.Spielstein;

public class KISpieler extends Spieler {

	private int schwierigkeitsstufe;
	
	public KISpieler() {
		
	}
	
	public KISpieler(String name, Spielstein spielstein, int schwierigkeitsstufe) {
		super(name, spielstein);
		this.schwierigkeitsstufe = schwierigkeitsstufe;
	}
	
	public int getSchwierigkeitsstufe() {
		return this.schwierigkeitsstufe;
	}

}
