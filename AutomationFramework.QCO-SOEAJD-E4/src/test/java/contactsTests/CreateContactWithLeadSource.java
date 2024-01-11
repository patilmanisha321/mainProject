package contactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
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

public class CreateContactWithLeadSource extends BaseClass
{
	@Test//(groups="regression suite")
	public void CreateAContactWithLead() throws Throwable
	{
		String LASTNAME=eUtil.UtilityMethod("Sheet1", 1, 5);
		String LEADSOURCE=eUtil.UtilityMethod("Sheet1", 1, 6);
	
		HomePage hp=new HomePage(driver);
		hp.clickonContactsLink();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
		
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, LEADSOURCE);
		
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String ConHeader =cip.captureHeaderText();
		
		Assert.assertTrue(ConHeader.contains(LASTNAME));

		System.out.println("pass");
		System.out.println(ConHeader);
		
	}
}


