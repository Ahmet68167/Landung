package model.highscore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HighScoreListe {

	private static final int ANZAHL = 10;
	private static final String dateiName = "high.score";
	private static final File datei = new File(dateiName);
	
	private List<HighScore> liste ;
	private speichern.FileHandler fileHandler;
	
	public HighScoreListe() {
		if(datei.exists())
			this.liste = ladeListe();
		else {			
			try {
				datei.createNewFile();
				this.liste = new LinkedList<>();
				
			} catch (IOException e) {
				e.printStackTrace();
			}			
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
		String txt = "";
		
		for(int i = 0; i < this.liste.size() && i < ANZAHL; i++) {
			txt += "Platz " + (i+1) + " " + this.liste.get(i) + "\n";
		}
		
		return txt;
	}
	
}
