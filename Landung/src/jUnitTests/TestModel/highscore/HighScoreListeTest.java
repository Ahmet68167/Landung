package jUnitTests.TestModel.highscore;

import static org.junit.Assert.*;
import model.highscore.HighScoreListe;

import org.junit.Before;
import org.junit.Test;

public class HighScoreListeTest {
	
	private HighScoreListe liste;
	
	@Before
	public void initHighScoreListe(){
		liste = new HighScoreListe();
	}

	@Test
	public void testHighScoreListe() {
		fail("Not yet implemented");
	}

	@Test
	public void testNeuerHighScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testSchreibeInDatei() {
		liste.schreibeInDatei();
	}

	@Test
	public void testLadeListe() {
		liste.ladeListe();
	}

	@Test
	public void testToString() {
		assertEquals("----------------\n"
				+ "Platz 1 Steffen 30\n"
				+ "Platz 2 Steffen 30\n"
				+ "Platz 3 Steffen 30\n"
				+ "Platz 4 Steffen 30\n"
				+ "Platz 5 adsf 25\n"
				+ "Platz 6 asdf 25\n"
				+ "Platz 7 asdf 24\n"
				+ "Platz 8 asdf 24\n"
				+ "Platz 9 wer 24\n"
				+ "Platz 10 asdf 23\n"
				+ "----------------\n", liste.toString());
	}

}
