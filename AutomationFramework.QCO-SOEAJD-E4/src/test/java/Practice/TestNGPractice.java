package Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice 
{
	@Test(priority=0)
	public void createCustoer()
	{
		//Assert.fail();
		System.out.println("Customer created successfully");
		
	}
	@Test( enabled=true, dependsOnMethods = "createCustoer")
	public void modifyCustomer()
	{
		System.out.println("Customer modified successfully");
	}
	@Test(priority=-1, invocationCount=1)  //invocationCount=0 makes execution disable
	public void deleteCustomer()
	{
		System.out.println("Customer deleted successfully");
	}
}
