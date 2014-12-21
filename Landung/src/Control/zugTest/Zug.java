package Control.zugTest;

public class Zug {

	private String zug;
	private int bewertung;
	
	public Zug(String zug, int bewertung) {
		this.setZug(zug);
		this.setBewertung(bewertung);
	}

	public String getZug() {
		return zug;
	}

	public void setZug(String zug) {
		this.zug = zug;
	}

	public int getBewertung() {
		return bewertung;
	}

	public void setBewertung(int bewertung) {
		this.bewertung = bewertung;
	}
	
	public String toString() {
		return this.zug + " " + this.bewertung;
	}
	
}
