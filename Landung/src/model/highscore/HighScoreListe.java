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
	private static final File datei = new File("HighScore.txt");
	private List<HighScore> liste;
	
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
		FileWriter writer;
		
		try {
			writer = new FileWriter(this.datei, false);
			
			for(int i = 0; i < this.liste.size() && i < ANZAHL; i++)
				writer.write(this.liste.get(i) + "\r\n");
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.liste = ladeListe();
	}
	
	public List<HighScore> ladeListe() {
		List<HighScore> liste = new LinkedList<>();
		String zeile;
		int pos = 0;
		
		try {
			Scanner s = new Scanner(datei);
			while(s.hasNextLine() && pos < ANZAHL) {
				zeile = s.nextLine();
				liste.add(new HighScore(zeile.split(" ")[0], Integer.parseInt(zeile.split(" ")[1])));
				pos++;
			}
			
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
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
