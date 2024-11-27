package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjectmodel.DSAlgoGetStartedPom;
import pageobjectmodel.DSAlgoHomePom;
import pageobjectmodel.DSAlgoQueuePom;
import pageobjectmodel.DSAlgoSignInPom;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC009_QueuePageValidation extends BaseClass{
	
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
	    queuepage_obj=new DSAlgoQueuePom(driver.get());
	    act=new Actions(driver.get());

}



@Test(priority=1,groups={"Queue","FunctionalTesting"})
public void verify_Queue_Getstartedbtn_PageValidation()
{
	logger.info("TC009_QueuePageValidation");
	logger.info("Queue option Validation using Queue get started button");
	homepage_obj.click_select_Queue();
	if(queuepage_obj.getPageTitle().equals(p.getProperty("QueuePageTitle")))
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

@Test(priority=2,groups={"Queue","FunctionalTesting"})
public void verify_QueueOption_Dropdown_PageValidation()
{
	 logger.info("queue option Validation using Queue dropdown option");
	 homepage_obj.click_select_Queue_options();
	 if(queuepage_obj.getPageTitle().equals(p.getProperty("QueuePageTitle")))
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


@Test(dataProvider="Queuetypes",dataProviderClass=DataProviders.class, priority = 3,groups={"Queue","FunctionalTesting"})
public void verify_Queue_Operations_Link(String type)
{
	
	 logger.info("verification of" + type);
	 homepage_obj.click_select_Queue();
	 queuepage_obj.ClickQueueLink(type);
	 Assert.assertEquals(queuepage_obj.getPageTitle(),type);
}




@Test(dataProvider = "Queuetypes",dataProviderClass=DataProviders.class,priority=4,groups={"Queue","FunctionalTesting"})
public void verify_Queue_tryherebtn(String type)
{
	 logger.info("Verification of  try here button in " + type);
	 homepage_obj.click_select_Queue();
	 queuepage_obj.ClickQueueLink(type);;
	 queuepage_obj.click_tryHere();
	 Assert.assertEquals(queuepage_obj.runButtonText(),"Run"); 
}





@Test(priority=5,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"Queue","FunctionalTesting","DataDriven"})//getting data provider from different class different package
public void verify_Queue_pythoncode(String code,String Result)
{
	try
	{
	String[] link = { "Implementation of Queue in Python", "Implementation using collections.deque",
			"Implementation using array", "Queue Operations" };
	 homepage_obj.click_select_Queue();
	 for (int i =0;i<4;i++)
	 {
	
		driver.get().get("https://dsportalapp.herokuapp.com/queue/");
	 queuepage_obj.ClickQueueLink(link[i]);
	 
	 queuepage_obj.click_tryHere();
	 act.sendKeys(code).build().perform();
	 queuepage_obj.click_run(); 
	 act.sendKeys(code).build().perform();
	 queuepage_obj.click_run();
     if(queuepage_obj.text_output()!=null && queuepage_obj.text_output().equals(Result))
	{
		Assert.assertTrue(true);
	}
     else
     {
   driver.get().switchTo().alert().accept();
	 
     }
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

@Test(priority=6,groups={"Queue","FunctionalTesting"})
public void verify_practiceQuestions_Link()
{
	 logger.info("Practice Questions link validation");
	 homepage_obj.click_select_Queue();
	 queuepage_obj.ClickQueueLink("Implementation of Queue in Python");
	 queuepage_obj.ClickQueueLink("Practice Questions");
	 Assert.assertTrue(false);
}

}
