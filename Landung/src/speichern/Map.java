package speichern;

public class Map {
	
	String[][] board;
	
	public Map(){
		this.board = new String[20][20];
	}

	/**
	 * @return the board
	 */
	public String[][] getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(String[][] board) {
		this.board = board;
	}
	
	
	

}
