package Control;
import java.io.Console;

public class Control {

	private String status;

	public Control() {
		this.status = "haupmenu";

	}
	public void checkInput(String input) {

		if (chekForUpperCase(input)) {

			switch (status) {
			case "hauptmenu":
				; // was im Hauptmenu so da sein sollte
				this.hauptmenu(input);

				break;
			case "unterMenuB": // ;

				break;

			default: // Fehler ungültiger Status;
				break;
			}
		}
	}

	private boolean chekForUpperCase(String input) {
		return false;
	}

	private void hauptmenu(String input) {

		// Auswahl im Hauptmenu

		switch (input) {
		case "a":
			this.status = "unterMenuA";

			break;
		case "b":
			this.status = "unterMenuA";

			break;

		default: // Fehler ungültiger Status;
			break;
		}
	}
}
