package tunier;


public class KISpieler extends Spieler {

	private int schwierigkeitsstufe;
	private ControlZug controlzug;
	private SchlaueKi schlaueki;
	private ZufallsKi zufallski;
	
	public KISpieler() {
		
	}
	
	public KISpieler(String name, int spielernummer, int schwierigkeitsstufe, 
			ControlZug controlzug) {
		super(name, spielernummer, "Ki");
		this.schwierigkeitsstufe = schwierigkeitsstufe;
		this.setControlzug(controlzug);
		this.schlaueki = new SchlaueKi(controlzug);
		this.zufallski = new ZufallsKi(controlzug);
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
			return "";
	}
	
	public int getSchwierigkeitsstufe() {
		return this.schwierigkeitsstufe;
	}
	
	public void setSchwierigkeitsstufe(int schwierigkeitsstufe) {
		this.schwierigkeitsstufe = schwierigkeitsstufe;
	}

	public ControlZug getControlzug() {
		return controlzug;
	}

	public void setControlzug(ControlZug controlzug) {
		this.controlzug = controlzug;
	}
	
	public SchlaueKi getSchlaueKi() {
		return this.schlaueki;
	}
	
	public void setSchlaueKi(SchlaueKi schlaueki) {
		this.schlaueki = schlaueki;
	}
	
	public ZufallsKi getZufallsKi() {
		return this.zufallski;
	}
	
	public void setZufallsKi(ZufallsKi zufallski) {
		this.zufallski = zufallski;
	}


}
