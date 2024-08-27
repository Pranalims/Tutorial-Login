package stepdefination;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resource.base;

public class Login extends base {

	WebDriver driver;
	LandingPage landingpage;
	LoginPage loginpage;
	
	@Given("Open the bowser")
	  public void open_the_bowser() throws IOException {
	  // Write code here that turns the phrase above into concrete actions
	 
		 driver = initializebrowser();
		
		driver.get(prop.getProperty("url"));
		
	  }
	  
	  @And("Navigate to login page")
	  public void navigate_to_login_page() throws InterruptedException {
	  // Write code here that turns the phrase above into concrete actions
	  
			
			 landingpage=new LandingPage(driver);
			landingpage.myaccountdropdown().click();
			
			landingpage.login().click();
			
			
			Thread.sleep(2000);
			
			
	  }
	  
	  @When("User enters username and Password")
	  public void user_enters_username_and_password(io.cucumber.datatable.DataTable dataTable) {
		  
		 
			
			
			//loginpage.Password().sendKeys(Password);
		  loginpage= new LoginPage(driver) ;
			
		  
		  List<List<String>> cells = dataTable.cells();
		  
		  
		  loginpage.emailid().sendKeys(cells.get(0).get(0));
		  loginpage.Password().sendKeys(cells.get(0).get(1));
		  
		  
		  
	  // Write code here that turns the phrase above into concrete actions
	  // For automatic transformation, change DataTable to one of
	  // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	  // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	  // Double, Byte, Short, Long, BigInteger or BigDecimal.
	  //
	  // For other transformations you can register a DataTableType.
	  
	  }
	  
	  @And("click on login button")
	  public void click_on_login_button() {
	  // Write code here that turns the phrase above into concrete actions
		  loginpage.loginbutton().click();
			
			
			
	  
		  
	  }
	  
	  @Then("user should be able to successfully login")
	  public void user_should_be_able_to_successfully_login() {
	  // Write code here that turns the phrase above into concrete actions
	  
		  AccountPage accountpage= new AccountPage(driver);
		  Assert.assertTrue(accountpage.Myaccountpage().isDisplayed());
	  
	  
	  }
	  
	  @After
	  public void closure() {
		  
		  driver.close();
	  }
	  
}
