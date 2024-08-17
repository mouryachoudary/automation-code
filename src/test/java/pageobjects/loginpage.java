package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//page object class has having constructors,elements,action methods.


public class loginpage {
	
	@FindBy(xpath="//input[@name=\"username\"]")
	WebElement textusername;
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement textpassword;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement login;
	public loginpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void logindetalis(String name,String paswd) throws Throwable {
		Thread.sleep(3000);
		textusername.sendKeys(name);
		textpassword.sendKeys(paswd);
	}
	public void enterorangehrmdasbord() {	
		login.click();
	}
	
	
	}


	


