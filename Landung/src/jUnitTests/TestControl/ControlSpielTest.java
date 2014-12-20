package jUnitTests.TestControl;

import static org.junit.Assert.*;
import model.spieler.MenschSpieler;
import model.spieler.Spieler;
import model.spielfeld.Spielfeld;
import model.spielstein.Spielstein;

import org.junit.Before;
import org.junit.Test;

import Control.ControlSpiel;
import Control.ControlZug;

public class ControlSpielTest {
	
	private Spielfeld spielfeld;
	private Spielstein x;
	private Spielstein o;
	private Spieler spieler1;
	private Spieler spieler2;
	private ControlSpiel controlSpiel;
	
	
	@Before
	public void initControlSpiel(){
		spielfeld = new Spielfeld();
		x = new Spielstein();
		o = new Spielstein();
		spieler1 = new MenschSpieler("Spieler1", 1);
		spieler2 = new MenschSpieler("Spieler2", 2);
		controlSpiel = new ControlSpiel(null);
	}

	@Test
	public void testGetRundeZug() {
		
	}

	@Test
	public void testSetRundeZug() {
		fail("Not yet implemented");
	}

	@Test
	public void testControlSpiel() {
		fail("Not yet implemented");
	}

	@Test
	public void testStarteSpiel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIstDran() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIstDran() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTypModus() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpieler1() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpieler2() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpielfeld() {
		fail("Not yet implemented");
	}

	@Test
	public void testNaechsterSpieler() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRundeSpiel() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRundeSpiel() {
		fail("Not yet implemented");
	}

}
