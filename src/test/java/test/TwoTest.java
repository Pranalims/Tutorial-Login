package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resource.base;

public class TwoTest extends base{


@Test
		public void twoTest() throws IOException {
			
	WebDriver driver = initializebrowser();
	
	driver.get(prop.getProperty("url"));
	driver.close();
	}

}
