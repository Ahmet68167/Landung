package jUnitTests.TestControl;

import static org.junit.Assert.*;
import model.spieler.MenschSpieler;
import model.spieler.Spieler;
import model.spielfeld.Spielfeld;
import model.spielstein.Spielstein;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Control.ZugPruefung;

public class ZugPruefungTest {

	
	private Spielfeld spielfeld;
	private Spielstein x;
	private Spielstein o;
	private Spieler spieler1;
	private Spieler spieler2;

	@Before
	public void initialize(){
	spielfeld = new Spielfeld(); 
	x = new Spielstein('X');
	o = new Spielstein('O');
	spieler1 = new MenschSpieler("Ahmet", 1);
	spieler2 = new MenschSpieler("Klaus", 2);

	}

	@Test
	public void testIstZugMoeglich() {
		ZugPruefung istMoeglich = new ZugPruefung();
		
		//Spieler1
		int[] a2 = {0,1};
		int[] a1 = {0,0};
		int[] d2 = {3,1};
		int[] d3 = {3,2};
		int[] e2 = {4,1};
		int[] e3 = {4,2};
		
		//Spieler2
		int[] a4 = {0,3};
		int[] c4 = {2,3};
		int[] b3 = {1,2};
		int[] c3 = {2,2};
		int[] b1 = {1,0};
		int[] c1 = {2,0};
		
		spielfeld.setzeSpielstein(x, a2);
		spielfeld.setzeSpielstein(x, a1);
		spielfeld.setzeSpielstein(x, d2);
		spielfeld.setzeSpielstein(x, d3);
		spielfeld.setzeSpielstein(x, e2);
		spielfeld.setzeSpielstein(x, e3);
		
		spielfeld.setzeSpielstein(o, a4);
		spielfeld.setzeSpielstein(o, c4);
		spielfeld.setzeSpielstein(o, b3);
		spielfeld.setzeSpielstein(o, c3);
		spielfeld.setzeSpielstein(o, b1);
		spielfeld.setzeSpielstein(o, c1);
		
		assertFalse(istMoeglich.istZugMoeglich());
		
		spielfeld.leeren();
		
		
		//Muss hier true ergeben
		spielfeld.setzeSpielstein(spieler1.getSpielstein(), a2);
		spielfeld.setzeSpielstein(spieler2.getSpielstein(), e2);
		assertTrue(istMoeglich.istZugMoeglich());
	}

	@Test
	public void testGueltigerZug() {
		ZugPruefung gueltigerZug1 = new ZugPruefung();
		ZugPruefung gueltigerZug2 = new ZugPruefung();
		
		ZugPruefung ungueZug1 = new ZugPruefung();
		
		//Spieler1
		int[] e5 = {4,4};
		
		//Spieler2
		int[] a2 = {0,1};
		
		//gueltig
		int[] e5e2 = {4,1};
		int[] e5e1 = {4,0};
		
		spielfeld.setzeSpielstein(spieler1.getSpielstein(), e5);
		spielfeld.setzeSpielstein(spieler2.getSpielstein(), a2);
		System.out.println(spielfeld);
		
		assertFalse(ungueZug1.gueltigerZug(e5, a2));
		assertTrue(gueltigerZug1.gueltigerZug(e5, e5e2));
		assertTrue(gueltigerZug2.gueltigerZug(e5, e5e1));
	}

	
	
	
	
	// Kann wohl raus, wird durch testGueltigerZug abgefangen
	@Ignore
	public void testTesteVertikal() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testTesteHorizontal() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testTesteDiagonalOben() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testTesteDiagonalUnten() {
		fail("Not yet implemented");
	}

}
