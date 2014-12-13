package Control;

public class Spielanleitung {

	public String getSpielanleitung() {

		String erg = "Spielanleitung \n Spielinhalt:Ein Spielfeld mit 5x5 Felder.Jeder Spieler verfügt über 9 Steine.Highscore-ListeVorbereitung:Es gibt 2 Spielmodi (Spieler vs. Spieler oder Spieler vs. Computer ).Man kann dann auswählen über BestofOne oder BestofThree. -BestofOne besteht aus nur einem Spiel.BestofThree besteht aus drei Spielen. (die Punkte, die die Spieler in den 3 Spielen bekommen, addieren sich)Bei diesem Spielmodus kann es zu einem Unentschieden nach Punkten kommen.→ der Spieler der 2 von drei Spielen gewonnen hat ist auch der End-Sieger.Man kann ein neues Spiel starten oder ein gespeichertes Spiel laden.Bei einem Spiel gegen den Computer kann man noch zwischen 3 Schwierigkeitsgraden unterscheiden und dann wird der erste Spieler automatisch ausgelost.Wie wird ein Zug eingegeben:Gesetzt wird, indem man ein Koordinatenpaar eintippt. (Beispiel: „b1“ oder „c3“)Gezogen wird, indem man zwei Koordinatenpaare eintippt. (Beispiel: „b1b4“ oder „a1e5“)Gezogen, wenn alle 9 Steine auf dem Spielbrett sind, wird indem man drei Koordinatenpaare eintippt. (Beispiel: „b1b4c1“ oder „a1e5a5“Spielablauf:Phase 1: (beim Starten eines Spieles):Es werden die Namen der beiden Spieler festgelegtEs wird automatisch und zufällig vom Spiel ausgewählt, welcher der beiden Spieler beginntPhase 2: (beginnt ab Runde 1):Spiel bis Runde 31. Zug Spieler1: Spieler1 setzt einen Stein auf ein beliebiges Feld auf dem Spielbrett1. Zug Spieler2: Spieler 2 setzt einen Stein auf ein beliebiges Feld auf dem Spielbrett, jedoch muss das Feld leer sein.2. Zug Spieler1: Spieler1 muss seinen Stein ziehen.*2.Zug Spieler2: Spieler2 hat nun 2 Möglichkeiten:1. Möglichkeit ist, den gelegten Stein zu ziehen.*2. Möglichkeit ist, dass er einen neuen Spielstein auf ein freies Feld legen kann. (Dieser Zug darf nur in der 2.Spielrunde vollzogen werden und auch nur von Spieler2)Phase 3: (einen Stein Ziehen)Der Spieler, der an der Reihe ist muss jetzt seinen Stein ziehen, jedoch muss die gezogene Position mindestens 3 Spielfelder Abstand zur Ausgangsposition betragen. Automatisch (bis Ende der Runde 18!) setzt das Spiel einen neuen Stein direkt hinter den gezogenen Stein.Regeln beim Ziehen:gegnerische Steine dürfen nicht geworfen oder übersprungen werden.Steine dürfen nicht beliebig gesetzt werden, die Ausnahme bilden hier jeweils der 1. Zug und der 2. Zug von Spieler2Ein Zug darf nur diagonal, horizontal oder vertikal erfolgen.Das Spielfeld hat einen Rand, d.h. Man kann nicht aus dem Spielfeld heraus ziehenZusatzregel ab Runde 19: Falls die Spieler alle ihre 9 Steine auf dem Spielfeld „plaziert“ haben, nehmen sie einen beliebigen Stein auf dem Spielbrett (ihrer Farbe) und legen ihn hinter den soeben gezogenen Stein.Spielziel:Gewinne können folgendermaßen aussehen:1. Möglichkeit :Man bringt 4 Steine in eine Reihe (horizontal, vertikal, diagonal)2. Möglichkeit: Der Gegner kann keinen gültigen Zug mehr durchführen.Punkte:der Gewinner eines Spiels, bekommt für jedes freie Feld auf dem Spielbrett jeweils einen Punkt";
		String txt = "";

		int i = 0;
		for (Character c : erg.toCharArray()) {

			if (i % 15 == 0) {
				txt += "\n";
			}
			txt += erg;
		}

		return txt;
	}
}
