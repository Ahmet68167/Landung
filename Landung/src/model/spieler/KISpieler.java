package model.spieler;

import Control.ControlZug;
import model.spielstein.Spielstein;

public class KISpieler extends Spieler {

	private int schwierigkeitsstufe;
	private ControlZug controlzug;
	private SchlaueKi schlaueki;
	private ZufallsKi zufallski;
	
	public KISpieler() {
		
	}
	
	public KISpieler(String name, int spielernummer, int schwierigkeitsstufe, 
			ControlZug controlzug) {
		super(name, spielernummer);
		this.schwierigkeitsstufe = schwierigkeitsstufe;
		this.controlzug = controlzug;
		this.schlaueki = new SchlaueKi(controlzug);
		this.zufallski = new ZufallsKi(controlzug);
	}
	
	public int getSchwierigkeitsstufe() {
		return this.schwierigkeitsstufe;
	}

	@Override
	public String getBefehl() {
		if(this.schwierigkeitsstufe == 1)
			return this.zufallski.getBefehl();
		else if(this.schwierigkeitsstufe == 2) {
			int reihe = (int) (Math.random() * 2);
			if(reihe == 0)
				return this.zufallski.getBefehl();
			else
				return this.schlaueki.getBefehl();
		} else if(this.schwierigkeitsstufe == 3)
			return this.schlaueki.getBefehl();
		else
			return null;
	}

}
