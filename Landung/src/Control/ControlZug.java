package Control;

import model.spieler.Spieler;

public class ControlZug {
	
	

	private ControlSpiel controlSpiel;



	public ControlZug(ControlSpiel controlSpiel) {
	   this.controlSpiel = controlSpiel;
    }



	public void nexterZug() {
	//	this.controlSpiel.spieler1.getSpielstein();
	    
    }
	
    private boolean hattSpielsteine(Spieler spieler){
    	if(spieler.getSpielSteinListeSize() > 0){
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean macheZug(int[] start, int[] ziel) {
    	
    	if(this.controlSpiel.getIstDran().getSpielSteinListeSize() > 0) {
    		
    		if()
    		
    	}
    	
    	return false;
    }
    
    public boolean istZugMoeglich() {
		int[] start = new int[2];
		int[] ziel = new int[2];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < 5; k++) {
					for(int m = 0; m < 5; m++) {
					
						start[0] = i;
						start[1] = j;
						ziel[0] = k;
						ziel[1] = m;
						
						if(gueltigerZug(start, ziel))
							return true;
						
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean gueltigerZug(int[] start, int[] ziel) {
		// Pruefe start  FEHLER BEI Spieler.getSpielstein zu oft remove!!!!!
		if(this.controlSpiel.getSpielfeld().getSpielstein(start).getSymbol() != 
				this.controlSpiel.getIstDran().getSymbol())
			return false;
		
		// Pruefe ziel
		if(!this.controlSpiel.getSpielfeld().isEmpty(ziel))
			return false;
		
		// Teste Vertikal
		if(start[0] == ziel[0] && Math.abs(start[1] - ziel[1]) > 2) {
			if(start[1] - ziel[1] < 0)
				return testeVertikal(start, ziel);
			else if(start[1] - ziel[1] > 0)
				return testeVertikal(ziel, start);
			
		// Teste Horizontal
		} else if(start[1] == ziel[1] && Math.abs(start[0] - ziel[0]) > 2) {
			if(start[0] - ziel[0] < 0) 
				return testeHorizontal(start, ziel);
			else if(start[0] - ziel[0] > 0)
				return testeHorizontal(ziel, start);
		
		// Teste Diagonal
		} else if(Math.abs(start[0] - ziel[0]) == 3 && Math.abs(start[1] - ziel[1]) == 3 ||
				Math.abs(start[0] - ziel[0]) == 4 && Math.abs(start[1] - ziel[1]) == 4) {
			
			if(start[0] - ziel[0] < 0 && start[1] - ziel[1] < 0)
				return testeDiagonalOben(start, ziel);
			else if(start[0] - ziel[0] < 0 && start[1] - ziel[1] > 0)
				return testeDiagonalUnten(start, ziel);
			else if(start[0] - ziel[0] > 0 && start[1] - ziel[1] < 0)
				return testeDiagonalUnten(ziel, start);
			else if(start[0] - ziel[0] > 0 && start[1] - ziel[1] > 0)
				return testeDiagonalOben(ziel, start);
		}
		
		return false;
	}
	
	public boolean testeVertikal(int[] start, int[] ziel) {
		int[] pos = new int[2];
		
		for(int i = 1; i < ziel[1] - start[1]; i++) {
			pos[0] = start[0];
			pos[1] = start[1] + i;
			if(!this.controlSpiel.getSpielfeld().isEmpty(pos))
				return false;
		}
		
		return true;
	}
	
	public boolean testeHorizontal(int[] start, int[] ziel) {
		int[] pos = new int[2];
		
		for(int i = 1; i < ziel[0] - start[0]; i++) {
			pos[0] = start[0] + i;
			pos[1] = start[1];
			if(!this.controlSpiel.getSpielfeld().isEmpty(pos))
				return false;
		}
		
		return true;
	}
	
	public boolean testeDiagonalOben(int[] start, int[] ziel) {
		int[] pos = new int[2];
		
		for(int i = 1; i < ziel[0] - start[0]; i++) {
			pos[0] = start[0] + i;
			pos[1] = start[1] + i;
			if(!this.controlSpiel.getSpielfeld().isEmpty(pos))
				return false;
		}
		
		return true;
	}
	
	public boolean testeDiagonalUnten(int[] start, int[] ziel) {
		int[] pos = new int[2];
		
		for(int i = 1; i <= ziel[0] - start[0]; i++) {
			pos[0] = start[0] + i;
			pos[1] = start[1] - i;
			if(!this.controlSpiel.getSpielfeld().isEmpty(pos))
				return false;
		}
		
		return true;
	}


}
