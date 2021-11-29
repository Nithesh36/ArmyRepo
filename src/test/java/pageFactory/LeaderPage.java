package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeaderPage {
@FindBy(id="spLeader")
public static WebElement Leader;
@FindBy(id="spVCAS")
public static WebElement viceCheif;
@FindBy(id="spAC")
public static WebElement armyCommanders;
@FindBy(id="spDcoas")
public static WebElement deputyChief;
@FindBy(xpath="//a[text()='[X] Close']")
public static WebElement alert;

}
