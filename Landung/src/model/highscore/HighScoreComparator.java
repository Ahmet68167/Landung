package model.highscore;

import java.util.Comparator;

public class HighScoreComparator implements Comparator<HighScore> {

	@Override
	public int compare(HighScore o1, HighScore o2) {
		if(o1.getPunkte() <= o2.getPunkte())
			return 1;
		else
			return -1;
	}


}
