package listeners;
import java.lang.reflect.Method;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import commonMethods.ReportAndScreenshot;
import configMethods.GetLog4j;
import configMethods.PropFileReader;
import setupDrivers.GetDriver;

public class ListenerForArmy implements ITestListener {

	public void onTestStart(ITestResult result) {
		//it will execute before each test method
		GetLog4j.logs.info(result.getName() +" testCase started");
		System.out.println(result.getName()+" testcase started");	
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println();
		System.out.println("-----------passed case ------------");

		System.out.println(result.getName()+" testCase passed");
	}

	public void onTestFailure(ITestResult result) {
		if(result.getName().equalsIgnoreCase("BrokenImageTest")) {
			ReportAndScreenshot.ScreenCapture(GetDriver.driver ,PropFileReader.prop.getProperty("screenShot")+"//Brokenimage.png");
			ReportAndScreenshot.genarteReport(GetDriver.driver, PropFileReader.prop.getProperty("screenShot")+"//Brokenimage.png", "fail", PropFileReader.prop.getProperty("ReportLocation"), " BrokenImageTest", "image is Brokened");
		}
		else if(result.getName().equalsIgnoreCase("paginationAndImageTest")) {
			ReportAndScreenshot.ScreenCapture(GetDriver.driver ,PropFileReader.prop.getProperty("screenShot")+"//PaginationAndImage.png");
			ReportAndScreenshot.genarteReport(GetDriver.driver, PropFileReader.prop.getProperty("screenShot")+"//PaginationAndImage.png", "fail", PropFileReader.prop.getProperty("ReportLocation"), " PaginationAndImageTest", "image modal is not closing");
		}
		System.out.println();
		System.out.println("-----------failed case ------------");
		System.out.println(result.getName()+" testCase failed");


	}
	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context,Method method,ITestResult result) {
		//it will execute before each Test tag

		GetLog4j.logs.info(context.getName()+" is started");
		System.out.println(context.getName() + " is  started");
	}

	public void onFinish(ITestContext context,Method method) {
		//it will execute after each  test Tag
		GetLog4j.logs.info(method.getName()+" is finished");
	}

}
