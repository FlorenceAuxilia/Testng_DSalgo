package utilities;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import testbase.BaseClass;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.qameta.allure.Allure;

public class ExtentReportUtility implements ITestListener {
	public ExtentSparkReporter sparkReporter; 
	public ExtentReports extent; 
	public ExtentTest test; 
	
	String repName;
	
	public void onStart(ITestContext testContext) 
	{
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-"+ timestamp+".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
		sparkReporter.config().setDocumentTitle("DSAlgo Automation Report");
		sparkReporter.config().setReportName("DSAlgo Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "DSAlgo");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA"); 		
		extent.setSystemInfo("Operating System", "Windows");
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);	
		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups",includedGroups.toString());
		}
	}
	
	 public void onTestSuccess(ITestResult result) 
	 {
		 test=extent.createTest(result.getMethod().getMethodName());
		 test.assignCategory(result.getMethod().getGroups()); 
		 test.log(Status.PASS,result.getName()+"got successfully executed");
	 }
	 
	 public void onTestFailure(ITestResult result) 
	 {
		 test=extent.createTest(result.getMethod().getMethodName());
		 test.assignCategory(result.getMethod().getGroups());	 
		 test.log(Status.FAIL,result.getName()+"got failed");
		 test.log(Status.INFO,result.getThrowable().getMessage()); 
		 try
		 {
			 String imgPath=new BaseClass().captureScreen(result.getName());
			 test.addScreenCaptureFromPath(imgPath);
			 
		 }
		 catch(Exception e1)
		 {
			 e1.printStackTrace();
		 }
	 }
	
	 public void onTestSkipped(ITestResult result)
	 {
		 test=extent.createTest(result.getMethod().getMethodName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.SKIP,result.getName()+" got skipped");
		 test.log(Status.INFO,result.getThrowable().getMessage()); 
	 }
	 
	 public void onFinish(ITestContext context) 
	 {
		 extent.flush();
		 String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		 File extentReport=new File(pathOfExtentReport);
		 try
		 {
			 Desktop.getDesktop().browse(extentReport.toURI());
		 }
		 catch(Exception e1)
		 {
			 e1.printStackTrace();
		 }
	 }
	 
	
}
