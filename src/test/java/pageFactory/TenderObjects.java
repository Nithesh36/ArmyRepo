package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenderObjects {
@FindBy(xpath = "//span[@id='spTender']")
public static WebElement tenderMenu;
@FindBy(xpath="//span[text()='Tenders']")
public static WebElement tenders;
@FindBy(xpath = "//a[text()='view']")
public static WebElement fileDownloadLink;
@FindBy(xpath = "//a[text()='Download']")
public static WebElement DownloadButton;
@FindBy(xpath = "//a[text()='Archives']")
public static WebElement archivesMenu;
@FindBy(xpath ="//*[contains(@value,'RFI')]")
public static WebElement  RfiRadioBox;
@FindBy(css="#ContentPlaceHolder1_grdRFI  tr:nth-child(3)   a")
public static WebElement  ArchivesviewBtn;
@FindBy(xpath="//a[text()='Download RFI']")
public static WebElement DownloadRfi;


@FindBy(id="ContentPlaceHolder1_grdTnderfiles_hpl1_0")
public static WebElement DownloadDoc;

}
