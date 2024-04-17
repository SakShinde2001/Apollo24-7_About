package ApolloDriverSetup;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	BaseSteps bs;
	@FindBy(id="loginPopup")
	WebElement profile;
	@FindBy(xpath="//input[@name=\"mobileNumber\"]")
	WebElement num;
	@FindBy(xpath="//button[text()=\"Verify\"]")
	WebElement verify;
	
	public Login(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void signin() throws AWTException, InterruptedException
	{
		profile.click();
		Thread.sleep(1000);
		num.clear();
		num.sendKeys("8369749585");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(15000);
		verify.click();
		
	}

}
