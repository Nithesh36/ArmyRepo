package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublicationObjects {
@FindBy(css="#spPublication")
public static WebElement publicationMenu;

@FindBy(xpath="//span[text()='Baat Cheet']")
public static WebElement BaatCheet;
@FindBy(css= "#spKO")
public static WebElement knowledgeOnlineMenu;
@FindBy(css= "#spClaws")
public static WebElement publicationFromClaws;
@FindBy(name="ctl00$ContentPlaceHolder1$Baat")
public static WebElement yearSelectionDropDown;
@FindBy(css="table>tbody>tr>td>p>a")
public static WebElement KnowledgeOnlinelink;
@FindBy(xpath="//a[text()='Col Samir Srivastava']")
public static WebElement publicationPageLink;
@FindBy(xpath="//a[contains(text(),'Key Challenges of Radicalisation')]")
public static WebElement RadicalisationLink;


}
