package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import io.qameta.allure.Allure;
import pageobjectmodel.*;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
public static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();	
//public static WebDriver driver;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
public static Logger logger;	//log4j
public Properties p;
public DSAlgoGetStartedPom getstartedpage_obj;
public DSAlgoSignInPom signinpage_obj;
public DSAlgoLoginPom loginpage_obj;
public DSAlgoHomePom homepage_obj;
public DSAlgoStackPom stakpage_obj;
public DSAlgoQueuePom queuepage_obj;
public DSAlgoTreePom treepage_obj;
public DSAlgoGraphPom graphpage_obj;
public DSAlgoDataStructure_IntroductionPom datastructurepage_obj;
public DSAlgoArrayPom arraypage_obj;
public DSAlgoRegisterPom registerpage_obj;
public DSAlgoLinkedListPom linkedListpage_obj;
public ExtentReports extent;


	@BeforeMethod(groups= {"Stack","GetStarted","Graph","Tree","Login","Queue","DataDriven","datastructure","FunctionalTesting","successful_login","Unsuccessful_login","Array","Register","Linked List"})
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
//log 4j2		
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome":driver.set(new ChromeDriver());break;
		case "edge":driver.set(new EdgeDriver());break;
		case "firefox":driver.set(new FirefoxDriver());break;
		default :System.out.println("Invalid browser");
		return;
		}		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		getDriver().get(p.getProperty("appurl"));
		getDriver().manage().window().maximize();
		
		
		
	}
	public static synchronized WebDriver getDriver() {
		return driver.get();
	}
	

	@AfterMethod(groups= {"Stack","GetStarted","Graph","Tree","Login","Queue","DataDriven","datastructure","FunctionalTesting","successful_login","Unsuccessful_login","Array","Register","Linked List"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	
	
	public String captureScreen(String tname) throws IOException{
		
		String timestamp=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());	
		TakesScreenshot takescreenshot=(TakesScreenshot)driver.get();
		File sourceFile=takescreenshot.getScreenshotAs(OutputType.FILE);	
		Allure.addAttachment("screenshot", FileUtils.openInputStream(sourceFile));
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
	}

	
    
}

