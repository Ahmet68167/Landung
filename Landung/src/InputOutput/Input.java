package InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	
	public String read(){
		BufferedReader console = new BufferedReader(new InputStreamReader(
		        System.in));		
		String zeile = null;
		try {
			zeile = console.readLine();

		} catch (IOException e) {

			return "";
		}
		return zeile;
	}

}
