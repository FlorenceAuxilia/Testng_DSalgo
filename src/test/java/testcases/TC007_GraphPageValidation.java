package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjectmodel.DSAlgoGetStartedPom;
import pageobjectmodel.DSAlgoGraphPom;
import pageobjectmodel.DSAlgoHomePom;
import pageobjectmodel.DSAlgoSignInPom;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC007_GraphPageValidation extends BaseClass{
	
	Actions act; 
	

@BeforeMethod (groups={"Graph","FunctionalTesting"})
public void before_testcase_setup() {
	    getstartedpage_obj=new DSAlgoGetStartedPom(driver.get());
	    getstartedpage_obj.clickGetStarted();
	    homepage_obj=new DSAlgoHomePom(driver.get());
	    homepage_obj.click_Signin();   
	    signinpage_obj=new DSAlgoSignInPom(driver.get());
	    signinpage_obj.setUserName(p.getProperty("username"));
	    signinpage_obj.setPassword(p.getProperty("password"));
	    signinpage_obj.clickLogin();
	    graphpage_obj=new DSAlgoGraphPom(driver.get());
	    act=new Actions(driver.get());

}



@Test(priority=1,groups={"Graph","FunctionalTesting"})
public void verify_Graph_Getstartedbtn_PageValidation()
{
	logger.info("TC009_GraphPageValidation");
	logger.info("Graph option Validation using Graph get started button");
	homepage_obj.click_select_Graph();
	if(graphpage_obj.getPageTitle().equals(p.getProperty("GraphPageTitle")))
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

@Test(priority=2,groups={"Graph","FunctionalTesting"})
public void verify_GraphOption_Dropdown_PageValidation()
{
	 logger.info("Graph option Validation using Graph dropdown option");
	 homepage_obj.click_select_Graph_options();
	 if(graphpage_obj.getPageTitle().equals(p.getProperty("GraphPageTitle")))
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


@Test(dataProvider="Graphtypes",dataProviderClass=DataProviders.class, priority = 3,groups={"Graph","FunctionalTesting"})
public void verify__Operations_Link(String type)
{
	
	 logger.info("verification of" + type);
	 homepage_obj.click_select_Graph();
	 graphpage_obj.ClickGraphLink(type);
	 Assert.assertEquals(graphpage_obj.getPageTitle(),type);
}




@Test(dataProvider = "types",dataProviderClass=DataProviders.class,priority=4,groups={"Graph","FunctionalTesting"})
public void verify__tryherebtn(String type)
{
	 logger.info("Verification of  try here button in " + type);
	 homepage_obj.click_select_Graph();
	 graphpage_obj.ClickGraphLink(type);;
	 graphpage_obj.click_tryHere();
	 Assert.assertEquals(graphpage_obj.runButtonText(),"Run"); 
}





@Test(priority=5,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"Graph","FunctionalTesting","DataDriven"})//getting data provider from different class different package
public void verify_Graph_pythoncode(String code,String Result)
{
	try
	{
	String[] link = {  "Graph","Graph Representations"  };
	 homepage_obj.click_select_Graph();
	 for (int i =0;i<2;i++)
	 {
	
		driver.get().get("https://dsportalapp.herokuapp.com/graph/");
		graphpage_obj.ClickGraphLink(link[i]);
	 
		graphpage_obj.click_tryHere();
	 act.sendKeys(code).build().perform();
	 graphpage_obj.click_run(); 
	 act.sendKeys(code).build().perform();
	 graphpage_obj.click_run();
     if(graphpage_obj.text_output()!=null && graphpage_obj.text_output().equals(Result))
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

@Test(priority=6,groups={"Graph","FunctionalTesting"})
public void verify_practiceQuestions_Link()
{
	 logger.info("Practice Questions link validation");
	 homepage_obj.click_select_Graph();
	 graphpage_obj.ClickGraphLink("Graph");
	 graphpage_obj.ClickGraphLink("Practice Questions");
	 Assert.assertTrue(false);
}
}
