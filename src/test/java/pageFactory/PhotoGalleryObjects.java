package pageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotoGalleryObjects {
@FindBy(id = "spMedia")
public static WebElement mediaMenu;
@FindBy(id="spPhoto")
public static WebElement photoGallerySec;
@FindBy(id="ContentPlaceHolder1_cmbCategory")
public static WebElement SwActivityDropDown;
@FindBy(css = "input[value='Last']")
public static WebElement LastPageButton;
@FindBy(css="option[value='8074']")
public static WebElement FloodField;
@FindBy(css="input[value='Next']")
public static WebElement nextButton;

@FindBy(css="input[value='Go']")
public static WebElement GoButton;
@FindBy(css="input[value='previous']")
public static WebElement PreviousButton;
@FindBy(xpath="//*[contains(@id,'txtpageno')]")
public static WebElement pageBox;
@FindBy(xpath="//img[@id='ContentPlaceHolder1_DataListPhoto_imggen_1'][1]")
public static WebElement imageModal;
@FindBy(xpath = "//button[text()='Close']")
public static WebElement closeModal;


}
