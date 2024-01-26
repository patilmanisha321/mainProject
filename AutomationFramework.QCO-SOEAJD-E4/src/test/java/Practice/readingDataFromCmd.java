package Practice;

import org.testng.annotations.Test;

public class readingDataFromCmd 
{
	@Test
	public void read()
	{
		String UN=System.getProperty("username");
		System.out.println(UN);
		
		String PWD=System.getProperty("password");
		System.out.println(PWD);
	
	}
}
