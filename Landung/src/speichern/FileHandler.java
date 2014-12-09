package speichern;

import java.io.*;
import java.util.LinkedList;
import java.beans.*;

public class FileHandler {
	public void save(String filename, Object obj) {
		XMLEncoder enc = null;
		try {
			enc = new XMLEncoder(new FileOutputStream(filename));
			enc.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (enc != null)
				enc.close();
		}		
	}	
	public <T> T load(String filename, T obj) {
		XMLDecoder dec = null;		
		try {
			dec = new XMLDecoder(new FileInputStream(filename));
			T saveObj = (T) dec.readObject();
			return saveObj;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dec != null)
				dec.close();
		}
		
		return null;
	}

}