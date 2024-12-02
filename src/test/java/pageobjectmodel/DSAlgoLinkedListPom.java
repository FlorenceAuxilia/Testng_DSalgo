package pageobjectmodel;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DSAlgoLinkedListPom extends Baseclasspage {

	public DSAlgoLinkedListPom(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	@FindBy(xpath = "//h4[@class='bg-secondary text-white' and text()='Linked List']")
	WebElement page_title;
	@FindBy(linkText = "linked-list")
	WebElement linkedlist;

	@FindBy(linkText = "Introduction")
	WebElement introduction;

	@FindBy(linkText = "types-of linked-list")
	WebElement types_of_linked__List;

	@FindBy(linkText = "implement linked list in python")
	WebElement implement_linked_List_in_Python;

	@FindBy(linkText = "Traversal")
	WebElement traversal;

	@FindBy(linkText = "Insertion")
	WebElement insertion;

	@FindBy(linkText = "Deletion")
	WebElement deletion;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHere;

	@FindBy(xpath = "//button[text()='Run']")
	WebElement runButton;

	public Object gettile_page() {
		return page_title.getText();
	}

	public void clicks_Introduction_Link() {
		introduction.click();
	}

	public void PageIntroduction() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/introduction/");
	}

	public String getPage_Introduction() {
		return introduction.getText();
	}

	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement btn_tryhere;

	public void click_tryhere() {
		js.executeScript("arguments[0].scrollIntoView();", btn_tryhere);
		btn_tryhere.click();
	}

	@FindBy(xpath = "//button[text()='Run']")
	WebElement btn_Run;

	public String click_run() {
		btn_Run.click();
		return btn_Run.getText();
	}

	@FindBy(xpath = "//textarea[@id='editor']")
	WebElement txt_area;
	@FindBy(xpath = "//*[@id='output']")
	WebElement txt_output;

	public String text_output() {
		return txt_output.getText();
	}

	@FindBy(xpath = "//a[@href='creating-linked-list']")
	WebElement creating_linked_list_title;

	public void clicks_Creating_Linked_List() {
		creating_linked_list_title.click();
	}

	public String getPage_Creating_Linked_LIst_Linked_List() {
		return creating_linked_list_title.getText();
	}

	@FindBy(xpath = "//a[@href='types-of-linked-list']")
	WebElement types_of_linked_list_title;

	public void clicks_Types_of_Linked_List() {
		types_of_linked_list_title.click();
	}

	@FindBy(xpath = "//*[@class='bg-secondary text-white' and text()='Types of Linked List']")
	WebElement types_of_linked_list_title_text;

	public String getPage_Types_of_Linked_Linked_List() {
		return types_of_linked_list_title_text.getText();
	}

	/*public String types_of_linked_listgetText() {
		return types_of_linked_listgetText();
	}

	public String getPage_types_of_linked_List() {
		return types_of_linked__List.getText();
	}*/

	@FindBy(xpath="//a[@href='implement-linked-list-in-python']") 
	WebElement implement_linked_list_in_Python_title;
	
	public void clicks_Implement_Linked_List_in_Python() {
		implement_linked_list_in_Python_title.click();
	}
	
	@FindBy(xpath="//*[@class='bg-secondary text-white' and text()='Implement Linked List in Python']") 
	WebElement implement_linked_list_in_Python_title_text;
	
	public String getPage_Implement_Linked_List_in_Python() { 
		return implement_linked_list_in_Python_title_text.getText(); 
	}
	
	
	@FindBy(xpath="//a[@href='traversal']") 
	WebElement traversal_title;

	public void clicks_Traversal() {
		 traversal_title.click();
	}
	
	@FindBy(xpath="//*[@class='bg-secondary text-white' and text()='Traversal']") 
	WebElement traversal_title_text;

	public String getPage_traversal() { 
		return traversal_title_text.getText(); 
	}
	

	@FindBy(xpath="//a[@href='insertion-in-linked-list']") 
	WebElement insertion_in_linked_list_title;

	public void clicks_insertion_in_linked_list() {
		 insertion_in_linked_list_title.click();
	}	

	@FindBy(xpath="//*[@class='bg-secondary text-white' and text()='Insertion']") 
	WebElement insertion_in_linked_title_text;

	public String getPage_insertion_in_linked_list() {		
		return insertion_in_linked_title_text.getText();
	}
	
	@FindBy(xpath="//a[@href='deletion-in-linked-list']") 
	WebElement deletion_in_linked_list_title;

	public void clicks_deletion_in_linked_list() {
		deletion_in_linked_list_title.click();
	}	

	@FindBy(xpath="//*[@class='bg-secondary text-white' and text()='Deletion']") 
	WebElement deletion_in_linked_title_text;

	public String getPage_deletion_in_linked_list() {		
		return deletion_in_linked_title_text.getText();
	}

	public void click_applications(WebElement Applications_lnk)
	{
		Applications_lnk.click();
	}
	
	
	}
		
		
	
	
	

