package tunier;

import java.util.ArrayList;

public class ControlKI {

	private ArrayList<String> randMoveList;


	public ControlKI(ControlSpiel controlSpiel) {

		this.randMoveList = new ArrayList<>();

		this.fillWithAllMoves();

		
	}

	public String getKIBefehl(int runde) {

		return this.randMoveList.get((int) (Math.random() * this.randMoveList.size()-1));
	}

	private void fillWithAllMoves(){
		
		String tmp="";
		for(int i = 0; i < 5;i++ ){
			tmp = ""+(char) (97+i);
			for(int k = 0; k< 5;k++){
				 randMoveList.add(tmp+""+(k+1));
			}
		}
		
		for(int i = 0; i < 5;i++ ){
		
			for(int k = 0; k< 5;k++){
		
				for(int j = 0; j<5;j++){
					
					for(int l= 0;l<5;l++){
						tmp = ""+(char) (97+i);
						tmp +=""+(k+1);
						tmp +=""+(char) (97+j);
						this.randMoveList.add(tmp+""+(l+1));
						
					}
				}
			}
			
		}
		
	}
}
