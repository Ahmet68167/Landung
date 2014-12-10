package Control;

import model.spieler.Spieler;
import model.spielfeld.Spielfeld;
import model.spielstein.Spielstein;

public class ControlSpeichern {
	
	Spieler spieler1;
	Spieler spieler2;
	Spielfeld  spielfeld;
	String typ;
	String modus;
	private Spieler istDran;
	private int runde;
	private Spielstein[][] spielbrett;
	
	/**
	 * @return the spielfeld
	 */
	public Spielfeld getSpielfeld() {
		return spielfeld;
	}

	/**
	 * @param spielfeld the spielfeld to set
	 */
	public void setSpielfeld(Spielfeld spielfeld) {
		this.spielfeld = spielfeld;
	}

	/**
	 * @return the typ
	 */
	public String getTyp() {
		return typ;
	}

	/**
	 * @param typ the typ to set
	 */
	public void setTyp(String typ) {
		this.typ = typ;
	}

	/**
	 * @return the modus
	 */
	public String getModus() {
		return modus;
	}

	/**
	 * @param modus the modus to set
	 */
	public void setModus(String modus) {
		this.modus = modus;
	}

	public ControlSpeichern(){
		
	}

	/**
	 * @return the spieler1
	 */
	public Spieler getSpieler1() {
		return spieler1;
	}

	/**
	 * @param spieler1 the spieler1 to set
	 */
	public void setSpieler1(Spieler spieler1) {
		this.spieler1 = spieler1;
	}
	/**
	 * @return the spieler2
	 */
	public Spieler getSpieler2() {
		return spieler2;
	}
	/**
	 * @return the istDran
	 */
	public Spieler getIstDran() {
		return istDran;
	}

	/**
	 * @return the runde
	 */
	public int getRunde() {
		return runde;
	}

	/**
	 * @param spieler2 the spieler2 to set
	 */
	public void setSpieler2(Spieler spieler2) {
		this.spieler2 = spieler2;
	}

	public void setRunde(int runde) {
	   this.runde= runde;	    
    }

	public void setIstDran(Spieler istDran) {
	   this.istDran = istDran;	    
    }

	/**
	 * @return the spielbrett
	 */
	public Spielstein[][] getSpielbrett() {
		return spielbrett;
	}

	public void setSpielbrett(Spielstein[][] spielbrett) {
	  this.spielbrett = spielbrett;
	    
    }

}
