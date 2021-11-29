package setupDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import configMethods.PropFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDriver extends PropFileReader {
	public static WebDriver driver;
	
  public static void getDrivers() {
	  
	  
	  if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
	  		driver=new EdgeDriver();
	  		
	  }
//	  else if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//	  		driver=new ChromeDriver();
//	  		
//	  }
//	  else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//	  		driver=new FirefoxDriver();
//	  		
//	  }
	  
  }
  
}
