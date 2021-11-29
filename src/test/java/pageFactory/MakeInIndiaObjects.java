package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MakeInIndiaObjects {
@FindBy(id="spMI")
public static WebElement makeInIndia;
@FindBy(css="input[placeholder='Search…']")
public static WebElement searchBar;
@FindBy(xpath="//a[text()='About Us']")
public static WebElement aboutUs;
@FindBy(xpath="//a[text()='Feedback']//parent::li")
public static WebElement FeedBack;
@FindBy(css=".header-nav--primary  >li:nth-child(3)")
public static WebElement RFI;
@FindBy(xpath="//a[text()='view']")
public static WebElement viewButton;
@FindBy(xpath="//a[text()='Contact Us']")
public static WebElement contactUs;
}
