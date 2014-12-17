package tunier;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import speichern.FileHandler;
import tunier.IGame;
import Control.ControlEnum;
import Control.ControlSpeichern;
import Main.Main;
import model.spieler.KISpieler;
import model.spieler.MenschSpieler;
import model.spieler.Spieler;
import model.spielfeld.Spielfeld;
import model.spielstein.Spielstein;

public class ControlSpiel {

	Main main;
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
	private String filename = "saveFile";
	private boolean isTunierspiel = false;
	private String letzterBefehl;
	private boolean isZugErfolgtreich;
	private boolean isSonderRegelGeprueft = false;

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

	private boolean isKiSpiel;
	private ControlKI controlKI;
	private String letzterBefehler_1 = "";
	private String letzterBefehler_2 = "";
	private int hasWon = 0;
	public boolean gewonnen = false;
	public boolean isSecond = false;
	public String gegenerZug = "";
	private boolean gotAMoveOrder;
	private boolean gaveAMoveOrder;

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

	public ControlSpiel(Main main) {
		this.main = main;
		this.controlZug = new ControlZug(this);
	}

	// Für KI Spiel ///////////////////////////////////////
	public ControlSpiel() {

		this.isKiSpiel = true;
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

	}

	// /////////////////////////////////////////////////////////
	public void starteSpiel(String input) {

		if (this.gewonnen) {
			setHasWon(1);
		}

		switch (Control.STATUS) {

		case SPIELVORBEREITUNG:

			if (this.rundeSpiel > 0) {
				this.setSpielerNamen(input);
				this.initSpielMaterial();
				this.startSpieler();

			} else {
				Control.STATUS = Control.STATUS.HAUPTMENU;
			}

			break;
		case SPIELRUNDE:

			if (this.rundeZug == 4 && !this.isSonderRegelGeprueft) {

				this.controlZug.setSonderregel(true);
				this.isSonderRegelGeprueft = true;

			}
			// //////// KI SPIEL
			if (isSecond) {
				if (!this.gotAMoveOrder) {
					input = this.gegenerZug;
					this.controlZug.naechsterZug(input);
					this.gotAMoveOrder = true;
				}else if(this.gotAMoveOrder){
					input = this.controlKI.getKIBefehl(this.rundeZug);
					this.isZugErfolgtreich = false;
					while (!this.isZugErfolgtreich) {
						input = this.controlKI.getKIBefehl(this.rundeZug);
						this.isZugErfolgtreich = this.controlZug
						        .naechsterZug(input);
					}
					this.letzterBefehl = input;
					this.gotAMoveOrder = false;
				}

			} else {

				if (!this.gaveAMoveOrder) {
					input = this.controlKI.getKIBefehl(this.rundeZug);
					this.isZugErfolgtreich = false;
					while (!this.isZugErfolgtreich) {
						input = this.controlKI.getKIBefehl(this.rundeZug);
						this.isZugErfolgtreich = this.controlZug
						        .naechsterZug(input);
					}
					this.letzterBefehl = input;
					this.gaveAMoveOrder = true;
				}else if(this.gaveAMoveOrder){
					
					input = this.gegenerZug;
					this.controlZug.naechsterZug(input);
					this.gaveAMoveOrder = false;
					
					
		
				}

			}

			break;
		case SPIELRUNDENENDE:
			this.rundeSpiel--;

			if (this.rundeSpiel == 0) {

				Control.STATUS = Control.STATUS.SPIELVORBEREITUNG;

				this.resetKISpiel();

			}

			break;
		default: // Fehler ungültiger Status;
			break;
		}
	}

	/**
	 * @param letzterBefehl
	 *            the letzterBefehl to set
	 */
	public void setLetzterBefehl(String letzterBefehl) {
		this.letzterBefehl = letzterBefehl;
	}

	private void resetKISpiel() {
		this.rundeSpiel = 1;
		this.rundeZug = 1;
		this.spielfeld = new Spielfeld();
		this.controlZug.setSonderregel(false);
		this.isSonderRegelGeprueft = false;
		this.hasWon = 0;
		this.gotAMoveOrder = false;
		this.gaveAMoveOrder = false;
	}

	/**
	 * @return the isKiSpiel
	 */
	public boolean isKiSpiel() {
		return isKiSpiel;
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
	 * @param spielfeld
	 *            the spielfeld to set
	 */
	public void setSpielfeld(Spielfeld spielfeld) {
		this.spielfeld = spielfeld;
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

	private void initSpielMaterial() {

		if (nameSpieler1 != null && nameSpieler2 != null) {

			this.spieler1 = new MenschSpieler(nameSpieler1, new Spielstein(
			        this.symbol1));
			this.spieler2 = new MenschSpieler(nameSpieler2, new Spielstein(
			        this.symbol2));
		}
		if (this.spielfeld == null) {
			this.spielfeld = new Spielfeld();
		}
	}

	private List<Spielstein> getSpielsteinListe(char sym) {
		Spielstein liste = new Spielstein(sym);
		return liste.getSpielsteinListe(9);
	}

	private void setSpielerNamen(String input) {

		if (this.nameSpieler1 == null && input.length() > 2) {

			this.nameSpieler1 = input;
		} else if (this.nameSpieler2 == null && input.length() > 2) {

			this.nameSpieler2 = input;
		}
	}

	public void printStatus() {
		switch (Control.STATUS) {

		case SPIELRUNDE: // ;
			this.main.getOutput().print("Spieler: " + istDran.getName());
			if (this.rundeZug == 4 && !this.isSonderRegelGeprueft) {

				this.main
				        .getOutput()
				        .print("Wollen Sie die Sonderregel verwenden ? Ja [j] oder Nein [n] .");
			}
			break;
		case SPIELENDE:
			break;
		case LADEN:

			break;
		case SPIELVORBEREITUNG:

			if (this.nameSpieler1 == null) {
				this.main.getOutput().print("Info: mindestens 3 Buchstaben.");
				this.main.getOutput().print(
				        "Bitte Namen für Spieler 1 eingeben:");

			} else if (this.nameSpieler2 == null) {
				this.main.getOutput().print("Info: mindestens 3 Buchstaben.");
				this.main.getOutput().print(
				        "Bitte Namen für Spieler 2 eingeben:");

			}
			break;
		default: // Fehler ungültiger Status;
			break;
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

	private void startSpieler() {
		if (this.spieler1 != null && this.spieler2 != null) {
			double rand = Math.random();
			if (rand > 0.5) {
				this.istDran = this.spieler1;
			} else {
				this.istDran = this.spieler2;
			}

			Control.STATUS = Control.STATUS.SPIELRUNDE;
			this.starteSpiel("");
			;
		}
	}

	private void printListeSpielstaende() {
		List<String> list = leseListeSpielstaende();
		ControlSpeichern conSp = new ControlSpeichern();
		FileHandler fileHandler = new FileHandler();
		Date date;
		this.main.getOutput().print("\nSpielstaende\n-------------");
		int i = 0;
		for (String str : list) {
			conSp = fileHandler.load(str, conSp);
			this.main.getOutput().print(
			        "[" + i + "] Spielstand vom "
			                + conSp.getSpeicherDatum().toGMTString());
			i++;
		}
		this.main.getOutput().print("\n-------------\n");
	}

	private List<String> leseListeSpielstaende() {
		List<String> list = new ArrayList();

		for (int i = 0; i < 100; i++) {

			File f = new File(this.filename + "" + i);
			if (f.exists() && !f.isDirectory()) {

				list.add(this.filename + "" + i);
			}
		}
		return list;
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

}
