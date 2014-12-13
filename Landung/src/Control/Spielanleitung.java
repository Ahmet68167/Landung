package Control;

public class Spielanleitung {

	public String getSpielanleitung() {

		String erg = "\t\t\t\tSpielanleitung \n"
				+ "-----------------------------------------------------------------------------------------------"			
				+ "\n\tSpielinhalt:Ein Spielfeld mit 5x5 Felder.Jeder Spieler "
				+ "\n\tverfügt über 9 Steine.Highscore-ListeVorbereitung:Es gibt 2 Spielmodi "
				+ "\n\t(Spieler vs. Spieler oder Spieler vs. Computer ).Man kann dann auswählen über"
				+ "\n\tBestofOne oder BestofThree. -BestofOne besteht aus nur einem Spiel.BestofThree"
				+ "\n\tbesteht aus drei Spielen. (die Punkte, die die Spieler in den 3 Spielen bekommen,"
				+ "\n\taddieren sich)Bei diesem Spielmodus kann es zu einem Unentschieden nach Punkten"
				+ "\n\tkommen.→ der Spieler der 2 von drei Spielen gewonnen hat ist auch der End-Sieger."
				+ "\n\tMan kann ein neues Spiel starten oder ein gespeichertes Spiel laden.Bei einem"
				+ "\n\tSpiel gegen den Computer kann man noch zwischen 3 Schwierigkeitsgraden unterscheiden"
				+ "\n\tund dann wird der erste Spieler automatisch ausgelost.Wie wird ein Zug "
				+ "\n\teingegeben:Gesetzt wird, indem man ein Koordinatenpaar eintippt. "
				+ "\n\t(Beispiel: „b1“ oder „c3“)Gezogen wird, indem man zwei Koordinatenpaare eintippt."
				+ "\n\t(Beispiel: „b1b4“ oder „a1e5“)Gezogen, wenn alle 9 Steine auf dem Spielbrett sind,"
				+ "\n\twird indem man drei Koordinatenpaare eintippt. (Beispiel: „b1b4c1“ oder"
				+ "\n\t„a1e5a5“Spielablauf:Phase 1: (beim Starten eines Spieles):Es werden die Namen der"
				+ "\n\tbeiden Spieler festgelegtEs wird automatisch und zufällig vom Spiel ausgewählt, "
				+ "\n\twelcher der beiden Spieler beginntPhase 2: (beginnt ab Runde 1):Spiel bis Runde 31. "
				+ "\n\tZug Spieler1: Spieler1 setzt einen Stein auf ein beliebiges Feld auf dem Spielbrett1."
				+ "\n\tZug Spieler2: Spieler 2 setzt einen Stein auf ein beliebiges Feld auf dem Spielbrett,"
				+ "\n\tjedoch muss das Feld leer sein.2. Zug Spieler1: Spieler1 muss seinen Stein ziehen."
				+ "\n\t*2.Zug Spieler2: Spieler2 hat nun 2 Möglichkeiten:1. Möglichkeit ist, den gelegten"
				+ "\n\tStein zu ziehen.*2. Möglichkeit ist, dass er einen neuen Spielstein auf ein freies "
				+ "\n\tFeld legen kann. (Dieser Zug darf nur in der 2.Spielrunde vollzogen werden und auch"
				+ "\n\tnur von Spieler2)Phase 3: (einen Stein Ziehen)Der Spieler, der an der Reihe ist muss"
				+ "\n\tjetzt seinen Stein ziehen, jedoch muss die gezogene Position mindestens 3 Spielfelder"
				+ "\n\tAbstand zur Ausgangsposition betragen. Automatisch (bis Ende der Runde 18!) setzt"
				+ "\n\tdas Spiel einen neuen Stein direkt hinter den gezogenen Stein.Regeln beim "
				+ "\n\tZiehen:gegnerische Steine dürfen nicht geworfen oder übersprungen werden.Steine"
				+ "\n\tdürfen nicht beliebig gesetzt werden, die Ausnahme bilden hier jeweils der 1. Zug "
				+ "\n\tund der 2. Zug von Spieler2Ein Zug darf nur diagonal, horizontal oder vertikal "
				+ "\n\terfolgen.Das Spielfeld hat einen Rand, d.h. Man kann nicht aus dem Spielfeld heraus"
				+ "\n\tziehenZusatzregel ab Runde 19: Falls die Spieler alle ihre 9 Steine auf dem Spielfeld"
				+ "\n\t „plaziert“ haben, nehmen sie einen beliebigen Stein auf dem Spielbrett (ihrer Farbe)"
				+ "\n\tund legen ihn hinter den soeben gezogenen Stein.Spielziel:Gewinne können "
				+ "\n\tfolgendermaßen aussehen:1. Möglichkeit :Man bringt 4 Steine in eine Reihe (horizontal,"
				+ "\n\tvertikal, diagonal)2. Möglichkeit: Der Gegner kann keinen gültigen Zug mehr"
				+ "\n\tdurchführen.Punkte:der Gewinner eines Spiels, bekommt für jedes freie Feld auf dem"
				+ "\n\tSpielbrett jeweils einen Punkt\n"
				+ "-----------------------------------------------------------------------------------------------\n";
	




		return erg;
	}
}
