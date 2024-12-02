package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DSAlgoTreePom extends Baseclasspage{

	
	//private WebDriver driver;
	
		public DSAlgoTreePom(WebDriver driver){
			super(driver);
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		
		 @FindBy(linkText="Overview of Trees")
			WebElement Overview_of_Trees;
		 @FindBy(linkText="Terminologies")
			WebElement Terminologies;
		 @FindBy(linkText="Types of Trees")
			WebElement Types_of_Trees;
		 @FindBy(linkText="Tree Traversals")
			WebElement Tree_Traversals;
		 @FindBy(linkText="Traversals-Illustration")
			WebElement Traversals_Illustration;
		 @FindBy(linkText="Binary Trees")
			WebElement Binary_Trees;
		 @FindBy(linkText="Types of Binary Trees")
			WebElement Types_of_Binary_Trees;
		 @FindBy(linkText="Implementation in Python")
			WebElement Implementation_in_Python;
		 @FindBy(linkText="Binary Tree Traversals")
			WebElement Binary_Tree_Traversals;
		 @FindBy(linkText="Implementation of Binary Trees")
			WebElement Implementation_of_Binary_Trees;
		
		 
		 
		 
		 @FindBy(xpath="//a[text()='Try here>>>']")
			WebElement tryHere;
		//By runButton=By.xpath("//button[text()='Run']");
		@FindBy(xpath="//button[text()='Run']")
		WebElement runButton;
		
		@FindBy(xpath="//*[@id='output']")
		WebElement txt_output;
		String actualTitle;
		
		public void ClickLink(String linkName)
		{
			driver.findElement(By.linkText(linkName)).click();
		}
		public void ClickOverviewofTrees()
		{
			Overview_of_Trees.click();
		}
		
		public void ClickTerminologies()
		{
			Terminologies.click();
		}
		
		
		
		
		
		
		
		public void verifyQPage(String title) {
			// TODO Auto-generated method stub
			actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle, title);
			
		}
		public String getPageTitle() {
			// TODO Auto-generated method stub
			return (driver.getTitle());
			
			
		}
		
		public void click_tryHere()
		{
			js.executeScript("arguments[0].scrollIntoView();", tryHere);
			tryHere.click();
			
		}
		public void click_run()
		{
			runButton.click();
			
		}
		
		public String runButtonText()
		{
			runButton.click();
			return (runButton.getText());
		}
		
		public String text_output()
		{
			
			return txt_output.getText();
		}
		

}
