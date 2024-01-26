package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	@Test(retryAnalyzer=UtilityMethods.RetryAnalyzerImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println();
	}

}
