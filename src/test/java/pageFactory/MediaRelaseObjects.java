package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MediaRelaseObjects {
	@FindBy(xpath="//a[text()='[X] Close']")
	public static WebElement alert;
	@FindBy(id="spMedia")
	public static WebElement mediaMenu;
	@FindBy(id="spMR")
	public static WebElement photoMenu;
	@FindBy(xpath = "//a[text()='2020']")
	public static WebElement relaseYear2020;
	@FindBy(xpath="//a[contains(text(),'CRYSTAL GAZES ')]")
	public static WebElement article;
	@FindBy(xpath="//img[contains(@src,'/writereaddata/images/06 Mar 2020.jpeg')]")
	public static WebElement image2020;
	@FindBy(xpath="//a[text()='2012']")
	public static WebElement relaseyear2012;
	@FindBy(xpath="//a[contains(text(),'ARMY EXPLORES NEW AVENUES')]")
	public static WebElement  armyExploreImageLink;
	@FindBy(xpath="//img[@src='http://www.indianarmy.gov.in/WriteReadData/Images/PR120312b.JPG']")
	public static WebElement  armyExploreImage;
}

