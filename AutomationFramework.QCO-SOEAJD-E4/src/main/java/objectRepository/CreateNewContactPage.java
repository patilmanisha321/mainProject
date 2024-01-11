package objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityMethods.SeleniumUtilities;
public class CreateNewContactPage extends SeleniumUtilities {
	
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	 public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getlastName() 
	{
		return lastNameEdt;
	}
	public WebElement getsaveBtn() 
	{
		return saveBtn;
	}
	public WebElement getleadSourceDropDown()
	{
		return leadSourceDropDown;
	}
	
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createNewContact(String lastName, String leadSourceValue)
	{
		lastNameEdt.sendKeys(lastName);
		handleDropDown(leadSourceDropDown,leadSourceValue);
		saveBtn.click();
	}
	
	
	
	
	
}
