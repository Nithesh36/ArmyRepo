package testcases;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonMethods.ReportAndScreenshot;
import listeners.ListenerForArmy;
import pageFactory.MediaRelaseObjects;
import pageFactory.PhotoGalleryObjects;
import setupDrivers.GetDriver;
import webMethods.WebElementActions;
@Listeners(ListenerForArmy.class)
public class PhotoGallery extends   GetDriver {
	public static Logger logs=Logger.getLogger(MediaRelase.class.getName());

	@Parameters({"dropdownvalue","selectionType","pageNum"})
	@Test(priority = 3)
	public void paginationAndImageTest(@Optional("2245")String dropdownvalue,String selectionType,String pageNum) {
		try {
			System.out.println(dropdownvalue +" " +selectionType +" "+pageNum);
			WebElementActions.LoadUrl();
			PageFactory.initElements(driver,PhotoGalleryObjects.class);
			if(MediaRelaseObjects.alert.isDisplayed())
				MediaRelaseObjects.alert.click();
			logs.info("move to media page ");
			WebElementActions.MouseOver(MediaRelaseObjects.mediaMenu);
			WebElementActions.MouseOverAndClick(PhotoGalleryObjects.photoGallerySec);
			//select the type of event need to see
			WebElementActions.DropDownSelect(PhotoGalleryObjects.SwActivityDropDown, dropdownvalue, selectionType);
			//scroll down to locate the element
			((JavascriptExecutor)driver).executeScript("window.scrollBy('0','800')");
			//enter some value into pagination  box
			PhotoGalleryObjects.pageBox.sendKeys(pageNum);
			WebElementActions.click(PhotoGalleryObjects.GoButton);
			WebElementActions.click(PhotoGalleryObjects.nextButton);
			WebElementActions.click(PhotoGalleryObjects.imageModal);
			logs.info("close the modal");
			((JavascriptExecutor)driver).executeScript("arguments[0].click()",PhotoGalleryObjects.closeModal);
			logs.info("screenshots and reports will be captured via listeners");
			assertEquals(true, false);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void  PaginationTest() {

		try {  
			//	  select the type of event need to see
			logs.info("testing pagination functionality");
			((JavascriptExecutor)driver).executeScript("window.scrollBy('0','800')");
			((JavascriptExecutor)driver).executeScript("arguments[0].click()",PhotoGalleryObjects.nextButton);
			WebElementActions.waits(7);
			((JavascriptExecutor)driver).executeScript("arguments[0].click()",PhotoGalleryObjects.PreviousButton);
			WebElementActions.click(PhotoGalleryObjects.LastPageButton);
			((JavascriptExecutor)driver).executeScript("window.scrollBy('0','800')");
			logs.info("screenshots and reports are generated");
			ReportAndScreenshot.ScreenCapture(driver ,prop.getProperty("screenShot")+"//PaginationFail.png");
			ReportAndScreenshot.genarteReport(driver, prop.getProperty("screenShot")+"//PaginationFail.png", "pass", prop.getProperty("ReportLocation"), " PaginationTest", "Page is  naviagated to next page");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
