package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjectmodel.DSAlgoGetStartedPom;
import pageobjectmodel.DSAlgoHomePom;
import pageobjectmodel.DSAlgoLinkedListPom;
import pageobjectmodel.DSAlgoSignInPom;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC011_LinkedListPageValidation extends BaseClass {

	Actions act;

	@BeforeMethod(groups= {"Linked List","DataDriven","FunctionalTesting"})
	public void before_testcase_setup() {

		getstartedpage_obj = new DSAlgoGetStartedPom(driver.get());
		getstartedpage_obj.clickGetStarted();
		homepage_obj = new DSAlgoHomePom(driver.get());
		homepage_obj.click_Signin();
		signinpage_obj = new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		linkedListpage_obj = new DSAlgoLinkedListPom(driver.get());
		act = new Actions(driver.get());
	}

  @Test(priority = 1) public void
	 verify_LinkedList_Getstartedbtn_PageValidation() {
	logger.info("TC005_LinkedListPageValidation"); logger.
	 info("LinkedList option Validation using linkedlist get started button");
	 homepage_obj.click_select_Linked_List(); if
 (linkedListpage_obj.gettile_page().equals(p.getProperty("titleLinkedList")))
 { logger.info("Test passed"); Assert.assertTrue(true); } else {
	 logger.error("Test failed.."); logger.debug("Debug logs...");
	 Assert.assertTrue(false); } }
	 
	  @Test(priority =2,groups={"Linked List","FunctionalTesting"}) public void
 verify_LinkedListOption_Dropdown_PageValidation() {
 logger.info("LinkedList option Validation using linekedlist dropdown option"
	 ); homepage_obj.click_select_Linked_List_options(); 
	 if
	 (linkedListpage_obj.gettile_page().equals(p.getProperty("titleLinkedList")))
 
	 {
	 
	 logger.info("Test passed"); Assert.assertTrue(true); } else {
	 
	 logger.error("Test failed.."); logger.debug("Debug logs...");
	  Assert.assertTrue(false); } }
	  
	  
/*	@Test(priority = 3)
	public void verify_Introduction_linked_List() {
	}{
		linkedListpage_obj.clicks_Introduction_Link();
		Assert.assertEquals(linkedListpage_obj.getPage_Introduction(),p.getProperty("Linked_List1"));
		
		 
	}
	
	*/
	
	@Test(priority=4,groups={"Linked List","FunctionalTesting"})	
	public void verify_Introduction_Link_tryherebtn_Link() {
		logger.info("Verification of  try here button under Introduction link");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_Introduction_Link();
	linkedListpage_obj.click_tryhere();
		Assert.assertEquals(linkedListpage_obj.click_run(),"Run"); 
	}

	 

	@Test(priority= 5,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"DataDriven","Linked List","FunctionalTesting"})
	public void verify_Introduction_inked_List_pythoncode(String code,String Result) {
		try
		{
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_Introduction_Link();
		linkedListpage_obj.click_tryhere();
	 act.sendKeys(code).build().perform();
		 linkedListpage_obj.click_run();
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

	
	@Test(priority =6,groups={"Linked List","FunctionalTesting"})
public void verify_Creating_Linked_List_Link() {
		logger.info("Verification of Creating Linked List Link");
		homepage_obj.click_select_Linked_List();
	
		
		Assert.assertEquals(linkedListpage_obj.getPage_Creating_Linked_LIst_Linked_List(),p.getProperty("Linked_List2"));
		
		 
	}
	

	@Test(priority=7,groups={"Linked List","FunctionalTesting"})
	public void verify_Creating_Linked_List() 
	{
		 logger.info("Verification of Creating Linked List Link");
		 homepage_obj.click_select_Linked_List();
	 linkedListpage_obj.clicks_Creating_Linked_List();
	 linkedListpage_obj.click_tryhere();
		 
		 Assert.assertEquals(linkedListpage_obj.click_run(),"Run"); 
}


	@Test(priority= 8,dataProvider="Pythoncode",dataProviderClass=DataProviders.class,groups={"DataDriven","Linked List","FunctionalTesting"})
	public void verify_Creating_Linked_List_pythoncode(String code,String Result) {
		try
		{
			homepage_obj.click_select_Linked_List();
			linkedListpage_obj.clicks_Introduction_Link();
			linkedListpage_obj.click_tryhere();
		 act.sendKeys(code).build().perform();
		 linkedListpage_obj.click_run();
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
		}	catch(Exception e)
		{
		e.printStackTrace();
}

  }


	@Test(priority = 1,groups={"Linked List","FunctionalTesting"})
	public void verify_Types_of_Linked_List() {
		logger.info("Verification of Types of Linked List Link");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_Types_of_Linked_List();
		Assert.assertEquals(linkedListpage_obj.getPage_Types_of_Linked_Linked_List(), p.getProperty("Linked_List3"));
	}

	@Test(priority = 7,groups={"Linked List","FunctionalTesting"})
	public void verify_Types_of_Linked_List_tryherebtn_Link() {
		logger.info("Verification of try here button under Types of Linked List");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_Types_of_Linked_List();
		linkedListpage_obj.click_tryhere();

		Assert.assertEquals(linkedListpage_obj.click_run(), "Run");
				
	}

	@Test(priority = 8, dataProvider = "Pythoncode", dataProviderClass = DataProviders.class, groups = { "DataDriven","Linked List","FunctionalTesting" })
	public void verify_Types_of_Linked_List_pythoncode(String code, String Result) {
		try {
			homepage_obj.click_select_Linked_List();
			linkedListpage_obj.clicks_Introduction_Link();
			linkedListpage_obj.click_tryhere();
			act.sendKeys(code).build().perform();
			linkedListpage_obj.click_run();
			act.sendKeys(code).build().perform();
			linkedListpage_obj.click_run();
			if (linkedListpage_obj.text_output() != null && linkedListpage_obj.text_output().equals(Result)) {
				Assert.assertTrue(true);
			} else {
				driver.get().switchTo().alert().accept();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	@Test(priority = 7,groups={"Linked List","FunctionalTesting"})
	public void Implement_Linked_List_in_Python() {		
		logger.info("Verification of Implement Linked List in Python");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_Implement_Linked_List_in_Python();
		Assert.assertEquals(linkedListpage_obj.getPage_Implement_Linked_List_in_Python(), p.getProperty("Linked_List4"));
	}





	@Test(priority = 8,groups={"Linked List","FunctionalTesting"})
	public void verify_Implement_Linked_List_in_Python_tryherebtn_Link() {
		logger.info("Verification of try here button under Implement Linked List in Python");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_Types_of_Linked_List();
		linkedListpage_obj.click_tryhere();

		Assert.assertEquals(linkedListpage_obj.click_run(), "Run");
				
	}

	@Test(priority = 9, dataProvider = "Pythoncode", dataProviderClass = DataProviders.class, groups = { "DataDriven" ,"Linked List","FunctionalTesting"})
	public void verify_implement_linked_List_in_Python_pythoncode(String code, String Result) {
		try {
			homepage_obj.click_select_Linked_List();
			linkedListpage_obj.clicks_Implement_Linked_List_in_Python();
			linkedListpage_obj.click_tryhere();
			act.sendKeys(code).build().perform();
			linkedListpage_obj.click_run();
			act.sendKeys(code).build().perform();
			linkedListpage_obj.click_run();
			if (linkedListpage_obj.text_output() != null && linkedListpage_obj.text_output().equals(Result)) {
				Assert.assertTrue(true);
			} else {
				driver.get().switchTo().alert().accept();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	@Test(priority = 10,groups={"Linked List","FunctionalTesting"})
	public void Verify_Traversal() {		
		logger.info("Verification of Traversal");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_Traversal();
		Assert.assertEquals(linkedListpage_obj.getPage_traversal(), p.getProperty("Linked_List5"));
	}
	
	

	

	@Test(priority = 11,groups={"Linked List","FunctionalTesting"})
	public void Verify_Traversal_tryherebtn_Link() {
		logger.info("Verification of Traversal");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_Traversal();
		linkedListpage_obj.click_tryhere();

		Assert.assertEquals(linkedListpage_obj.click_run(), "Run");
				
	}

	@Test(priority = 12, dataProvider = "Pythoncode", dataProviderClass = DataProviders.class, groups = {"DataDriven","Linked List","FunctionalTesting" })
	public void Verify_Traversal_pythoncode(String code, String Result) {
		try {
			homepage_obj.click_select_Linked_List();
			linkedListpage_obj.clicks_Traversal();
			linkedListpage_obj.click_tryhere();
			act.sendKeys(code).build().perform();
			linkedListpage_obj.click_run();
			act.sendKeys(code).build().perform();
			linkedListpage_obj.click_run();
			if (linkedListpage_obj.text_output() != null && linkedListpage_obj.text_output().equals(Result)) {
				Assert.assertTrue(true);
			} else {
				driver.get().switchTo().alert().accept();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	@Test(priority = 10,groups={"Linked List","FunctionalTesting"})
	public void Verify_Insertion() {		
		logger.info("Verification of Insertion");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_insertion_in_linked_list();
		Assert.assertEquals(linkedListpage_obj.getPage_insertion_in_linked_list(), p.getProperty("Linked_List6"));
	}

	@Test(priority =11,groups={"Linked List","FunctionalTesting"})
	public void Verify_Insertion_tryherebtn_Link() {
		logger.info("Verify_Insertion");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_insertion_in_linked_list();
		linkedListpage_obj.click_tryhere();
		Assert.assertEquals(linkedListpage_obj.click_run(), "Run");
	}

	@Test(priority = 12, dataProvider = "Pythoncode", dataProviderClass = DataProviders.class, groups = { "DataDriven","Linked List","FunctionalTesting" })
	public void Verify_Insertion_pythoncode(String code, String Result) {
		try {
			homepage_obj.click_select_Linked_List();
			linkedListpage_obj.clicks_insertion_in_linked_list();
			linkedListpage_obj.click_tryhere();
			act.sendKeys(code).build().perform();
			linkedListpage_obj.click_run();
			act.sendKeys(code).build().perform();
			linkedListpage_obj.click_run();
			if (linkedListpage_obj.text_output() != null && linkedListpage_obj.text_output().equals(Result)) {
				Assert.assertTrue(true);
			} else {
				driver.get().switchTo().alert().accept();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 13,groups={"Linked List","FunctionalTesting"})
	public void Verify_Deletion() {		
		logger.info("Verification of Deletion");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_deletion_in_linked_list();
		Assert.assertEquals(linkedListpage_obj.getPage_deletion_in_linked_list(), p.getProperty("Linked_List7"));
	}

	@Test(priority =14,groups={"Linked List","FunctionalTesting"})
	public void Verify_Deletion_tryherebtn_Link() {
		logger.info("Verify_Deletion");
		homepage_obj.click_select_Linked_List();
		linkedListpage_obj.clicks_deletion_in_linked_list();
		linkedListpage_obj.click_tryhere();
		Assert.assertEquals(linkedListpage_obj.click_run(), "Run");
	}

	@Test(priority = 15, dataProvider = "Pythoncode", dataProviderClass = DataProviders.class, groups = { "DataDriven","Linked List","FunctionalTesting" })
	public void Verify_Deletion_pythoncode(String code, String Result) {
		try {
			homepage_obj.click_select_Linked_List();
			linkedListpage_obj.clicks_deletion_in_linked_list();
			linkedListpage_obj.click_tryhere();
			act.sendKeys(code).build().perform();
			linkedListpage_obj.click_run();
			act.sendKeys(code).build().perform();
			linkedListpage_obj.click_run();
			if (linkedListpage_obj.text_output() != null && linkedListpage_obj.text_output().equals(Result)) {
				Assert.assertTrue(true);
			} else {
				driver.get().switchTo().alert().accept();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
	
	

