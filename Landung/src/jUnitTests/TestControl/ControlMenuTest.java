package jUnitTests.TestControl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Control.Control;
import Control.ControlMenu;
import Main.Main;


public class ControlMenuTest {
	
	private Main main;
	private Control control;
	private ControlMenu menu;
	
	@Before
	public void initControlMenu(){
		menu = new ControlMenu(main, control);
	}

	@Ignore //Konstruktor
	public void testControlMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckInput() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSTATUS() {
		assertEquals(null, menu.getSTATUS());
	}

	@Test
	public void testPrintStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsGegenKI() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsGegenMensch() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsBestOfOne() {		
		fail("Not yet implemented");
	}

	@Test
	public void testIsBestOfThree() {
		fail("Not yet implemented");
	}

}
