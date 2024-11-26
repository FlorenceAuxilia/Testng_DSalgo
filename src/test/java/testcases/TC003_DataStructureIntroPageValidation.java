package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjectmodel.DSAlgoDataStructure_IntroductionPom;
import pageobjectmodel.DSAlgoGetStartedPom;
import pageobjectmodel.DSAlgoHomePom;
import pageobjectmodel.DSAlgoSignInPom;
import pageobjectmodel.DSAlgoStackPom;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_DataStructureIntroPageValidation  extends BaseClass{
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
		    datastructurepage_obj=new DSAlgoDataStructure_IntroductionPom(driver.get());
		    act=new Actions(driver.get());
		
	}
	@Test(priority=1)
	public void verify_DataStructure__PageValidation()
	{
		
		logger.info("TC003_DataStructure_PageValidation");
		logger.info("DataStructure option Validation using stack get started button");
		homepage_obj.click_data_structures_introduction();
		 if(driver.get().getTitle().equals(p.getProperty("titledatastructure")))
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
	public void verify_DataStructure_TimeComplexity_Link()
	{
		
		 logger.info("Verification of Time Complexity in stack link");
		 homepage_obj.click_data_structures_introduction();
		 datastructurepage_obj.click_time_complexity();
		 Assert.assertEquals(driver.get().getTitle(),p.getProperty("datastructure_link1"));
		
		
	}
	@Test(priority=4)
	public void verify_DataStructure_TimeComplexity_tryherebtn_Link()
	{
		 logger.info("Verification of  try here button under timeComplexity in DataStructure link");
		 homepage_obj.click_data_structures_introduction();
		 datastructurepage_obj.click_time_complexity();
		 datastructurepage_obj.tc_click_tryhere();
		 Assert.assertEquals(datastructurepage_obj.time_complexity_click_run(),"Run"); 
	}
	
	@Test(priority=5,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"DataDriven"})//getting data provider from different class different package
	public void verify_DataStructure_TimeComplexity_pythoncode(String code,String Result)
	{
		try
		{
		homepage_obj.click_data_structures_introduction();
		datastructurepage_obj.click_time_complexity();
		datastructurepage_obj.tc_click_tryhere();
		 act.sendKeys(code).build().perform();
		 stakpage_obj.click_run(); 
		 act.sendKeys(code).build().perform();
		 stakpage_obj.click_run();
	     if(datastructurepage_obj.tc_text_output()!=null && datastructurepage_obj.tc_text_output().equals(Result))
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
}
