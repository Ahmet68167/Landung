package Control;

import java.util.regex.Pattern;

import model.spieler.Spieler;

public class ControlZug {

	private ControlSpiel controlSpiel;

	public ControlZug(ControlSpiel controlSpiel) {
	   this.controlSpiel = controlSpiel;
    }

	public void naechsterZug(String eingabe) {
		if(!istZugMoeglich() && this.controlSpiel.getRundeZug() > 2) {
    		this.controlSpiel.naechsterSpieler();
    		this.controlSpiel.main.getOutput().print(this.controlSpiel.getIstDran().getName() + " hat gewonnen.");
    		Control.STATUS =Control.STATUS.HAUPTMENU;
    	} else {
		
    		if(macheZug(eingabe)) {
    			if(gewonnen()) {
    				this.controlSpiel.main.getOutput().print(this.controlSpiel.getIstDran().getName() + " hat gewonnen.");
    				Control.STATUS =Control.STATUS.HAUPTMENU;
    			} else {
    				this.controlSpiel.setRundeZug(this.controlSpiel.getRundeZug() + 1);
    				this.controlSpiel.naechsterSpieler();
    			}
    		}
    	}
		
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
    		 
    	//} else if(this.controlSpiel.getRundeZug() == 3) {
    		
    		// Abfrage ob Sonderregel angewendet werden soll
    		//this.controlSpiel.main.getOutput().print(txt);
    		
    	} else if(this.controlSpiel.getRundeZug() >= 3 && this.controlSpiel.getRundeZug() < 19) {
    		if(eingabe.length() == 4) {
        		start[0] = getKoordinaten(eingabe)[0];
        		start[1] = getKoordinaten(eingabe)[1];
        		ziel[0] = getKoordinaten(eingabe)[2];
        		ziel[1] = getKoordinaten(eingabe)[3];
        		
        		if(!gueltigerZug(start, ziel))
        			return false;
		
        		ziel = zieheZug(start, ziel);
        		
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
        		
        		ziel = zieheZug(start, ziel);
        		
        		if(this.controlSpiel.getSpielfeld().fetchSpielstein(entf).getSymbol() != this.controlSpiel.getIstDran().getSymbol())
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
		if(this.controlSpiel.getSpielfeld().fetchSpielstein(start).getSymbol() != 
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
				return testeDiagonalUnten(start, ziel);
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
	
	public boolean gewonnen() {
		int[] pos = new int[2];
		int anzahl = 0;
		int anzahl2 = 0;
		int anzahl3 = 0;
		int anzahl4 = 0;
		int anzahl5 = 0;
		int anzahl6 = 0;
		int anzahl7 = 0;
		int anzahl8 = 0;
		
		for(int k = 0; k < 5; k++) {
			for(int i = 0; i < 2; i++) {
				
				pos[0] = k;
				pos[1] = i;
				
				for(int n = 0; n < 4; n++) {
					if(this.controlSpiel.getIstDran().getSymbol() == this.controlSpiel.getSpielfeld().fetchSpielstein(pos).getSymbol()) {
					pos[1] += 1;
					anzahl++;
					}
				}
				
				if(anzahl >= 4) {
					return true;
				} else
					anzahl = 0;
				
				pos[0] = i;
				pos[1] = k;
				
				for(int n = 0; n < 4; n++) {
					if(this.controlSpiel.getIstDran().getSymbol() == this.controlSpiel.getSpielfeld().fetchSpielstein(pos).getSymbol()) {
					pos[0] += 1;
					anzahl++;
					}
				}
				
				if(anzahl >= 4) {
					return true;
				} else
					anzahl = 0;
				
			}
		}
		
		for(int i = 0; i < 4; i++) {
			pos[0] = i;
			pos[1] = i + 1;
			
			if(this.controlSpiel.getIstDran().getSymbol() == this.controlSpiel.getSpielfeld().fetchSpielstein(pos).getSymbol()) {
				anzahl++;
			}
			
			pos[0] = i + 1;
			pos[1] = i;
			
			if(this.controlSpiel.getIstDran().getSymbol() == this.controlSpiel.getSpielfeld().fetchSpielstein(pos).getSymbol()) {
				anzahl2++;
			}
			
			pos[0] = i;
			pos[1] = 3 - i;
			
			if(this.controlSpiel.getIstDran().getSymbol() == this.controlSpiel.getSpielfeld().fetchSpielstein(pos).getSymbol()) {
				anzahl3++;
			}
			
			pos[0] = i + 1;
			pos[1] = 4 - i;
			
			if(this.controlSpiel.getIstDran().getSymbol() == this.controlSpiel.getSpielfeld().fetchSpielstein(pos).getSymbol()) {
				anzahl4++;
			}
			
			pos[0] = i;
			pos[1] = i;
			
			if(this.controlSpiel.getIstDran().getSymbol() == this.controlSpiel.getSpielfeld().fetchSpielstein(pos).getSymbol()) {
				anzahl5++;
			}
			
			pos[0] = i + 1;
			pos[1] = i + 1;
			
			if(this.controlSpiel.getIstDran().getSymbol() == this.controlSpiel.getSpielfeld().fetchSpielstein(pos).getSymbol()) {
				anzahl6++;
			}
			
			pos[0] = i;
			pos[1] = 4 - i;
			
			if(this.controlSpiel.getIstDran().getSymbol() == this.controlSpiel.getSpielfeld().fetchSpielstein(pos).getSymbol()) {
				anzahl7++;
			}
			
			pos[0] = i + 1;
			pos[1] = 3 - i;
			
			if(this.controlSpiel.getIstDran().getSymbol() == this.controlSpiel.getSpielfeld().fetchSpielstein(pos).getSymbol()) {
				anzahl8++;
			}
			
		}
		
		if(anzahl >= 4 || anzahl2 >= 4 || anzahl3 >= 4 || anzahl4 >= 4 || anzahl5 >= 4 || anzahl6 >= 4 || anzahl7 >= 4 || anzahl8 >= 4) {
			return true;
		} else {
			anzahl = 0;
			anzahl2 = 0;
			anzahl3 = 0;
			anzahl4 = 0;
			anzahl5 = 0;
			anzahl6 = 0;
			anzahl7 = 0;
			anzahl8 = 0;
		}
		
		return false;
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
