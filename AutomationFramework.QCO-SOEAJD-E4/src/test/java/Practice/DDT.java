package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DDT {

	public static void main(String[] args) throws IOException 
	{
		
		FileInputStream  fis=new FileInputStream("C:\\JAVA CLASS\\TestDataReading.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty("url");
		System.out.println(value);
		
	}

}