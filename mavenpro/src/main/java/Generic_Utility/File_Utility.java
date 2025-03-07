package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class File_Utility {
	
	public String getCommonData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/browser.properties");

		// step2:- load all the keys from properties file
		Properties pro = new Properties();
		pro.load(fis);

		// step3:- get keys from properties file
		String Value = pro.getProperty(key);
		return Value;
		
	}
}
