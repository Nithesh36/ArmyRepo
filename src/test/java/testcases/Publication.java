package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commonMethods.ReportAndScreenshot;
import listeners.ListenerForArmy;
import pageFactory.MediaRelaseObjects;
import pageFactory.PublicationObjects;
import setupDrivers.GetDriver;
import webMethods.WebElementActions;
@Listeners(ListenerForArmy.class)
public class Publication  extends GetDriver{
	public static Logger logs=Logger.getLogger(Publication.class.getName());
@Parameters({"dropdownIndValue","selectionType1"})
@Test(priority = 5)
public void DocumentAvailabilityTest(String indValue,String TypeOfSelection) {
	logs.info("publication page Factory elements are initiaized");
	PageFactory.initElements(driver, PublicationObjects.class);
	//mouse over the publication menu
	WebElementActions.MouseOver(PublicationObjects.publicationMenu);
	WebElementActions.click(PublicationObjects.BaatCheet);
	//select a  year from the dropdown
	logs.info("select a  year from the dropdown");
	WebElementActions.DropDownSelect(PublicationObjects.yearSelectionDropDown, indValue, TypeOfSelection);
	logs.info("Document is displayed");
	WebElementActions.waits(20);
	ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//DocumentAvail.png");
	ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//DocumentAvail.png", "pass", prop.getProperty("ReportLocation"), " DocAvailavbilityTest", "Document  is available");
}

@Test(priority = 6)
public void  PublicationDocumentVisibilityTest() {
	WebElementActions.MouseOver(PublicationObjects.publicationMenu);
	logs.info("move to knowldegeOnline menu");
	WebElementActions.MouseOverAndClick(PublicationObjects.knowledgeOnlineMenu);
	WebElementActions.click(PublicationObjects.KnowledgeOnlinelink);
	WebElementActions.waits(20);
	if(driver.getCurrentUrl().indexOf("404")>0) {
		logs.info("link is  not broken");
		logs.info("Reports and screenshots are takened");
		ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//BrokenDocLink.png");
		ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//BrokenDocLink.png", "fail", prop.getProperty("ReportLocation"), " BrokenDocLinkTest", "Document Link  is Brokened");
		}
	else {
		logs.info("link is  broken");
		logs.info("Reports and screenshots are takened");
		ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//NonBrokenDocLink.png");
		ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//NonBrokenDocLink.png", "pass", prop.getProperty("ReportLocation"), " BrokenDocLinkTest", "Document Link  is not Brokened");
	}
}
@Test(priority=7)
public static void ValidUrlTest() {
	logs.info("navigated to the url");
	driver.get(prop.getProperty("url"));
	MediaRelaseObjects.alert.click();
	logs.info("move to publication menu");
	WebElementActions.MouseOver(PublicationObjects.publicationMenu);
	WebElementActions.MouseOverAndClick(PublicationObjects.publicationFromClaws);
	//click the url
	WebElementActions.click(PublicationObjects.publicationPageLink);	
	WebElementActions.waits(10);
	if(driver.getCurrentUrl().indexOf("404")>0) {
		ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//BrokenLink.png");
		ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//BrokenLink.png", "fail", prop.getProperty("ReportLocation"), " BrokenLinkTest", " Link  is Brokened");	
	}
	else {
		ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//UnBrokenLink.png");
		ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//UnBrokenLink.png", "pass", prop.getProperty("ReportLocation"), " UnBrokenLinkTest", " Link  is Not brokened");	
	}
	}
}
                                                                                                                                                                                                                                                                                                                      