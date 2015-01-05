package tunier;

import java.util.List;

public class ZufallsKi {

	private ControlZug controlzug;
	private Verwaltung zug;
	
	public ZufallsKi(ControlZug controlzug) {
		this.controlzug = controlzug;
		this.zug = new Verwaltung(this.controlzug);
	}
	
	public String getBefehl() {
		List liste;
		liste = zug.alleZuege();
		
		if(liste.size() == 0){
			return "";
		}
		Zug a = (Zug) liste.get( (int) (Math.random()*liste.size()) );

		return a.getZug();
	}
	
	public ControlZug getControlZug() {
		return this.controlzug;
	}
	
	public void setControlZug(ControlZug controlzug) {
		this.controlzug = controlzug;
	}
	
	public Verwaltung getZug() {
		return this.zug;
	}
	
	public void setZug(Verwaltung zug) {
		this.zug = zug;
	}
	
}
