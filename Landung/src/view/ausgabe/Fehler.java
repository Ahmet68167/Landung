package view.ausgabe;

public class Fehler {

	public static void pfadblockiert() {
		System.out.println("Dein Pfad ist blockiert.");
	}
	
	public static void startFehler() {
		System.out.println("Sie haben keinen Spielstein auf der Startposition");
	}
	
	public static void grossbuchstabe() {
		System.out.println("Es wurde mind. ein Grossbuchstabe eingegeben.");
	}
	
	public static void ungueltigeEingabe() {
		System.out.println("Ungueltige Eingabe. Bitte versuchen Sie es erneut.");
	}
	
	public static void ungueltigesMuster() {
		System.out.println("Ungueltige Eingabe. "
					+ "\nDie Eingabe muss in folgender Form vorliegen: a1a4 (Start/Ziel).");
	}
	
	public static void zweiAbstaendeFehler() {
		System.out.println("Ungueltiger Zug. Es muessen mindestens 2 leere Felder "
				+ "\nzwischen Start- und Zielposition liegen.");
	}
	
}
