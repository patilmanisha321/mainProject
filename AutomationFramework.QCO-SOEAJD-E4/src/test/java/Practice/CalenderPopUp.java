package Practice;
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.interactions.Actions;
	import io.github.bonigarcia.wdm.WebDriverManager;


public class CalenderPopUp 
	{

public void dateChoosing() throws Throwable
		{
			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.makemytrip.com/");
			driver.manage().window().maximize();
		    //driver.findElement(By.xpath("//a[@class='close']")).click();
			//driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		    Actions act=new Actions(driver);
			act.moveByOffset(20,30).click().perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Departure']")).click();
			driver.findElement(By.xpath("//div[text()='November 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='19']")).click();			 
		}
	}


