package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageobjectmodel.DSAlgoDataStructure_IntroductionPom;
import pageobjectmodel.DSAlgoGetStartedPom;
import pageobjectmodel.DSAlgoHomePom;
import pageobjectmodel.DSAlgoSignInPom;
import pageobjectmodel.DSAlgoStackPom;
import testbase.BaseClass;

public class TC004_HomePageValidation extends BaseClass{

	@BeforeMethod(groups= {"successful_login","Unsuccessful_login","FunctionalTesting"})
	public void before_testcase_setup() {
		    getstartedpage_obj=new DSAlgoGetStartedPom(driver.get());
		    getstartedpage_obj.clickGetStarted();
		    homepage_obj=new DSAlgoHomePom(driver.get());
		   
	}
	
	@Test(priority=1,groups={"successful_login","FunctionalTesting"})
	public void verify_stackOption()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("TC004_DataStructure_PageValidation");
		logger.info("Home page & Stack page validation using Get Started button");
		homepage_obj.click_select_stack();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titlestack"));		
	}
	@Test(priority=2,groups={"successful_login","FunctionalTesting"})
	public void verify_stack_dropdown()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & Stack page validation using dropdown option");
		homepage_obj.click_select_stack_options();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titlestack"));		
	}
	
	@Test(priority=3,groups={"successful_login","FunctionalTesting"})
	public void verify_datastructureOption()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		datastructurepage_obj=new DSAlgoDataStructure_IntroductionPom(driver.get());
		logger.info("Home page & datastructure page validation using Get Started button");
		homepage_obj.click_data_structures_introduction();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titledatastructure"));		
	}
	
	@Test(priority=4,groups={"successful_login","FunctionalTesting"})
	public void verify_ArrayOption()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & Array page validation using Get Started button");
		homepage_obj.click_select_Arrays();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleArray"));		
	}
	@Test(priority=5,groups={"successful_login","FunctionalTesting"})
	public void verify_Array_dropdown()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & Array page validation using dropdown option");
		homepage_obj.click_select_Arrays_options();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleArray"));		
	}
	
	@Test(priority=6,groups={"successful_login","FunctionalTesting"})
	public void verify_LinkedListOption()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & LinkedList page validation using Get Started button");
		homepage_obj.click_select_Linked_List();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleLinkedList"));		
	}
	@Test(priority=7,groups={"successful_login","FunctionalTesting"})
	public void verify_LinkedList_dropdown()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & LinkedList page validation using dropdown option");
		homepage_obj.click_select_Linked_List_options();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleLinkedList"));		
	}
	
	@Test(priority=8,groups={"successful_login","FunctionalTesting"})
	public void verify_GraphOption()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & Graph page validation using Get Started button");
		homepage_obj.click_select_Graph();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleGraph"));		
	}
	@Test(priority=9,groups={"successful_login","FunctionalTesting"})
	public void verify_Graph_dropdown()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & Graph page validation using dropdown option");
		homepage_obj.click_select_Graph_options();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleGraph"));		
	}
	
	@Test(priority=10,groups={"successful_login","FunctionalTesting"})
	public void verify_TreeOption()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & Tree page validation using Get Started button");
		homepage_obj.click_select_Tree();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleTree"));		
	}
	@Test(priority=11,groups={"successful_login","FunctionalTesting"})
	public void verify_Tree_dropdown()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & Tree page validation using dropdown option");
		homepage_obj.click_select_Tree_options();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleTree"));		
	}
	
	@Test(priority=12,groups={"successful_login","FunctionalTesting"})
	public void verify_QueueOption()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & Queue page validation using Get Started button");
		homepage_obj.click_select_Queue();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleQueue"));		
	}
	@Test(priority=13,groups={"successful_login","FunctionalTesting"})
	public void verify_Queue_dropdown()
	{
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		logger.info("Home page & Queue page validation using dropdown option");
		homepage_obj.click_select_Queue_options();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleQueue"));		
	}
	
	
	@Test(priority=14,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_stackOption_Unsuccessful_login()
	{
		logger.info("Home page & Stack page validation using Get Started button Unsuccessful_login");
		homepage_obj.click_select_stack();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=15,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_stack_dropdown_Unsuccessful_login()
	{
		logger.info("Home page & Stack page validation using dropdown option Unsuccessful_login");
		homepage_obj.click_select_stack_options();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=16,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_datastructureOption_Unsuccessful_login()
	{
		logger.info("Home page & datastructure page validation using Get Started button Unsuccessful_login");
		homepage_obj.click_data_structures_introduction();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=17,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_ArrayOption_Unsuccessful_login()
	{
		logger.info("Home page & Array page validation using Get Started button Unsuccessful_login");
		homepage_obj.click_select_Arrays();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=18,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_Array_dropdown_Unsuccessful_login()
	{
		logger.info("Home page & Array page validation using dropdown option Unsuccessful_login");
		homepage_obj.click_select_Arrays_options();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=19,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_LinkedListOption_Unsuccessful_login()
	{
		logger.info("Home page & LinkedList page validation using Get Started button Unsuccessful_login");
		homepage_obj.click_select_Linked_List();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=20,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_LinkedList_dropdown_Unsuccessful_login()
	{
		logger.info("Home page & LinkedList page validation using dropdown option Unsuccessful_login");
		homepage_obj.click_select_Linked_List_options();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=21,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_GraphOption_Unsuccessful_login()
	{
		logger.info("Home page & Graph page validation using Get Started button Unsuccessful_login");
		homepage_obj.click_select_Graph();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=22,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_Graph_dropdown_Unsuccessful_login()
	{
		logger.info("Home page & Graph page validation using dropdown option Unsuccessful_login");
		homepage_obj.click_select_Graph_options();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=23,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_TreeOption_Unsuccessful_login()
	{
		logger.info("Home page & Tree page validation using Get Started button Unsuccessful_login");
		homepage_obj.click_select_Tree();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=24,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_Tree_dropdown_Unsuccessful_login()
	{
		logger.info("Home page & Tree page validation using dropdown option Unsuccessful_login");
		homepage_obj.click_select_Tree_options();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=25,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_QueueOption_Unsuccessful_login()
	{
		logger.info("Home page & Queue page validation using Get Started button Unsuccessful_login");
		homepage_obj.click_select_Queue();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	@Test(priority=26,groups={"Unsuccessful_login","FunctionalTesting"})
	public void verify_Queue_dropdown_Unsuccessful_login()
	{
		logger.info("Home page & Queue page validation using dropdown option Unsuccessful_login");
		homepage_obj.click_select_Queue_options();
		if(homepage_obj.get_popup_not_logged().equals(p.getProperty("HomepagePopupMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	
	}
	
	@Test(priority=27,groups= {"FunctionalTesting"})
	public void verify_dropdown_button()
	{
		logger.info("Dropdown option should have six options Unsuccessful_login ");
		homepage_obj.click_select_dropdown();
		String expoptions[]= {"Arrays","Linked List","Stack","Queue","Tree","Graph"};
	    List <WebElement> op=homepage_obj.get_dropdown_options();
	    for(int i=0;i<op.size();i++)
	    {
	    	
	    	Assert.assertEquals(op.get(i).getText(), expoptions[i]);
	    }
	
	}
	@Test(priority=28,groups= {"FunctionalTesting"})
	public void verify_dropdown_button_successfullLogin()
	{
		logger.info("Dropdown option should have six options successful_login ");
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		homepage_obj.click_select_dropdown();
		String expoptions[]= {"Arrays","Linked List","Stack","Queue","Tree","Graph"};
	    List <WebElement> op=homepage_obj.get_dropdown_options();
	    for(int i=0;i<op.size();i++)
	    {
	    	
	    	Assert.assertEquals(op.get(i).getText(), expoptions[i]);
	    }
	}

	@Test(priority=29,groups= {"FunctionalTesting"})
	public void verify_LoginPage()
	{
		logger.info("Login Page Verification");
		homepage_obj.click_Signin();
	    Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleLoginPage"));
	}

	@Test(priority=30,groups= {"FunctionalTesting"})
	public void verify_registerPage()
	{
		logger.info("Registration Page Verification");
		homepage_obj.click_Register();
		Assert.assertEquals(driver.get().getTitle(),p.getProperty("titleRegistration"));
	}
	
	@Test(priority=31,groups= {"FunctionalTesting"})
	public void verify_Successfull_logout()
	{
		logger.info("Successfull log out verification");
		homepage_obj.click_Signin();   
		signinpage_obj=new DSAlgoSignInPom(driver.get());
		signinpage_obj.setUserName(p.getProperty("username"));
		signinpage_obj.setPassword(p.getProperty("password"));
		signinpage_obj.clickLogin();
		homepage_obj.click_Signout(); 
		if(homepage_obj.LogoutMsg().equals(p.getProperty("HomePageLogOutMessage")))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}
}
