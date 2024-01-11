package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion 
{
	@Test
	public void softAssert()
	{
		String data="abc";
		System.out.println("Strep1 in soft assert");
		System.out.println("Strep2 in soft assert");
		
		SoftAssert sa=new SoftAssert();
		//sa.assertEquals(0,1);
		//sa.assertTrue(data.contains("y"));
		
		System.out.println("Strep3 in soft assert");
		System.out.println("Strep4 in soft assert");
		
		sa.assertAll();
	}

}
