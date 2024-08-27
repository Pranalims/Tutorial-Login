package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resource.base;

public class LoginTest  extends base{

	WebDriver driver;
	Logger log = LogManager.getLogger(LoginTest.class.getName());
	
	@BeforeMethod
	public void openApplication() throws IOException {
		
		driver = initializebrowser();
		log.debug("Chrome browser launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigate to tutorial ninja application");
	}
	
	
	@Test(dataProvider="getData")
	public void login(String email,String Password,String expectedresult)
			
			throws IOException, InterruptedException {
		
		

		Thread.sleep(2000);
		
		LandingPage landingpage=new LandingPage(driver);
		landingpage.myaccountdropdown().click();
		log.debug("user should be able to click on Myaccount dropdown");
		landingpage.login().click();
		log.debug("user should be able to click on login");
		
		Thread.sleep(2000);
		
		LoginPage loginpage= new LoginPage(driver) ;
		loginpage.emailid().sendKeys(email);
		log.debug("user should be able to enter email ");
		loginpage.Password().sendKeys(Password);
		log.debug("user should be able to enter Password ");
		loginpage.loginbutton().click();
		log.debug("user should be able to click on login");
		
		AccountPage accountpage= new AccountPage(driver);
		log.debug("user got logged in");
		String Actualresult = null;
	try{
		if(accountpage.Myaccountpage().isDisplayed()) {
			
			
		}		Actualresult="success";
		log.info("Login is passed");
	
	}catch(Exception E) {
		
		Actualresult="failure";
		log.error(" Login is failed");
	}
	
	Assert.assertEquals(Actualresult, expectedresult);
	
	}

	@DataProvider
	public Object [][] getData() {
		
		Object [][] data= {{"sujal@gmail.com","sujal@12345","success"}};
		return data;
		
	}
	
	
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
		
	}
		
}
	
		
	

	


