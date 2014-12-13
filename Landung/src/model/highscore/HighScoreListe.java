package model.highscore;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import speichern.FileHandler;

public class HighScoreListe {

	private static final int ANZAHL = 10;
	private static final String dateiName = "highscore";
	private static final File datei = new File(dateiName);

	private List<HighScore> liste;
	private FileHandler fileHandler;

	public HighScoreListe() {
		this.fileHandler = new FileHandler();

		if (datei.exists())
			this.liste = ladeListe();
		else {
			this.liste = new LinkedList<>();
			schreibeInDatei();
		}

	}

	public void neuerHighScore(String name, int punkte) {
		this.liste = ladeListe();
		HighScore neuerScore = new HighScore(name, punkte);
		this.liste.add(neuerScore);
		this.liste.sort(new HighScoreComparator());
		schreibeInDatei();
	}

	public void schreibeInDatei() {
		fileHandler.save(dateiName, this.liste);
	}

	public List<HighScore> ladeListe() {
		List<HighScore> liste = new LinkedList<>();
		liste = fileHandler.load(dateiName, liste);
		liste.sort(new HighScoreComparator());
		return liste;
	}

	public String toString() {
		String txt = "----------------\n";

		if (this.liste.size() != 0) {

			for (int i = 0; i < this.liste.size() && i < ANZAHL; i++) {
				txt += "Platz " + (i + 1) + " " + this.liste.get(i) + "\n";
			}
		} else {
			txt += "\nkein Eintrag\n";
			
		}
		txt += "----------------\n";
		
		return txt;
	}

}
