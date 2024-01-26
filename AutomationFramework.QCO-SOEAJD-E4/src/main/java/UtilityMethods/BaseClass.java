package UtilityMethods;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LogInPage;

public class BaseClass
{
    public ReadingFromExcel eUtil=new ReadingFromExcel();
	ReadingFromPropertyFile pUtil=new ReadingFromPropertyFile();
	SeleniumUtilities Sutil=new SeleniumUtilities();
	JavaUtility Jutil=new JavaUtility();
	
	public WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun=true)
	public void BSconfig()
	{
		System.out.println("=========DB connection successful=======");
	}
	//@Parameters("browser")
	//@BeforeTest
	
	@BeforeClass(alwaysRun=true)
	public void BCconfig(/*String browser*/) throws IOException
	{
		
		String URL = pUtil.utilityPro("url");
		//driver=new EdgeDriver();
		driver=new ChromeDriver();
		/*if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}*/
		
	    Sutil.MaximizeWindow(driver);
		Sutil.ImplicitWait(driver);
		driver.get(URL);
		System.out.println("======Browser launched successfully======");
		sDriver=driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void BMconfig() throws IOException
	{
		String USERNAME=pUtil.utilityPro("username");
		String PASSWORD=pUtil.utilityPro("password");
		LogInPage lp=new LogInPage(driver);
		lp.logInMethod(USERNAME, PASSWORD);
		System.out.println("=======Login Successful=====");
		
	}

	@AfterMethod(alwaysRun=true)
	public void AMconfig() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.LogoutOfApp(driver);

        System.out.println("=====Logout successful=====");
	}
	
	 //@AfterTest
	@AfterClass(alwaysRun=true)
	public void ACconfig()
	{
		driver.quit();
		System.out.println("======Browser closed=========");
	}
	
	@AfterSuite(alwaysRun=true)
	public void ASconfig()
	{
		System.out.println("======DB connection closed====");
	}
	
}
