package Control;

public class ControlZug {
	
	

	private ControlSpiel controlSpiel;



	public ControlZug(ControlSpiel controlSpiel) {
	   this.controlSpiel = controlSpiel;
    }



	public void nexterZug() {
		this.controlSpiel.spieler1.getSpielstein();
	    
    }

}
