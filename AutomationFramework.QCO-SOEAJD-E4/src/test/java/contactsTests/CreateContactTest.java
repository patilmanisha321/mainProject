package contactsTests;

import static org.testng.Assert.fail;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import UtilityMethods.BaseClass;
import UtilityMethods.ReadingFromExcel;
import UtilityMethods.ReadingFromPropertyFile;
import UtilityMethods.SeleniumUtilities;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LogInPage;
@Listeners(UtilityMethods.ListenersImplimintation.class)
public class CreateContactTest extends BaseClass{
	
   @Test//(groups="smoke suite")
	public  void CreateAContact() throws Throwable
	{ 
	   String LASTNAME=eUtil.UtilityMethod("Sheet1", 1, 5);
	
		
		HomePage hp=new HomePage(driver);
		hp.clickonContactsLink();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
		
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String ConHeader =cip.captureHeaderText();
		
		Assert.assertTrue(ConHeader.contains(LASTNAME));
		
			System.out.println("pass");
			System.out.println(ConHeader);	
		
	}
  /* @Test
   public void demoTest()
   {
	  Assert.fail(); 
	  System.out.println("hi");
   }*/

}

