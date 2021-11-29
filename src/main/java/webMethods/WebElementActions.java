package webMethods;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import configMethods.PropFileReader;
import setupDrivers.GetDriver;

public class WebElementActions extends GetDriver {
	
	public static JavascriptExecutor js=(JavascriptExecutor)driver;
	public static Actions act=new Actions(driver);
	public static  void MouseOver(WebElement ele) {
		act.moveToElement(ele).perform();
	}
	public static  void MouseOverAndClick(WebElement ele) {
		act.moveToElement(ele).click().build().perform();
	}
	public static void click(WebElement ele) {
		if(ele.isDisplayed())
		ele.click();
	}
	public static int GetImageAttributeVal(WebElement ele) {
		return Integer.valueOf(ele.getAttribute("naturalWidth"));
	}
	public static void scrollDown() {
		js.executeScript("window.scrollBy('0','200')");
	}
	public static void DropDownSelect(WebElement ele,String value,String type) {
		Select select=new Select(ele);
		if(type.equalsIgnoreCase("Value"))
		select.selectByValue(value);
		else if(type.equalsIgnoreCase("index"))
			select.selectByIndex(Integer.valueOf(value));
		else if(type.equalsIgnoreCase("visibleText"))
			select.selectByVisibleText(value);

	}
	public static void LoadUrl() {
		String path="D:\\project\\TesttingFrameworks\\Army\\src\\main\\resources\\configurationFiles\\pathAndBrowserConfig.properties";

		PropFileReader.readProp(path);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));	
	}
	public static void waits(long time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 static boolean  found=false;

		public static  boolean isFileDownloaded(String downloadPath, String fileName) {
		    File dir = new File(downloadPath);
		    File[] dir_contents = dir.listFiles();
		  	    
		    for (File file : dir_contents) {
		    	if(file.getName().equalsIgnoreCase(fileName))
		    		found=true;
	 		}
		   return found; 
		    
		}
		public static void naviagtion(String naviagtionType) {
			if(naviagtionType.equalsIgnoreCase("back"))
				driver.navigate().back();
			else 
				driver.navigate().forward();
		}
}
