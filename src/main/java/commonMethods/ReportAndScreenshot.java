package commonMethods;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class ReportAndScreenshot {
	 WebDriver driver;
	 static  ExtentTest test;
	 public static void genarteReport(WebDriver driver,String ScreenShtPath,String status,String ReportfileName,String testName,String decrib)  {
	 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ReportfileName);
	 htmlReporter.setAppendExisting(true);
	 ExtentReports   extent = new ExtentReports();
	 extent.attachReporter(htmlReporter);
	 htmlReporter.config().setDocumentTitle("Test Report");
	 htmlReporter .config().setTheme(Theme.DARK);
	 htmlReporter.config().setReportName("IndianArmy automation report");
	 extent.setSystemInfo("OS", "windows10");
	 extent.setSystemInfo("Browser","Microsoft Edge");
	 extent.setSystemInfo("Selenium version","3.141.59");
	 extent.setSystemInfo("TestNg version","7.4.0");


	if(status.equalsIgnoreCase("fail")) {
		
	try {
		 test = extent.createTest(testName,decrib);
		test.log(Status.FAIL, decrib);
		test.addScreenCaptureFromPath(ScreenShtPath);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	}
	else if(status.equalsIgnoreCase("pass")) {
		try {
			 test = extent.createTest(testName,decrib);
			test.log(Status.PASS, decrib);
			test.addScreenCaptureFromPath(ScreenShtPath);
		} catch (IOException e) {
			
			e.printStackTrace();
		
	}}

	extent.flush();
	 }
	
 
	    public static void ScreenCapture(WebDriver driver ,String path){
	 	   TakesScreenshot scrShot =((TakesScreenshot)driver);
	 	    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	 	   
	 		File DestFile=new File(path);
	 		try {
	 			FileUtils.copyFile(SrcFile, DestFile);
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}
	    }
	 

}
