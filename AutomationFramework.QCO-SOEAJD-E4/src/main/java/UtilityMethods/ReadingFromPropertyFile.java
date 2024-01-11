package UtilityMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is to read data from property file
 * @author Manisha
 *
 */
public class ReadingFromPropertyFile {
	
	/**
	 * This methos is used to get the value of a key from properties class
	 * @param key
	 * @return value
	 * @throws IOException 
	 */
	public String utilityPro(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\JAVA CLASS\\TestDataReading.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}

}
