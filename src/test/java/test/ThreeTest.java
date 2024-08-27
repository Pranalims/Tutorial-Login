package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resource.base;

public class ThreeTest extends base  {

	public WebDriver driver;

@Test
		public void threeTest() throws IOException   {
			
	WebDriver driver = initializebrowser();
	
	driver.get(prop.getProperty("url"));
	
	driver.close();

	

}

}






