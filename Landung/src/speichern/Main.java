package speichern;

import java.util.ArrayList;



public class Main {

	private Map map;
	ArrayList<Object> objList;
	private FileHandler fileHandler;

	public static void main(String[] args) {
		new Main();		
	}
	public Main() {
		this.init();	
		// neues Spielbrett
		this.map.setBoard(new String[10][10]);	
		// setzt einen Wert 
		this.map.board[0][0] = "BEFORE SAVE";
		// Speichert das Objekt datei name , objekt
		this.fileHandler.save("save.game", this.map);
		// verändert es lokal
		this.map.board[0][0] = "CHANGE LOKAL";		
		System.out.println(this.map.board[0][0]);
		// überschreibt das objekt mit dem geladenen
		this.map = this.fileHandler.load("save.game",this.map);		
		System.out.println(this.map.board[0][0]);
	}
	private void init() {
		this.map         = new Map();		
		this.fileHandler = new FileHandler();
	}
}
