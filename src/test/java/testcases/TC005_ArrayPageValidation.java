package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjectmodel.DSAlgoArrayPom;
import pageobjectmodel.DSAlgoGetStartedPom;
import pageobjectmodel.DSAlgoHomePom;
import pageobjectmodel.DSAlgoSignInPom;
import pageobjectmodel.DSAlgoStackPom;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC005_ArrayPageValidation extends BaseClass {

	Actions act;

	@BeforeMethod(groups={"Array","DataDriven","FunctionalTesting"})
	public void before_testcase_setup() {
		getstartedpage_obj = new DSAlgoGetStartedPom(driver.get());
		getstartedpage_obj.clickGetStarted();
		homepage_obj = new DSAlgoHomePom(driver.get());
		homepage_obj.click_Signin();
		signinpage_obj = new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		arraypage_obj = new DSAlgoArrayPom(driver.get());
		act = new Actions(driver.get());

	}

	@Test(priority=1,groups={"Array","FunctionalTesting"})
	public void verify_Array_Getstartedbtn_PageValidation()
	{
		
		logger.info("TC007_ArrayPageValidation");
		logger.info("Array option Validation using Array get started button");
		homepage_obj.click_select_Arrays();
		//homepage_obj.click_select_Arrays_options();
		Assert.assertEquals(arraypage_obj.gettitle_page(),p.getProperty("titleArray").trim());

	/*
	 * if(arraypage_obj.gettitle_page().equalsIgnoreCase(p.getProperty(
	 * "titleArray").trim())) {
	 * 
	 * logger.info("Test passed"); Assert.assertTrue(true); } else {
	 * 
	 * logger.error("Test failed.."); logger.debug("Debug logs...");
	 * Assert.assertTrue(false); }
	 */

		
	}

	@Test(priority=2,groups={"Array","FunctionalTesting"})
	public void verify_ArrayOption_Dropdown_PageValidation()
	{
		 logger.info("Array option Validation using Array dropdown option");
		 homepage_obj.click_select_Arrays_options();
		 if(arraypage_obj.gettitle_page().equals(p.getProperty("titleArray")))
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

	
	@Test(priority=3,groups={"Array","FunctionalTesting"})
	public void verify_Array_In_Python_Link()
	{
		 logger.info("Verification of Arrays In Python link");
		 homepage_obj.click_select_Arrays_options();
		 arraypage_obj.clickArraysInPython();
		 Assert.assertEquals(arraypage_obj.get_ArraysInPython_title(),p.getProperty("TitleOfArrayInPaython"));	
	}
	
	@Test(priority=4,groups={"Array","FunctionalTesting"})
	public void verify_Array_In_Python_tryherebtn()
	{
		 logger.info("Verification of try here button under Arrays In Python link");
		 homepage_obj.click_select_Arrays();
		 arraypage_obj.clickArraysInPython();
		 arraypage_obj.click_tryhere();
		 Assert.assertEquals(arraypage_obj.click_run(),"Run"); 
	}

	
	@Test(priority=5,groups={"Array","FunctionalTesting"})
	public void verify_Arrays_Using_List_Link()
	{
		 logger.info("Verification of Arrays Using List link");
		 homepage_obj.click_select_Arrays();
		 arraypage_obj.clickArraysUsingList();
		 Assert.assertEquals(arraypage_obj.get_Arrays_Using_List_title(),p.getProperty("TitleOfArraysUsingList"));	
	}

	@Test(priority=6,groups={"Array","FunctionalTesting"})
	public void verify_Arrays_Using_List_tryherebtn()
	{
		 logger.info("Verification of try here button under Arrays Using List link");
		 homepage_obj.click_select_Arrays();
		 arraypage_obj.clickArraysUsingList();
		 arraypage_obj.click_tryhere();
		 Assert.assertEquals(arraypage_obj.click_run(),"Run"); 
	}
		
	
	@Test(priority=7,groups={"Array","FunctionalTesting"})
	public void verify_Array_Basic_Operations_in_Lists_Link()
	{
		 logger.info("Verification of Basic Operations in Lists link");
		 homepage_obj.click_select_Arrays();
		 arraypage_obj.clickBasicOperationsInLists();
		 Assert.assertEquals(arraypage_obj.get_Basic_Operations_In_Lists_title(),p.getProperty("TitleBasicOperationsInLists"));	
	}

	@Test(priority=8,groups={"Array","FunctionalTesting"})
	public void verify_Basic_Operations_in_Lists_tryherebtn()
	{
		 logger.info("Verification of try here button under Basic Operations in Lists link");
		 homepage_obj.click_select_Arrays();
		 arraypage_obj.clickBasicOperationsInLists();
		 arraypage_obj.click_tryhere();
		 Assert.assertEquals(arraypage_obj.click_run(),"Run"); 
	}

	
	@Test(priority=9,groups={"Array","FunctionalTesting"})
	public void verify_Applications_Of_Array_Link()
	{
		 logger.info("Verification of Applications Of Array link");
		 homepage_obj.click_select_Arrays();
		 arraypage_obj.clickApplicationsOfArray();
		 Assert.assertEquals(arraypage_obj.get_Applications_Of_Array_title(),p.getProperty("TitleApplicationsofArray"));	
	}

	@Test(priority=10,groups={"Array","FunctionalTesting"})
	public void verify_Applications_Of_Array_tryherebtn()
	{
		 logger.info("Verification of try here button under Applications Of Array link");
		 homepage_obj.click_select_Arrays();
		 arraypage_obj.clickApplicationsOfArray();
		 arraypage_obj.click_tryhere();
		 Assert.assertEquals(arraypage_obj.click_run(),"Run"); 
	}


	@Test(priority=11,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"DataDriven","Array","FunctionalTesting"})//getting data provider from different class different package
	public void verify_Arrays_In_Python_pythoncode(String code,String Result)
	{
		try
		{
		 homepage_obj.click_select_Arrays();
		 arraypage_obj.clickArraysInPython();
		 arraypage_obj.click_tryhere();
		 act.sendKeys(code).build().perform();
			/*
			 * arraypage_obj.click_run(); act.sendKeys(code).build().perform();
			 */
		 arraypage_obj.click_run();
	     if(arraypage_obj.get_Output()!=null && arraypage_obj.get_Output().equals(Result))
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

	@Test(priority=12,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"DataDriven","Array","FunctionalTesting"})//getting data provider from different class different package
	public void verify_Arrays_Using_List_pythoncode(String code,String Result)
	{
		try
		{
		 homepage_obj.click_select_Arrays();
		 arraypage_obj.clickArraysUsingList();
		 arraypage_obj.click_tryhere();
		 act.sendKeys(code).build().perform();
		 arraypage_obj.click_run(); 
	     if(arraypage_obj.get_Output()!=null && arraypage_obj.get_Output().equals(Result))
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
	
	@Test(priority=13,groups={"Array","FunctionalTesting"})
	public void verify_Array_practiceQuestions_Link()
	{
		 logger.info("Practice Questions link validation");
		 homepage_obj.click_select_Arrays();
		 arraypage_obj.clickArraysInPython();
		 arraypage_obj.click_Practice_Questions();
		 //Assert.fail(); 
		 Assert.assertEquals(arraypage_obj.get_Practice_Questions_Page(),p.getProperty("Practice_Questions"));	
	}
	

	@Test(priority = 14, dataProvider = "Pythoncode", dataProviderClass = DataProviders.class, groups = {
			"DataDriven","Array","FunctionalTesting" }) // getting data provider from different class different package
	public void verify_Array_practiceQuestions_Link_1(String code, String Result) {
		try {
			logger.info("Practice Questions link_1 validation");
			homepage_obj.click_select_Arrays();
			arraypage_obj.clickArraysInPython();
			arraypage_obj.click_Practice_Questions();
			arraypage_obj.click_Practice_QuestionsLink1();
			act.sendKeys(code).build().perform();
			arraypage_obj.click_run();

			if (arraypage_obj.get_Output() != null && arraypage_obj.get_Output().equals(Result)) {
				Assert.assertTrue(true);
			} else {
				driver.get().switchTo().alert().accept();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 15,groups={"Array","FunctionalTesting"}) // getting data provider from different class different package

	public void verify_Array_practiceQuestions_Link_1_SubmitBtn() {
		
		logger.info("Practice Questions link1 submit button validation");
		homepage_obj.click_select_Arrays();
		arraypage_obj.clickArraysInPython();
		arraypage_obj.click_Practice_Questions();
		arraypage_obj.click_Practice_QuestionsLink1();
		arraypage_obj.click_Submit();
		 Assert.assertEquals(arraypage_obj.get_Output(),p.getProperty("submit_error"));	

}

	@AfterTest()
	public void after_test()
	{
		logger.info("End of TC007_ArrayPageValidation");
	}
	
}
