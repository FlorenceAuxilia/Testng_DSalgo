package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import utilities.DataProviders;

import pageobjectmodel.*;
import testbase.BaseClass;


public class TC001_StackPageValidation extends BaseClass{

	Actions act; 
	
	@BeforeMethod
	public void before_testcase_setup() {
		    getstartedpage_obj=new DSAlgoGetStartedPom(driver.get());
		    getstartedpage_obj.clickGetStarted();
		    homepage_obj=new DSAlgoHomePom(driver.get());
		    homepage_obj.click_Signin();   
		    signinpage_obj=new DSAlgoSignInPom(driver.get());
		    signinpage_obj.setUserName(p.getProperty("username"));
		    signinpage_obj.setPassword(p.getProperty("password"));
		    signinpage_obj.clickLogin();
		    stakpage_obj=new DSAlgoStackPom(driver.get());
		    act=new Actions(driver.get());
		
	}
	
	@Test(priority=1)
	public void verify_Stack_Getstartedbtn_PageValidation()
	{
		
		logger.info("TC001_StackPageValidation");
		logger.info("Stack option Validation using stack get started button");
		homepage_obj.click_select_stack();
		 if(stakpage_obj.gettile_page().equals(p.getProperty("titlestack")))
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
	
	@Test(priority=2)
	public void verify_StackOption_Dropdown_PageValidation()
	{
		 logger.info("Stack option Validation using stack dropdown option");
		 homepage_obj.click_select_stack_options();
		 if(stakpage_obj.gettile_page().equals(p.getProperty("titlestack")))
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
	
	@Test(priority=3)
	public void verify_Stack_Operations_Link()
	{
		
		 logger.info("Verification of Operations in stack link");
		 homepage_obj.click_select_stack();
		 stakpage_obj.click_Operations_in_stack();
		 Assert.assertEquals(stakpage_obj.getOperations_in_stack_title(),p.getProperty("stack_link1"));
		
		
	}
	@Test(priority=4)
	public void verify_Stack_Operations_tryherebtn_Link()
	{
		 logger.info("Verification of  try here button under Operations in stack link");
		 homepage_obj.click_select_stack();
		 stakpage_obj.click_Operations_in_stack();
		 stakpage_obj.click_tryhere();
		 Assert.assertEquals(stakpage_obj.click_run(),"Run"); 
	}
	
	@Test(priority=5,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"DataDriven"})//getting data provider from different class different package
	public void verify_Stack_Operations_pythoncode(String code,String Result)
	{
		try
		{
		 homepage_obj.click_select_stack();
		 stakpage_obj.click_Operations_in_stack();
		 stakpage_obj.click_tryhere();
		 act.sendKeys(code).build().perform();
		 stakpage_obj.click_run(); 
		 act.sendKeys(code).build().perform();
		 stakpage_obj.click_run();
	     if(stakpage_obj.text_output()!=null && stakpage_obj.text_output().equals(Result))
		{
			Assert.assertTrue(true);
		}
	     else
	     {
	   driver.get().switchTo().alert().accept();
		 
	     }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	    }
	
	@Test(priority=6)
	public void verify_Stack_Implementation_Link()
	{
		
		 logger.info("Verification of Implementation in stack link");
		 homepage_obj.click_select_stack();
		 stakpage_obj.click_implementation();
		 Assert.assertEquals(stakpage_obj.get_implementation_title(),p.getProperty("stack_link2"));	
	}
	@Test(priority=7)
	public void verify_Stack_Implementation_tryherebtn_Link()
	{
		 logger.info("Verification of try here button under Implementation in stack link");
		 homepage_obj.click_select_stack();
		 stakpage_obj.click_implementation();
		 stakpage_obj.click_tryhere();
		 Assert.assertEquals(stakpage_obj.click_run(),"Run"); 
	}
	
	@Test(priority=8,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"DataDriven"})//getting data provider from different class different package
	public void verify_Stack_Implementation_pythoncode(String code,String Result)
	{
		try
		{
		 homepage_obj.click_select_stack();
		 stakpage_obj.click_implementation();
		 stakpage_obj.click_tryhere();
		 act.sendKeys(code).build().perform();
		 stakpage_obj.click_run(); 
		 act.sendKeys(code).build().perform();
		 stakpage_obj.click_run();
	     if(stakpage_obj.text_output()!=null && stakpage_obj.text_output().equals(Result))
		{
			Assert.assertTrue(true);
		}
	     else
	     {
	   driver.get().switchTo().alert().accept();
		 
	     }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	    }
	
	@Test(priority=9)
	public void verify_Stack_Applications_Link()
	{
		
		 logger.info("Verification of Applications in stack link");
		 homepage_obj.click_select_stack();
		 stakpage_obj.click_applications();
		 Assert.assertEquals(stakpage_obj.get_applications_title(),p.getProperty("stack_link3"));	
	}
	@Test(priority=10)
	public void verify_Stack_Applications_tryherebtn_Link()
	{
		 logger.info("Verification of try here button under Applications in stack link");
		 homepage_obj.click_select_stack();
		 stakpage_obj.click_applications();
		 stakpage_obj.click_tryhere();
		 Assert.assertEquals(stakpage_obj.click_run(),"Run"); 
	}
	
	@Test(priority=11,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"DataDriven"})//getting data provider from different class different package
	public void verify_Stack_Applications_pythoncode(String code,String Result)
	{
		try
		{
		 homepage_obj.click_select_stack();
		 stakpage_obj.click_applications();
		 stakpage_obj.click_tryhere();
		 act.sendKeys(code).build().perform();
		 stakpage_obj.click_run(); 
		 act.sendKeys(code).build().perform();
		 stakpage_obj.click_run();
	     if(stakpage_obj.text_output()!=null && stakpage_obj.text_output().equals(Result))
		{
			Assert.assertTrue(true);
		}
	     else
	     {
	   driver.get().switchTo().alert().accept();
		 
	     }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	    }
	
	@Test(priority=12)
	public void verify_practiceQuestions_Link()
	{
		 logger.info("Practice Questions link validation");
		 homepage_obj.click_select_stack();
		 stakpage_obj.click_applications();
		 stakpage_obj.click_Practice_Questions();
		 Assert.fail(); 
	}
	
	
	@AfterTest()
	public void after_test()
	{
		logger.info("End of TC001_StackPageValidation");
	}

}
