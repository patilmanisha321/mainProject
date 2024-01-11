package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage
{
	@FindBy(name="user_name")
	private WebElement usrnmedt;
	@FindBy(name="user_password")
	private WebElement pswdedt;
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginbtn;
	public WebElement getUsrnmedt() {
		return usrnmedt;
	}
	
	public WebElement getPswdedt() {
		return pswdedt;
	}
	
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	public LogInPage(WebDriver driver)
	{
		PageFactory o=new PageFactory();
		o.initElements(driver, this);
	}
	public void logInMethod(String usrname, String pswd)
	{
		usrnmedt.sendKeys(usrname);
		pswdedt.sendKeys(pswd);
		loginbtn.click();
	}
		
}
