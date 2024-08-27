package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.base;
import utilities.ExtentReporter;

public class Listener extends base implements ITestListener {

	public WebDriver driver;
	public  ExtentReports extentreport = ExtentReporter.getextentReporter();
	public ExtentTest extentTest;
	ThreadLocal<ExtentTest> threadsafe=new ThreadLocal<ExtentTest>();

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String testname = result.getName();
		extentTest=extentreport.createTest(testname);
		threadsafe.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//extentTest.log(Status.PASS, "Test is passed");
		threadsafe.get().log(Status.PASS, "Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//extentTest.fail(result.getThrowable());
		threadsafe.get().fail(result.getThrowable());

String testMethodName = result.getName();
		
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String screenshptpath=takeScreenshot(testMethodName, driver);
			threadsafe.get().addScreenCaptureFromPath(screenshptpath, testMethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentreport.flush();
	}

}
