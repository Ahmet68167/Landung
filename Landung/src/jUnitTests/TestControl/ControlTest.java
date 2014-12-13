package jUnitTests.TestControl;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

public class ControlTest {

	@Ignore
	public void testControl() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckInput() {
		String eingabe = "a1b2";
		
		assertEquals("a1b2", eingabe);
	}

	@Ignore
	public void testPrintStatus() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testIsBeendet() {
		fail("Not yet implemented");
	}

}
