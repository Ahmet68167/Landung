package Control;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import speichern.FileHandler;
import tunier.IGame;
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
	private boolean isKiSpiel;
	private ControlKI controlKI;
	private String letzterBefehler_1="";
	private String letzterBefehler_2="";

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

	// F�r KI Spiel ///////////////////////////////////////
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
		
		if (this.isKiSpiel ) {
			if(input == null || input == ""){
			input = this.controlKI.getKIBefehl(this.rundeZug);
	
			}else{
			    this.letzterBefehl = input;

			}
	
		}
		

		switch (Control.STATUS) {
		case LADENAUSWAHL:
			this.printListeSpielstaende();
			Control.STATUS = Control.STATUS.LADEN;
			break;
		case LADEN:
			this.ladeSpiel(input);

			break;
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
			if (input.equals("speichern")) {
				this.spielSpeichern();
			} else if (this.rundeZug == 4 && !this.isSonderRegelGeprueft) {
				if (input.equals("j")) {
					this.controlZug.setSonderregel(true);
					this.isSonderRegelGeprueft = true;
				} else {
					this.controlZug.setSonderregel(false);
					this.isSonderRegelGeprueft = true;
				}

			} else {

				// //////// KI SPIEL
				
				
					this.isZugErfolgtreich = this.controlZug
					        .naechsterZug(input);
					
					if(this.isKiSpiel && !this.isZugErfolgtreich){
						while(!this.isZugErfolgtreich){
							input = this.controlKI.getKIBefehl(this.rundeZug);
							this.isZugErfolgtreich = this.controlZug
							        .naechsterZug(input);
						
						}
					}

					if (this.isZugErfolgtreich && this.spielfeld != null
					        && !this.isKiSpiel) {
						this.letzterBefehl = input;
						this.main.getOutput().print("Letzter Befehl:" + input);
						this.main.getOutput().print(this.spielfeld.toString());
					}
				
			}

			break;
		case SPIELRUNDENENDE:
			this.rundeSpiel--;

			if (this.rundeSpiel == 0) {

				Control.STATUS = Control.STATUS.HAUPTMENU;

				this.main.getControl().checkInput("");

				int punkte = this.spielfeld.getAnzahlLeererFelder();
				this.istDran.setPunkte(punkte);
				this.istDran.setGesamtpunkte(this.istDran.getGesamtpunkte()
				        + punkte);
				;
				this.main.getHighscore().neuerHighScore(this.istDran.getName(),
				        punkte);
				this.main.getOutput().print(
				        "" + this.istDran.getName() + " hat "
				                + this.istDran.getGesamtpunkte()
				                + " Punkte erreicht ");

				this.resetSpiel();
			} else {
				Control.STATUS = Control.STATUS.SPIELVORBEREITUNG;

				int punkte = this.spielfeld.getAnzahlLeererFelder();
				this.istDran.setPunkte(punkte);
				this.istDran.setGesamtpunkte(this.istDran.getGesamtpunkte()
				        + punkte);

				this.main.getHighscore().neuerHighScore(this.istDran.getName(),
				        punkte);
				this.main.getOutput().print(
				        "" + this.istDran.getName() + " hat "
				                + this.istDran.getGesamtpunkte()
				                + " Punkte erreicht ");
				this.resetRunde();

			}

			break;
		default: // Fehler ung�ltiger Status;
			break;
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
	 * @param spielfeld
	 *            the spielfeld to set
	 */
	public void setSpielfeld(Spielfeld spielfeld) {
		this.spielfeld = spielfeld;
	}

	private void resetSpiel() {
		this.rundeSpiel = 1;
		this.rundeZug = 1;
		this.spieler1 = null;
		this.spieler2 = null;
		this.spielfeld = null;
		this.nameSpieler1 = null;
		this.nameSpieler2 = null;
		this.controlZug.setSonderregel(false);
		this.isSonderRegelGeprueft = false;
	}

	private void resetRunde() {

		this.rundeZug = 1;

		this.spielfeld = null;

		this.controlZug.setSonderregel(false);
		this.isSonderRegelGeprueft = false;
	}

	private void spielSpeichern() {
		int num = this.leseListeSpielstaende().size();
		ControlSpeichern conSp = new ControlSpeichern();
		conSp.setModus(modus);
		conSp.setTyp(typ);
		conSp.setSpieler1(spieler1);
		conSp.setSpieler2(spieler2);
		conSp.setSpielfeld(spielfeld);
		conSp.setRundeSpiel(this.rundeSpiel);
		conSp.setRundeZug(this.rundeZug);
		conSp.setSpielbrett(spielfeld.getSpielbrett());
		conSp.setIstDran(this.istDran);
		conSp.setSpeicherDatum(new Date());
		FileHandler filehandler = new FileHandler();
		filehandler.save(this.filename + "" + num, conSp);
		this.main.getOutput().print("Spiel gespeichert");
	}

	private void ladeSpiel(String num) {

		String name = this.filename + num;

		if (fileExists(name)) {
			this.main.getOutput().print("Spiel geladen");
			ControlSpeichern conSp = new ControlSpeichern();
			FileHandler fileHandler = new FileHandler();
			conSp = fileHandler.load(name, conSp);
			this.modus = conSp.getModus();
			this.typ = conSp.getTyp();
			this.spieler1 = conSp.getSpieler1();
			this.spieler2 = conSp.getSpieler2();
			this.spielfeld = conSp.getSpielfeld();
			this.rundeSpiel = conSp.getRundeSpiel();
			this.rundeZug = conSp.getRundeZug();
			this.istDran = conSp.getIstDran();
			this.spielfeld.setSpielbrett(conSp.getSpielbrett());

			Control.STATUS = Control.STATUS.SPIELRUNDE;
			this.starteSpiel("");
		} else {
			this.main.getOutput().print("kein Spiel geladen");
			Control.STATUS = Control.STATUS.HAUPTMENU;
		}
	}

	private boolean fileExists(String filename) {
		File f = new File(filename);
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
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
				        "Bitte Namen f�r Spieler 1 eingeben:");

			} else if (this.nameSpieler2 == null) {
				this.main.getOutput().print("Info: mindestens 3 Buchstaben.");
				this.main.getOutput().print(
				        "Bitte Namen f�r Spieler 2 eingeben:");

			}
			break;
		default: // Fehler ung�ltiger Status;
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
