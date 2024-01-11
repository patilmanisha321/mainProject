package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

import UtilityMethods.SeleniumUtilities;

public class HomePage extends SeleniumUtilities
{
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	@FindBy(linkText="Products")
	private WebElement productsLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	@FindBy(linkText="Sign Out")
	private WebElement  signoutLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory pf=new PageFactory();
		pf.initElements(driver, this);
	}
	public WebElement getContactsLink()
	{
		return contactsLink;
	}
	
	public WebElement getProductlink()
	{
		return productsLink;
	}
	public WebElement getSignOutLink()
	{
		return signoutLink;
	}
	public void clickonContactsLink()
	{
		contactsLink.click();
	}
	public void LogoutOfApp(WebDriver driver) throws Throwable
	{
		MouseOverAction(driver,AdministratorImg);
		Thread.sleep(2000);
		signoutLink.click();
	}	
	
}
