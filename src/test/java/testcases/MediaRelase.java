package testcases;

import static org.testng.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import commonMethods.ReportAndScreenshot;
import configMethods.GetLog4j;
import configMethods.PropFileReader;
import listeners.ListenerForArmy;
import pageFactory.MediaRelaseObjects;
import setupDrivers.GetDriver;
import webMethods.WebElementActions;
@Listeners(ListenerForArmy.class)
public class MediaRelase extends GetDriver {
	public static Logger logs=Logger.getLogger(MediaRelase.class.getName());
	public static JavascriptExecutor js;
	@BeforeSuite
	public void setUp() {
		String path="D:\\project\\TesttingFrameworks\\Army\\src\\main\\resources\\configurationFiles\\pathAndBrowserConfig.properties";
		PropFileReader.readProp(path);
		//get the drivers
		getDrivers();
		js=(JavascriptExecutor)driver;
		//get the logs
		GetLog4j.getLog();
		driver.manage().window().maximize();		
		driver.get(prop.getProperty("url"));
		PageFactory.initElements(driver, MediaRelaseObjects.class);
		logs.info("drivers are initialized");
		logs.info("property files are loaded");
	}
	@Test(priority = 1)
	public void ValidImagesTest() {
		logs.info("initiaizied MediaRelase page factory for locating the element");
		PageFactory.initElements(driver, MediaRelaseObjects.class);
		//handling alerts
		WebElementActions.click(MediaRelaseObjects.alert);
		//mouse over the media menu
		WebElementActions.MouseOver(MediaRelaseObjects.mediaMenu);
		WebElementActions.MouseOverAndClick(MediaRelaseObjects.photoMenu);
		WebElementActions.click(MediaRelaseObjects.relaseYear2020);
		WebElementActions.click(MediaRelaseObjects.article);
		logs.info("checking image visibility");
		if(WebElementActions.GetImageAttributeVal(MediaRelaseObjects.image2020)>0) {
			logs.info("scrolldown to take screenshot of unavailable images");
			WebElementActions.scrollDown();
			logs.info("generating screenshots and reports");
			ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//validimage.png");
			ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//validimage.png", "pass", prop.getProperty("ReportLocation"), "validImageTest", "image is displayed");
		}
	}
	@Test(priority = 2)
	public void BrokenImageTest() {
		logs.info("handling Exceptions using try catch");
		try {
		WebElementActions.click(MediaRelaseObjects.relaseyear2012);
		WebElementActions.click(MediaRelaseObjects.armyExploreImageLink);
		if(WebElementActions.GetImageAttributeVal(MediaRelaseObjects.armyExploreImage)>0){
			System.out.println("image is not broken");
		}
		else
		{
			//scroll the page to take screenshot
			js.executeScript("window.scrollBy('0','600')");
			logs.info("generating screenshots and reports in listener class for failed testCase");
			//fail the test case to take screenshots using listener class
			assertEquals(false, true);
			
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
