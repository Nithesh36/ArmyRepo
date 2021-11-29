package configMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropFileReader {
	
public static Properties prop;
	
	public static void readProp(String Loc) {
		  prop= new Properties();
		  File file = new File(Loc);

	  try {
		prop.load(new FileInputStream(file));
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}
	
}
