package tunier;

public class ControlSpiel {

	public ControlZug controlZug;
	private int rundeSpiel = 1;
	Spieler spieler1;
	Spieler spieler2;
	private String nameSpieler1;
	private String nameSpieler2;
	ControlEnum tmp;
	private String typ;
	private String modus;
	private Spielfeld spielfeld;
	private Spieler istDran;
	private int rundeZug = 1;
	private String letzterBefehl;
	private boolean isSonderRegelGeprueft = false;
	private ControlKI controlKI;

	public boolean gewonnen = false;
	public boolean isSecond = false;
	public String gegenerZug = "";
	private boolean gaveAMoveOrder = false;
	public boolean canYouMove = false;
	public boolean canIMove = false;
	public boolean isFirst = false;
	public boolean verloren = false;
	private Control control;

	// F�r KI Spiel ///////////////////////////////////////
	public ControlSpiel(Control control) {
		this.control = control;
		this.controlZug = new ControlZug(this);
		this.controlKI = new ControlKI(this);
		this.nameSpieler1 = "KI_1";
		this.nameSpieler2 = "KI_2";

		this.istDran = this.spieler1;
		this.spielfeld = new Spielfeld();
		this.spieler1 = new KISpieler(nameSpieler1, 1,3,this.controlZug);
		this.spieler2 = new MenschSpieler(nameSpieler2, 2 );
		this.setTypModus("KI", "BOO");
		this.istDran = this.spieler1;
	}

	public String getKIMove() {
		String kiMove = "";
		
			kiMove = this.spieler1.getBefehl();
			
		return kiMove;
	}

	// /////////////////////////////////////////////////////////
	public void starteSpiel(String input) {

		switch (Control.STATUS) {

		case SPIELRUNDE:

			if (this.rundeZug == 4 && !this.isSonderRegelGeprueft) {
				this.controlZug.setSonderregel(false);
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
					input = getKIMove();

					this.controlZug.naechsterZug(input);

					this.letzterBefehl = input;
					this.gaveAMoveOrder = false;
				}
			}
			if (isFirst) {
				if (!this.gaveAMoveOrder) {
					this.canIMove = false;
					input = getKIMove();
					this.controlZug.naechsterZug(input);

					this.letzterBefehl = input;
					this.gaveAMoveOrder = true;

				} else if (this.gaveAMoveOrder) {
					this.canYouMove = this.controlZug.naechsterZug(input);
					this.letzterBefehl = null;
					this.gaveAMoveOrder = false;

				}
			}

			if (!this.controlZug.canIMove()) {
	
				this.resetKISpiel();

			}

			break;
		default: // Fehler ung�ltiger Status;
			break;
		}
	}

	private void resetKISpiel() {
		this.rundeSpiel = 1;
		this.rundeZug = 1;
		this.nameSpieler1 = "KI_1";
		this.nameSpieler2 = "KI_2";
		
		this.spielfeld = new Spielfeld();
		this.spieler1 = new KISpieler(nameSpieler1, 1,3,this.controlZug);
		this.spieler2 = new MenschSpieler(nameSpieler2, 2 );
		this.setTypModus("KI", "BOO");
		this.istDran = this.spieler1;
		this.canYouMove = false;
		this.canIMove = false;
		/// SPIELER WECHSEL, entscheiden wer KI und Wer MenschSpieler Spieler 1 oder Spieler 2
		if(this.isFirst){
			this.istDran = spieler1;
		}else{
			this.istDran = spieler2;
		}

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
	 * @param i
	 * @param spieler
	 * @param hasWon
	 *            the hasWon to set
	 */
	public void setHasWon(int i) {

		this.control.hasWon = i;

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

	public void setSpielfeld(Spielfeld spiel) {
		this.spielfeld = spiel;

	}

}
