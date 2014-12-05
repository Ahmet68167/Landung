package model.spieler;

import java.util.List;

public class KISpieler extends Spieler {

	private int schwierigkeitsstufe;
	
	public KISpieler(String name, List list, int schwierigkeitsstufe) {
		super(name, list);
		this.schwierigkeitsstufe = schwierigkeitsstufe;
	}

}
