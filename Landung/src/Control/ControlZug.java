package Control;

import model.spieler.Spieler;

public class ControlZug {
	
	

	private ControlSpiel controlSpiel;



	public ControlZug(ControlSpiel controlSpiel) {
	   this.controlSpiel = controlSpiel;
    }



	public void nexterZug() {
	//	this.controlSpiel.spieler1.getSpielstein();
	    
    }
	
    private boolean hattSpielsteine(Spieler spieler){
    	if(spieler.getSpielSteinListeSize() > 0){
    		return true;
    	}
    	
    	return false;
    }

}
