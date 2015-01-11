package Control;

import java.util.Date;

import model.spieler.Spieler;
import model.spielfeld.Spielfeld;
import model.spielstein.Spielstein;

public class ControlSpeichern {
	
	Spieler spieler1;
	Spieler spieler2;
	Spielfeld  spielfeld;
	String typ;
	private Spieler istDran;
	private int rundeZug;
	private int rundeSpiel;
	
	
	/**
	 * @return the rundeZug
	 */
	public int getRundeZug() {
		return rundeZug;
	}

	/**
	 * @param rundeZug the rundeZug to set
	 */
	public void setRundeZug(int rundeZug) {
		this.rundeZug = rundeZug;
	}

	/**
	 * @return the rundeSpiel
	 */
	public int getRundeSpiel() {
		return rundeSpiel;
	}

	/**
	 * @param rundeSpiel the rundeSpiel to set
	 */
	public void setRundeSpiel(int rundeSpiel) {
		this.rundeSpiel = rundeSpiel;
	}

	private Spielstein[][] spielbrett;
	private Date speicherDatum;
	String modus;
	

	/**
	 * @return the speicherDatum
	 */
	public Date getSpeicherDatum() {
		return speicherDatum;
	}

	/**
	 * @param speicherDatum the speicherDatum to set
	 */
	public void setSpeicherDatum(Date speicherDatum) {
		this.speicherDatum = speicherDatum;
	}


	public Spielfeld getSpielfeld() {
		return spielfeld;
	}

	public void setSpielfeld(Spielfeld spielfeld) {
		this.spielfeld = spielfeld;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getModus() {
		return modus;
	}

	public void setModus(String modus) {
		this.modus = modus;
	}

	public ControlSpeichern(){
		
	}

	public Spieler getSpieler1() {
		return spieler1;
	}

	public void setSpieler1(Spieler spieler1) {
		this.spieler1 = spieler1;
	}
	
	public Spieler getSpieler2() {
		return spieler2;
	}
	
	public Spieler getIstDran() {
		return istDran;
	}

	public void setSpieler2(Spieler spieler2) {
		this.spieler2 = spieler2;
	}

	public void setIstDran(Spieler istDran) {
	   this.istDran = istDran;	    
    }

	public Spielstein[][] getSpielbrett() {
		return spielbrett;
	}

	public void setSpielbrett(Spielstein[][] spielbrett) {
	  this.spielbrett = spielbrett;
	    
    }

}
