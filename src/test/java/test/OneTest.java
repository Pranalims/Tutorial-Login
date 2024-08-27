package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resource.base;

public class OneTest extends base {

	
	public WebDriver driver;
	
@Test
		public void oneTest() throws IOException {
			
	 driver = initializebrowser();
	
	driver.get(prop.getProperty("url"));
	
	Assert.assertTrue(false);
	
}
@AfterMethod
public void closure() {
	
	driver.close();
	
	
}

}
