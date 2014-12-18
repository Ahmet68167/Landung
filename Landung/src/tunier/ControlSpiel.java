package tunier;

import Control.ControlEnum;
import Main.Main;
import model.spieler.KISpieler;
import model.spieler.MenschSpieler;
import model.spieler.Spieler;
import model.spielfeld.Spielfeld;
import model.spielstein.Spielstein;

public class ControlSpiel {

	private ControlZug controlZug;
	private int rundeSpiel = 1;
	Spieler spieler1;
	Spieler spieler2;
	private String nameSpieler1;
	private String nameSpieler2;
	private char symbol1 = 'X';
	private char symbol2 = 'O';
	ControlEnum tmp;
	private String typ;
	private String modus;
	private Spielfeld spielfeld;
	private Spieler istDran;
	private int rundeZug = 1;
	private String letzterBefehl;
	private boolean isSonderRegelGeprueft = false;
	private ControlKI controlKI;
	private int hasWon = 0;
	public boolean gewonnen = false;
	public boolean isSecond = false;
	public String gegenerZug = "";
	private boolean gaveAMoveOrder = false;
	public boolean canYouMove = false;
	public boolean canIMove = false;
	public boolean isFirst = false;
	public boolean verloren = false;

	// Für KI Spiel ///////////////////////////////////////
	public ControlSpiel() {
		this.controlZug = new ControlZug(this);
		this.controlKI = new ControlKI(this);
		this.nameSpieler1 = "KI_1";
		this.nameSpieler2 = "KI_2";
		this.spieler1 = new KISpieler(nameSpieler1,
		        new Spielstein(this.symbol1), 1);
		this.spieler2 = new KISpieler(nameSpieler2,
		        new Spielstein(this.symbol2), 1);
		this.istDran = this.spieler1;
		this.spielfeld = new Spielfeld();
		this.spieler1 = new MenschSpieler(nameSpieler1, new Spielstein(
		        this.symbol1));
		this.spieler2 = new MenschSpieler(nameSpieler2, new Spielstein(
		        this.symbol2));
		this.setTypModus("KI", "BOO");
		this.istDran = this.spieler1;
	}

	// /////////////////////////////////////////////////////////
	public void starteSpiel(String input) {

		switch (Control.STATUS) {		
		
		case SPIELRUNDE:
			


			if (this.rundeZug == 4 && !this.isSonderRegelGeprueft) {
				this.controlZug.setSonderregel(true);
				this.isSonderRegelGeprueft = true;
			}
			// //////// KI SPIEL
			if (isSecond) {

				if (!this.gaveAMoveOrder) {
					this.canYouMove = this.controlZug.naechsterZug(input);
					this.letzterBefehl = null;
					this.gaveAMoveOrder = true;

				} else if (this.gaveAMoveOrder) {
					this.canIMove = false;

					while (!this.canYouMove) {
						input = this.controlKI.getKIBefehl(this.rundeZug);
						this.canIMove = this.controlZug.naechsterZug(input);

						if (this.gewonnen &&  this.verloren) {
							input = null;
							break;
						}

					}
					this.letzterBefehl = input;
					this.gaveAMoveOrder = false;					
			
				}
			}
			if (isFirst) {
				if (!this.gaveAMoveOrder) {
					this.canIMove = false;

					while (!this.canIMove) {
						input = this.controlKI.getKIBefehl(this.rundeZug);
						this.canIMove = this.controlZug.naechsterZug(input);

						if (this.gewonnen &&  this.verloren) {
							input = null;
							break;
						}
					}

					this.letzterBefehl = input;

					this.gaveAMoveOrder = true;
				
				} else if (this.gaveAMoveOrder) {
					this.canYouMove = this.controlZug.naechsterZug(input);
					this.letzterBefehl = null;
					this.gaveAMoveOrder = false;
				
				}
			}

			if (this.gewonnen) {
				if (this.istDran.equals(spieler1)) {
					setHasWon(1);
				} else {
					setHasWon(-1);
				}
				this.resetKISpiel();		
			
			}
	
			break;
		default: // Fehler ungültiger Status;
			break;
		}
	}

	private void resetKISpiel() {
		this.rundeSpiel = 1;
		this.rundeZug = 1;
		this.nameSpieler1 = "KI_1";
		this.nameSpieler2 = "KI_2";
		this.spieler1 = new KISpieler(nameSpieler1,
		        new Spielstein(this.symbol1), 1);
		this.spieler2 = new KISpieler(nameSpieler2,
		        new Spielstein(this.symbol2), 1);
		this.istDran = this.spieler1;
		this.spielfeld = new Spielfeld();
		this.spieler1 = new MenschSpieler(nameSpieler1, new Spielstein(
		        this.symbol1));
		this.spieler2 = new MenschSpieler(nameSpieler2, new Spielstein(
		        this.symbol2));
		this.setTypModus("KI", "BOO");
		this.istDran = this.spieler1;
		this.canYouMove = false;
		this.canIMove = false;
		this.isFirst = false;
		this.hasWon = 0;
	}

	/**
	 * @return the controlKI
	 */
	public ControlKI getControlKI() {
		return controlKI;
	}

	/**
	 * @param controlKI
	 *            the controlKI to set
	 */
	public void setControlKI(ControlKI controlKI) {
		this.controlKI = controlKI;
	}

	/**
	 * @return the letzterBefehl
	 */
	public String getLetzterBefehl() {
		return letzterBefehl;
	}

	/**
	 * @return the istDran
	 */
	protected Spieler getIstDran() {
		return istDran;
	}

	/**
	 * @param istDran
	 *            the istDran to set
	 */
	protected void setIstDran(Spieler istDran) {
		this.istDran = istDran;
	}

	void setTypModus(String typ, String modus) {
		if (this.typ == null && this.modus == null) {
			this.typ = typ;
			this.modus = modus;
			if (typ.equals("KI")) {
				this.nameSpieler1 = "KI";
			}
			if (modus.equals("BOO")) {
				this.rundeSpiel = 1;
			} else if (modus.equals("BOT")) {
				this.rundeSpiel = 3;
			}
		}
	}

	/**
	 * @return the spieler1
	 */
	protected Spieler getSpieler1() {
		return spieler1;
	}

	/**
	 * @return the spieler2
	 */
	protected Spieler getSpieler2() {
		return spieler2;
	}

	/**
	 * @return the spielfeld
	 */
	protected Spielfeld getSpielfeld() {
		return spielfeld;
	}

	void naechsterSpieler() {
		if (this.istDran.equals(spieler1)) {
			this.istDran = spieler2;
		} else {
			this.istDran = spieler1;
		}
	}

	/**
	 * @return the rundeSpiel
	 */
	protected int getRundeSpiel() {
		return rundeSpiel;
	}

	/**
	 * @param rundeSpiel
	 *            the rundeSpiel to set
	 */
	protected void setRundeSpiel(int rundeSpiel) {
		this.rundeSpiel = rundeSpiel;
	}

	/**
	 * @return the hasWon
	 */
	public int getHasWon() {
		return hasWon;
	}

	/**
	 * @param i
	 * @param spieler
	 * @param hasWon
	 *            the hasWon to set
	 */
	public void setHasWon(int i) {

		this.hasWon = i;

	}

	/**
	 * @return the rundeZug
	 */
	protected int getRundeZug() {
		return rundeZug;
	}

	/**
	 * @param rundeZug
	 *            the rundeZug to set
	 */
	protected void setRundeZug(int rundeZug) {
		this.rundeZug = rundeZug;
	}



}
