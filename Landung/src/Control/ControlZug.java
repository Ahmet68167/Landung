package Control;

import java.util.regex.Pattern;

import model.spieler.Spieler;

public class ControlZug {

	private ControlSpiel controlSpiel;

	public ControlZug(ControlSpiel controlSpiel) {
	   this.controlSpiel = controlSpiel;
	
    }

	public void nexterZug() {
	    
    }
	
    private boolean hattSpielsteine(Spieler spieler){
    	if(spieler.getSpielSteinListeSize() > 0){
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean macheZug(String eingabe) {
    	int[] start = new int[2];
    	int[] ziel = new int[2];
    	int[] entf = new int[2];
    	
    	if(this.controlSpiel.getRundeZug() < 3) {
    	
    		if(eingabe.length() == 2) { 			
    			start = getKoordinaten(eingabe);
    			
    			if(!this.controlSpiel.getSpielfeld().isEmpty(start))
    				return false;
    			
    			this.controlSpiel.getSpielfeld().setzeSpielstein(this.controlSpiel.getIstDran().getSpielstein(), start);
    			return true;
    		}
    		 return false;
    		 
    	} else if(this.controlSpiel.getRundeZug() == 3) {
    		
    		// Abfrage ob Sonderregel angewendet werden soll
    		
    		
    	} else if(this.controlSpiel.getRundeZug() > 3 && this.controlSpiel.getRundeZug() < 19) {
    		if(eingabe.length() == 4) {
        		start[0] = getKoordinaten(eingabe)[0];
        		start[1] = getKoordinaten(eingabe)[1];
        		ziel[0] = getKoordinaten(eingabe)[2];
        		ziel[1] = getKoordinaten(eingabe)[3];
        		ziel = zieheZug(start, ziel);
        		
        		if(!gueltigerZug(start, ziel))
    				return false;
        		
            	this.controlSpiel.getSpielfeld().setzeSpielstein(this.controlSpiel.getIstDran().getSpielstein(), ziel);
            	return true;
        	}
    		return false;
    		
    	} else if(this.controlSpiel.getRundeZug() >= 19) {
    		if(eingabe.length() == 6) { 			
        		start[0] = getKoordinaten(eingabe)[0];
        		start[1] = getKoordinaten(eingabe)[1];
        		ziel[0] = getKoordinaten(eingabe)[2];
        		ziel[1] = getKoordinaten(eingabe)[3];
        		entf[0] = getKoordinaten(eingabe)[4];
        		entf[1] = getKoordinaten(eingabe)[5];
        		
        		if(!gueltigerZug(start, ziel))
    				return false;
        		
        		if(this.controlSpiel.getSpielfeld().getSpielstein(entf).getSymbol() != this.controlSpiel.getIstDran().getSymbol())
        			return false;
        		
        		ziel = zieheZug(start, ziel);
        		this.controlSpiel.getSpielfeld().setzeSpielstein(this.controlSpiel.getSpielfeld().entferneSpielstein(entf), ziel);
            	return true;
    		}
    		return false;
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
		// Pruefe start 
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

	public int[] zieheZug(int[] start, int[] ziel) {
		this.controlSpiel.getSpielfeld().zieheSpielstein(start, ziel);
		
		if(start[0] == ziel[0] && start[1] - ziel[1] < 0) {
			ziel[1] -= 1;
			} else if(start[0] == ziel[0] && start[1] - ziel[1] > 0) {
			ziel[1] += 1;
		} else if(start[0] - ziel[0] < 0 && start[1] == ziel[1]) {
			ziel[0] -= 1;
		} else if(start[0] - ziel[0] > 0 && start[1] == ziel[1]) {
			ziel[0] += 1;
		} else if(start[0] - ziel[0] < 0 && start[1] - ziel[1] < 0) {
			ziel[0] -= 1;
			ziel[1] -= 1;
		} else if(start[0] - ziel[0] < 0 && start[1] - ziel[1] > 0) {
			ziel[0] -= 1;
			ziel[1] += 1;
		} else if(start[0] - ziel[0] > 0 && start[1] - ziel[1] < 0) {
			ziel[0] += 1;
			ziel[1] -= 1;
		} else if(start[0] - ziel[0] > 0 && start[1] - ziel[1] > 0) {
			ziel[0] += 1;
			ziel[1] += 1;
		}
		
		return ziel;
	}
	
	public static boolean gueltigeEingabe(String eingabe) {
		boolean gueltig = false;
		
		if(Pattern.matches("[a-e][1-5]|[a-e][1-5][a-e][1-5]|[a-e][1-5][a-e][1-5][a-e][1-5]", eingabe))
			return true;
		
		return gueltig;	
	}
	
	public int[] getKoordinaten(String eingabe) {
		int[] koordinaten = new int[eingabe.length()];
		
		for(int i = 0; i < koordinaten.length; i+=2) {
			koordinaten[i] = eingabe.charAt(i) - 'a';
			koordinaten[i+1] = eingabe.charAt(i+1) - '0' - 1;
		}
		
		return koordinaten;
	}

}
