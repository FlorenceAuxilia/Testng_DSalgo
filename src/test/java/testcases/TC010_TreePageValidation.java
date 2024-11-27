package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjectmodel.DSAlgoGetStartedPom;
import pageobjectmodel.DSAlgoHomePom;
import pageobjectmodel.DSAlgoQueuePom;
import pageobjectmodel.DSAlgoSignInPom;
import pageobjectmodel.DSAlgoTreePom;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC010_TreePageValidation extends BaseClass{
	
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
		    treepage_obj=new DSAlgoTreePom(driver.get());
		    act=new Actions(driver.get());
		
	}

	@Test(priority=1,groups={"Tree","FunctionalTesting"})
	public void verify_Tree_Getstartedbtn_PageValidation()
	{
		logger.info("TC010_TreePageValidation");
		logger.info("Tree option Validation using Tree get started button");
		homepage_obj.click_select_Tree();
		if(treepage_obj.getPageTitle().equals(p.getProperty("TreePageTitle")))
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
	@Test(priority=2,groups={"Tree","FunctionalTesting"})
	public void verify_TreeOption_Dropdown_PageValidation()
	{
		 logger.info("Tree option Validation using Tree dropdown option");
		 homepage_obj.click_select_Tree_options();
		 if(treepage_obj.getPageTitle().equals(p.getProperty("TreePageTitle")))
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


	@Test(dataProvider="Treetypes",dataProviderClass=DataProviders.class, priority = 3,groups={"Tree","FunctionalTesting","Data Driven"})
	public void verify_Tree_Operations_Link(String type)
	{
		
		 logger.info("verification of" + type);
		 homepage_obj.click_select_Tree();
		 treepage_obj.ClickLink(type);
		 Assert.assertEquals(treepage_obj.getPageTitle(),type);
	}




	@Test(dataProvider = "Treetypes",dataProviderClass=DataProviders.class,priority=4,groups={"Tree","FunctionalTesting","Data Driven"})
	public void verify_Tree_Tryherebtn(String type)
	{
		 logger.info("Verification of  try here button in " + type);
		 homepage_obj.click_select_Tree();
		 treepage_obj.ClickLink(type);;
		 treepage_obj.click_tryHere();
		 Assert.assertEquals(treepage_obj.runButtonText(),"Run"); 
	}





	@Test(priority=5,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"Tree","FunctionalTesting","Data Driven"})//getting data provider from different class different package
	public void verify_Tree_pythoncode(String code,String Result)
	{
		try
		{
		String[] link = { 	"Overview of Trees","Terminologies","Types of Trees","Tree Traversals",
						"Traversals-Illustration","Binary Trees","Types of Binary Trees",
						"Implementation in Python" ,"Binary Tree Traversals","Implementation of Binary Trees",
						"Applications of Binary trees","Binary Search Trees","Implementation Of BST"};
		 homepage_obj.click_select_Tree();
		 for (int i =0;i<13;i++)
		 {
		
			driver.get().get("https://dsportalapp.herokuapp.com/tree/");
		 treepage_obj.ClickLink(link[i]);
		 
		 treepage_obj.click_tryHere();
		 act.sendKeys(code).build().perform();
		 treepage_obj.click_run(); 
		 act.sendKeys(code).build().perform();
		 treepage_obj.click_run();
	     if(treepage_obj.text_output()!=null && treepage_obj.text_output().equals(Result))
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

	@Test(priority=6,groups={"Tree","FunctionalTesting"})
	public void verify_practiceQuestions_Link()
	{
		 logger.info("Practice Questions link validation");
		 homepage_obj.click_select_Tree();
		 treepage_obj.ClickLink("Overview of Trees");
		 treepage_obj.ClickLink("Practice Questions");
		 Assert.assertTrue(false);
	}



	
	


}
