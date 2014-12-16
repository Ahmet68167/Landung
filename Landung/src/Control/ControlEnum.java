package Control;

public enum ControlEnum {

	START("Start"), HAUPTMENU("Hauptmenu"), LADEN("Spiel laden"), HIGHSCORE(
	        "Highscore"), NEUESSPIEL("Neues Spiel"), SvsS(
	        "Spieler gegen Spieler"), SvsKI("Spieler gegen KI"), BESTOFONE(
	        "Best of One"), BESTOFTHREE("Best of Three"), STARTESPIEL(
	        "Starte das Spiel"), SPIELLAEUFT("Spiel laeuft"), ENDE("Ende"), SPIELERNAMENEINGEBEN(
	        "Spieler namen eingeben"), SPIELVORBEREITUNG("Spielvorbereitung"), SPIELEINSTELLUNGEN(
	        "Spieleinstellungen"), SPIELRUNDE("Spielrunde"), SPIELRUNDENENDE(
	        "Ende der Spielrunde"), SPIELENDE("Spiel beendet"), SPEICHERN(
	        "Spiel speichern"), LADENAUSWAHL("Liste Spielstaende"), SPIELANLEITUNG("Spielanleitung");

	private String name;

	private ControlEnum(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

}
