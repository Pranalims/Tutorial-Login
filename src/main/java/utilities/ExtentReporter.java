package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	public static ExtentReports extent;
	
	public static  ExtentReports  getextentReporter() {
		
		String extentpath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter extentspark=new ExtentSparkReporter(extentpath);
		extentspark.config().setDocumentTitle("Test Result");
		extentspark.config().setReportName("TutorialApplicationReport");
		
		 extent=new ExtentReports();
		extent.attachReporter(extentspark);
		extent.setSystemInfo("Operating System", "Windows 10");
		extent.setSystemInfo("CreatedBy", "Pranali Mhatre");
		
		return extent;
		
		
			
		}
		
	
		
		
	
}
