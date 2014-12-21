package Control.zugTest;

import java.util.Comparator;

public class ZugComparator implements Comparator<Zug> {

	@Override
	public int compare(Zug arg0, Zug arg1) {
		if(arg0.getBewertung() <= arg1.getBewertung())
			return 1;
		else
			return -1;
	}

}
