package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import pageobjectmodel.DSAlgoGetStartedPom;
import pageobjectmodel.DSAlgoHomePom;
import pageobjectmodel.DSAlgoLoginPom;
import pageobjectmodel.DSAlgoQueuePom;
import pageobjectmodel.DSAlgoSignInPom;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC008_LoginValidation extends BaseClass{
	
	@BeforeMethod
	public void before_testcase_setup() {
		    getstartedpage_obj=new DSAlgoGetStartedPom(driver.get());
		    getstartedpage_obj.clickGetStarted();
		    homepage_obj=new DSAlgoHomePom(driver.get());
		    homepage_obj.click_Signin();   
		    signinpage_obj=new DSAlgoSignInPom(driver.get());
		    loginpage_obj =new DSAlgoLoginPom(driver.get());
	}
	
	@Test
	public void passwordError() throws Throwable {
	//	getDriver().get(p.getProperty("loginUrl"));
		loginpage_obj.enterUsername(p.getProperty("username"));
		loginpage_obj.Clciklogin();
		
		if(loginpage_obj.checkForErrorpopup().equalsIgnoreCase(p.getProperty("LoginErrorPopup")))
		 {
			 logger.info("Test passed");
		    	Assert.assertTrue(true);
		 }
		 else
		 {
			 logger.error("Test failed..");
			logger.debug("Debug logs...");
			 Assert.assertTrue(false);
		 }
		
	}
	
	
	@Test
	public void usernameError() throws Throwable {
		getDriver().get(p.getProperty("loginUrl"));
		loginpage_obj.enterPassword("username");
		loginpage_obj.Clciklogin();
		if(loginpage_obj.checkForErrorpopup().equalsIgnoreCase(p.getProperty("LoginErrorPopup")))
		 {
			 logger.info("Test passed");
		    	Assert.assertTrue(true);
		 }
		 else
		 {
			 logger.error("Test failed..");
			logger.debug("Debug logs...");
			 Assert.assertTrue(false);
		 }
		
	}
	
	@Test
	public void Registrationpage()
	{
		getDriver().get(p.getProperty("loginUrl"));
		loginpage_obj.clickRegister();
		if(loginpage_obj.getPageTitle().equals(p.getProperty("RegistrationPageTitle")))
		 {
			 logger.info("Test passed");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 logger.error("Test failed..");
			 logger.debug("Debug logs...");
			 Assert.assertTrue(false);
		 }
		}
	
	@Test(priority=5,dataProvider="loginCredentials",dataProviderClass=DataProviders.class,groups={"DataDriven"})
	public void runLogininvalid( String username,String password,String empty)  {
		getDriver().get(p.getProperty("loginUrl"));
		loginpage_obj.enterUsername(username);
		loginpage_obj.enterPassword(password);
		loginpage_obj.Clciklogin();
		if(loginpage_obj.getPageTitle().equals(p.getProperty("LoginPageTitle")))
		 {
			 logger.info("Test passed");
		    	Assert.assertTrue(true);
		 }
		 else
		 {
			 logger.error("Test failed..");
			logger.debug("Debug logs...");
			 Assert.assertTrue(false);
		 }

	}
	
	@Test
	public void runLogin() throws Throwable {
		getDriver().get(p.getProperty("loginUrl"));
		loginpage_obj.enterUsername(p.getProperty("username"));
		loginpage_obj.enterPassword(p.getProperty("password"));
		loginpage_obj.Clciklogin();
		System.out.println(loginpage_obj.getPageTitle());
		if(loginpage_obj.getPageTitle().equals(p.getProperty("GettingStartedPageTitle")))
		 {
			 logger.info("Test passed");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			logger.error("Test failed..");
			logger.debug("Debug logs...");
			 Assert.assertTrue(false);
		 }

	}
	

}
