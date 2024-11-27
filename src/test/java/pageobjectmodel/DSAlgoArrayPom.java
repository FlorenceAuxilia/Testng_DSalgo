package pageobjectmodel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DSAlgoArrayPom extends Baseclasspage {

	public DSAlgoArrayPom(WebDriver driver) {
		super(driver);
		
	}
 JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(xpath="//html/body/div[2]/h4")
	WebElement arrayPage_title;
	@FindBy(linkText = "Arrays in Python")
	WebElement ArraysInPython;
	
	public String gettitle_page() {
		return arrayPage_title.getText();
	}
	public void clickArraysInPython() {
		ArraysInPython.click();
		
	}
//Impl Arrays In Python Page
	@FindBy(xpath="//*[@class='bg-secondary text-white' and text()='Arrays in Python']")
	WebElement ArraysInPythonPage;
	
	public String get_ArraysInPython_title() {
		return ArraysInPythonPage.getText();
	}
	

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/a") 
	WebElement tryhere;
	public void click_tryhere() {
		tryhere.click();
		
	}
	
	@FindBy(xpath = "//button[text()='Run']") 
	WebElement runButton;
	public String click_run() {
		runButton.click();
		return runButton.getText();
	}
	
	@FindBy(linkText ="Arrays Using List") 
	WebElement ArraysUsingList;
	public String clickArraysUsingList() {
		ArraysUsingList.click();
		return ArraysUsingList.getText();
	}
	
	@FindBy(xpath="//*[@class='bg-secondary text-white' and text()='Arrays Using List']") 
	WebElement ArraysUsingListPage;
	public String get_Arrays_Using_List_title() {
		return ArraysUsingListPage.getText();
	}
	
	//Basic Operations In Lists
	@FindBy(linkText ="Basic Operations in Lists") 
	WebElement BasicOperationsInLists;
	public String clickBasicOperationsInLists() {
		BasicOperationsInLists.click();
		return BasicOperationsInLists.getText();
		
	}
	@FindBy(xpath="//*[@class='bg-secondary text-white' and text()='Basic Operations in Lists']") 
	WebElement BasicOperationsInListsPage;
	public String get_Basic_Operations_In_Lists_title() {
		return BasicOperationsInListsPage.getText();
	}
	//Impl ApplicationsOfArray
	
	@FindBy(linkText ="Applications of Array") 
	WebElement ApplicationsOfArray;
	public String clickApplicationsOfArray() {
		ApplicationsOfArray.click();
		return ApplicationsOfArray.getText();
		
	}
	@FindBy(xpath="//*[@class='bg-secondary text-white' and text()='Applications of Array']") 
	WebElement ApplicationsOfArrayPage;
	public String get_Applications_Of_Array_title() {
		return ApplicationsOfArrayPage.getText();
	}
	
	@FindBy(xpath="//*[@id='output']")
	WebElement txt_output;
	public Object text_output() {
		return txt_output.getText();	
		}
	
	@FindBy(xpath="//a[text()='Practice Questions']")
	WebElement Practice_Questions_link;
	public void click_Practice_Questions() {
		Practice_Questions_link.click();
		
	}
	
	@FindBy(xpath="//html/body/div[1]/nav/a") 
	WebElement Practice_Questions_Page;

	public String get_Practice_Questions_Page() {
		return Practice_Questions_Page.getText();
	}
	
	@FindBy(xpath="//a[text()='Search the array']")//
	WebElement Practice_Questions_link1;
	public void click_Practice_QuestionsLink1() {
		Practice_Questions_link1.click();
	}
	
	@FindBy(xpath="//*[@id='answer_form']/input[2]")//
	WebElement submitBtn;
	
	public String click_Submit() {
		submitBtn.click();
		return submitBtn.getText();
		
	}
	
	@FindBy(xpath = "//pre[@id='output']") 
	WebElement submitError;
	public String getError() {
		
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		System.out.println("Actual message appeared on screen: " + messageStr);
		return messageStr;
	}
	@FindBy(xpath = "//pre[@id='output']") 
	WebElement output;
	public String get_Output() {
		output.click();
		return output.getText();
	}
	
	/*
	 * @FindBy(xpath = "//pre[@id='output']") WebElement submitError; public String
	 * getError() { submitError.click(); return submitError;
	 * 
	 * }
	 */
	
	/*
	 * @FindBy(xpath =//*[@id="output"]") WebElement sumit_result; public String
	 * get_submitResult() { return sumit_result; }
	 */
	

}
