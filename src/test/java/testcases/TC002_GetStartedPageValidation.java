package testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageobjectmodel.DSAlgoGetStartedPom;
import testbase.BaseClass;

public class TC002_GetStartedPageValidation extends BaseClass {
Actions act; 
	
	@BeforeMethod
	public void before_testcase_setup() {
		    getstartedpage_obj=new DSAlgoGetStartedPom(driver.get());
	}
	
	@Description("Test Successful GetStarted page Launch")
	@Test(priority=1)
	public void verify_Getstarted_PageValidation()
	{
		
		logger.info("TC002_GetStarted_PageValidation");
		logger.info("Test Successful GetStarted page Launch ");
		 if(driver.get().getTitle().equals(p.getProperty("Get_Started_title")))
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
	
	@Description("Testing Successful Home page launch")
	 @Test(priority=2)
		public void verify_Getstarted_button()
		{
			
			logger.info(" Testing Successful Home page launch");
			getstartedpage_obj.clickGetStarted();
			if((driver.get().getPageSource().contains(p.getProperty("Get_Started_register_lnk"))||(driver.get().getPageSource().contains(p.getProperty("Get_Started_signin_lnk")))))
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
