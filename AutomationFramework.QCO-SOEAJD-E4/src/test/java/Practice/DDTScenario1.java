package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import objectRepository.LogInPage;

public class DDTScenario1 {

	public static void main(String[] args) throws Throwable, IOException
	{
		FileInputStream  fis=new FileInputStream("C:\\JAVA CLASS\\TestDataReading.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		
		FileInputStream fisE=new FileInputStream("C:\\Users\\sandip\\Desktop\\TestData.xlsx");
		 Workbook book=WorkbookFactory.create(fisE);
		    Sheet sheet=book.getSheet("Sheet1");
		    Row row=sheet.getRow(1);
		    Cell cel=row.getCell(5);
		    String lastname=cel.getStringCellValue();
		    System.out.println(lastname);
		
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.manage().window().maximize();
		
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		LogInPage lp = new LogInPage(driver);
		lp.logInMethod(USERNAME,PASSWORD);
		
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	    driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String LastName = driver.findElement(By.className("dvHeaderText")).getText();
	if(LastName.contains(lastname))
	{
		System.out.println(LastName);
		System.out.println("Pass");
	}
	else
		System.out.println("Fail");
	
	/*WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.quit();*/
	
	

	}

}
