package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions 
{
	@Test
	public void sample()
	{	String data="abc";
		System.out.println("step1 in hard assert");
		System.out.println("step2 in hard assert");
		
		//Assert.assertEquals(false, true);
		Assert.assertTrue(data.contains("a"));
		
		System.out.println("step3 in hard assert");
		System.out.println("step4 in hard aasert");
		
	}
}
