package stepsdefinaions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.loginpage;


public class loginsteps {
	public WebDriver driver;//webdriver declared
	public loginpage lp;//this two has global varibles
	@Given("I launch chrome browser")
	public void i_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	    lp=new loginpage(driver);
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
		driver.manage().window().maximize();
	    driver.get(url);
	}

	@Then("enter username {string} and password {string}")
	public void enter_username_and_password(String username, String password) throws Throwable {
	  lp.logindetalis(username, password);
	  
	}

	@Then("click an login")
	public void click_an_login() throws InterruptedException {
	    lp.enterorangehrmdasbord();
	    Thread.sleep(3000);
	}
	@Then("verfiy orangehrm dashbord brandbanner")
	public void verfiy_orangehrm_dashbord_brandbanner() {
WebElement logo = driver.findElement(By.xpath("//img[@alt=\"client brand banner\"]"));
       Assert.assertTrue(logo.isDisplayed());
		
	}
 
@Then("close browser")
	public void close_browser() {
	 driver.quit();
	}

	}