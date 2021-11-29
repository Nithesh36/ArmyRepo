package testcases;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import commonMethods.ReportAndScreenshot;
import listeners.ListenerForArmy;
import pageFactory.MakeInIndiaObjects;
import setupDrivers.GetDriver;
import webMethods.WebElementActions;
@Listeners(ListenerForArmy.class)
public class MakeInIndia extends GetDriver {
	public static Logger logs=Logger.getLogger(MakeInIndia.class.getName());
@Test(priority = 11)
public void ValidNaviagtionTest() {
	//initializing page Factory elements
	logs.info("make india page objects are initialized");
	PageFactory.initElements(driver, MakeInIndiaObjects.class);
	//navigate to the module
	logs.info("navigated to Make in india module");
	WebElementActions.click(MakeInIndiaObjects.makeInIndia);
	//click the valid Navigation  menu
	WebElementActions.waits(4);
	WebElementActions.click(MakeInIndiaObjects.aboutUs);
	WebElementActions.click(MakeInIndiaObjects.contactUs);
	logs.info("screenshots and reports are generated");
	ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//validNaviagtionTest.png");
	ReportAndScreenshot.genarteReport(driver,prop.getProperty("screenShot")+"//validNaviagtionTest.png" , "pass", prop.getProperty("ReportLocation"), "validNaviagtionTest", "pages are navigated as expected");
}


}
