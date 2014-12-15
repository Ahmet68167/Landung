package Control;

import java.util.ArrayList;

public class ControlKI {
	
	public ControlKI(ControlSpiel controlSpiel) {
	    // TODO Auto-generated constructor stub
    }

	public String getKIBefehl(){
		
		ArrayList<String> move = new ArrayList<>();
		move.add("a1");
		move.add("a2");
		move.add("a3");
		move.add("a4");
		move.add("a5");
		move.add("b1");
		move.add("b2");
		move.add("b3");
		move.add("b4");
		move.add("b5");
		
		int rand =(int) Math.round( Math.random() *9);
		
	
		return move.get(rand);
	}

}
