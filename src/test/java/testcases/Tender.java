package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonMethods.ReportAndScreenshot;
import listeners.ListenerForArmy;
import pageFactory.MediaRelaseObjects;
import pageFactory.TenderObjects;
import setupDrivers.GetDriver;
import webMethods.WebElementActions;
@Listeners(ListenerForArmy.class)
public class Tender extends GetDriver {
	public static Logger logs=Logger.getLogger(Tender.class.getName());
	
	
@Test(priority = 8)
public  void DocumentDownloadTest() {
	try {
		
	//initializing TenderPage objects
	logs.info("initializing TenderPage objects");
	PageFactory.initElements(driver, TenderObjects.class);
	driver.get(prop.getProperty("url"));
	WebElementActions.waits(20);
	if(MediaRelaseObjects.alert.isDisplayed())
		MediaRelaseObjects.alert.click();
	//mouse over the tender menu
	logs.info("mouse over the tender menu");
	WebElementActions.MouseOver(TenderObjects.tenderMenu);
	((JavascriptExecutor)driver).executeScript("arguments[0].click()",TenderObjects.tenders );
	//go to download page
	WebElementActions.click(TenderObjects.fileDownloadLink);
	logs.info("click the download Button");
	WebElementActions.click(TenderObjects.DownloadButton);
	WebElementActions.waits(15);
	if(WebElementActions.isFileDownloaded(prop.getProperty("DownloadLocation"), prop.getProperty("fileName")))
	{
		 ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//DoccumentDownloadTest.png");
		 ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//DoccumentDownloadTest.png", "pass", prop.getProperty("ReportLocation"), " DoccumentDownloadTest", "Doccument  is downlaoded");
		   	
	  	
	}
	else {
		 ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//DoccumentDownloadTest.png");
		 ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//DoccumentDownloadTest.png", "fail", prop.getProperty("ReportLocation"), " DoccumentDownloadTest", "Doccument  is missing");	
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

@Test(priority = 9)
public void DocumenVisibilityTest() {
	try {
	logs.info("move to tender menu ");
	driver.navigate().back();
	driver.navigate().back();
	//move to archives  module
	((JavascriptExecutor)driver).executeScript("arguments[0].click()",TenderObjects.archivesMenu);
	//selecting a category
	WebElementActions.click(TenderObjects.RfiRadioBox);
	WebElementActions.click(TenderObjects.ArchivesviewBtn);
	WebElementActions.click(TenderObjects.DownloadRfi);
	logs.info("document Download option is clicked");
	WebElementActions.click(TenderObjects.DownloadDoc);
	WebElementActions.waits(10);
		 ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//DocumentVisibilityTest.png");
		 ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//DocumentVisibilityTest.png", "pass", prop.getProperty("ReportLocation"), " DoccumentVisibilityTest", "Doccument  is visible");
}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
