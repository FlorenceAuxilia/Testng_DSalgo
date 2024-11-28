package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjectmodel.DSAlgoGetStartedPom;
import pageobjectmodel.DSAlgoHomePom;
import pageobjectmodel.DSAlgoRegisterPom;
import pageobjectmodel.DSAlgoSignInPom;
import pageobjectmodel.DSAlgoStackPom;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC006_RegisterPageValidation extends BaseClass {

	Actions act;

	@BeforeMethod(groups = { "Register", "DataDriven", "FunctionalTesting" })
	public void before_testcase_setup() {
		getstartedpage_obj = new DSAlgoGetStartedPom(driver.get());
		getstartedpage_obj.clickGetStarted();
		homepage_obj = new DSAlgoHomePom(driver.get());
		homepage_obj.click_Signin();
		signinpage_obj = new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		registerpage_obj = new DSAlgoRegisterPom(driver.get());
		act = new Actions(driver.get());

	}



	@Test(priority = 1 ,groups={"Register","FunctionalTesting"})
		public void registerPageValidation() throws Throwable {
			getDriver().get(p.getProperty("registerUrl"));
			registerpage_obj.enterUsername(p.getProperty("newuser"));
			registerpage_obj.enterPassword(p.getProperty("register_password"));
			registerpage_obj.enterConfirmPassword(p.getProperty("register_confPassword"));
			registerpage_obj.clickRegister();
			//System.out.println(registerpage_obj.getRegisterPageTitle());
			if(registerpage_obj.getPageTitle().equals(p.getProperty("titleRegistration")))
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
			@Test(priority = 2 ,groups={"Register","FunctionalTesting"})
			public void RegisterPage_usernameError() throws Throwable {
				getDriver().get(p.getProperty("registerUrl"));
				registerpage_obj.enterUsername(p.getProperty("newuser"));
				//registerpage_obj.enterPassword(p.getProperty("register_password"));
				//registerpage_obj.enterConfirmPassword(p.getProperty("register_confPassword"));
				registerpage_obj.clickRegister();
		
				if(registerpage_obj.checkErrorpopup().equals(p.getProperty("registerErrorPopup")))
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
		
		@Test(priority = 3 ,groups={"Register","FunctionalTesting"})
		public void RegisterPage_PasswordError() throws Throwable {
			getDriver().get(p.getProperty("registerUrl"));
			registerpage_obj.enterPassword("register_password");
			registerpage_obj.clickRegister();
			if(registerpage_obj.checkErrorpopup().equalsIgnoreCase(p.getProperty("registerErrorPopup")))
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

		
		@Test(priority = 4 ,groups={"Register","FunctionalTesting"})
		public void RegisterPage_ConfirmPasswordError() throws Throwable {
			getDriver().get(p.getProperty("registerUrl"));
			registerpage_obj.enterPassword("confirmPassword");
			registerpage_obj.clickRegister();
			if(registerpage_obj.checkErrorpopup().equalsIgnoreCase(p.getProperty("registerErrorPopup")))
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
		
		@Test(priority=5,dataProvider="RegisterPythoncode",dataProviderClass=DataProviders.class,groups={"Register","FunctionalTesting","DataDriven"})
		public void register_With_Invalid( String username,String password,String confirmPassword)  {
			getDriver().get(p.getProperty("registerUrl"));
			registerpage_obj.enterUsername(username);
			registerpage_obj.enterPassword(password);
			registerpage_obj.enterPassword(confirmPassword);
			registerpage_obj.clickRegister();
			if(registerpage_obj.getPageTitle().equals(p.getProperty("RegistrationPageTitle")))
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
