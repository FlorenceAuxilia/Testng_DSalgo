package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DSAlgoGetStartedPom extends Baseclasspage{
	public DSAlgoGetStartedPom(WebDriver driver) {
		super(driver);
		
	}


	@FindBy(xpath="//a[@href='/home']/button[text()='Get Started']")
	WebElement main_button;
	
	@FindBy(xpath="//*[text()='You are at the right place']")
	WebElement main_msg;
	
	@FindBy(xpath="//*[text()='Preparing for the Interviews']")
	WebElement main_title;
	

	public void clickGetStarted() {
		main_button.click();
	}
}
