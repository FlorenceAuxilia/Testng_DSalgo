package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class DSAlgoLoginPom extends Baseclasspage{
	
//static WebDriver driver;

public DSAlgoLoginPom(WebDriver driver){
	super(driver);
}
	
	By username=By.id("id_username");
	By password=By.id("id_password");
	By loginButton =By.xpath("//input[@value='Login']");
	By registerButton =By.xpath("//a[text()='Register!']");
	String actualTitle;
	
	@FindBy(xpath="//input[@id='id_username']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@id='id_password']")
	WebElement txt_password;
		
	@FindBy (xpath ="//div[@role='alert']")
	WebElement alert_Error;
	
	
//	public DSAlgoLoginPom(WebDriver driver){
//		//this.driver=driver;
//		super(driver);
//		}
	
	
	
	public void enterUsername(String uname) {
		
		driver.findElement(username).sendKeys(uname);
	
	}
	
	
	public void enterPassword(String pasword) {
		driver.findElement(password).sendKeys(pasword);
		
		}
	public void Clciklogin() {
		driver.findElement(loginButton).click();
		
		}
	
	
	public void loginValidUser(String uname ,String passwd)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(passwd);
		driver.findElement(loginButton).click();
	}



	public void verifyPage(String title) {
		// TODO Auto-generated method stub
		actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, title);
		
	}

	public String getPageTitle() {
		// TODO Auto-generated method stub
		return (driver.getTitle());
		
		
	}

	public void clickRegister() {
		// TODO Auto-generated method stub
		driver.findElement(registerButton).click();
	}
	
	public boolean checkForErrorMessage()
	{
		return (driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	}
	

	public String checkForErrorpopup()
	{
		
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		System.out.println("Actual message appeared on screen: " + messageStr);
		return messageStr;
	}
	

	

	

}
