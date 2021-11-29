package testcases;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import commonMethods.ReportAndScreenshot;
import listeners.ListenerForArmy;
import pageFactory.LeaderPage;
import setupDrivers.GetDriver;
import webMethods.WebElementActions;
@Listeners(ListenerForArmy.class)
public class Leaders  extends GetDriver{
	public static Logger logs=Logger.getLogger(Leaders.class.getName());

@Test(priority = 10)
public static void  LinkTest() {
	logs.info("initiaizing page factory elements for leaderPage");
	PageFactory.initElements(driver, LeaderPage.class);
	//navigate to Home page
	logs.info("navigate to Home page to access elements");
	driver.get("https://indianarmy.nic.in/");
	//handling alerts
	WebElementActions.click(LeaderPage.alert);
	//move into leader page
	logs.info("move into the leader page");
	WebElementActions.MouseOver(LeaderPage.Leader);
	WebElementActions.MouseOverAndClick(LeaderPage.viceCheif);
	WebElementActions.MouseOver(LeaderPage.Leader);
	WebElementActions.MouseOverAndClick(LeaderPage.armyCommanders);
	WebElementActions.MouseOver(LeaderPage.Leader);
	WebElementActions.MouseOverAndClick(LeaderPage.deputyChief);
	//check if the url is broken
	if(driver.getCurrentUrl().indexOf("404")>0)
	{		
		logs.info("reports and scrrenshots were takened");
		ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//NonBrokenLink.png");
		ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//NonBrokenLink.png", "pass", prop.getProperty("ReportLocation"), "BrokenLinkTest", "Link is not Brokened");
	}
	else
	{
		logs.info("reports and scrrenshots were takened");
		ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//BrokenLink.png");
		ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//BrokenLink.png", "pass", prop.getProperty("ReportLocation"), " BrokenLinkTest", "Link is Brokened");
	}
	
}
}
