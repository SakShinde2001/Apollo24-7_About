package ApolloDriverSetup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
	
	public static WebDriver driver;
	public static ChromeOptions chrome;
	public static EdgeOptions edge;
	
	
	public static WebDriver chromedriver()
	{
		
		WebDriverManager.chromedriver().setup();
		chrome = new ChromeOptions();
		chrome.addArguments("start-maximized"); 
		chrome.addArguments("disable-notifications");
	    chrome.addArguments("disable-popup-blocking");
	    driver = new ChromeDriver(chrome);
	    driver.get("https://www.apollo247.com/");
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
	}
	
	public static WebDriver edgedriver()
	{
		
		WebDriverManager.edgedriver().setup();
		edge = new EdgeOptions();
		edge.addArguments("start-maximized"); 
		edge.addArguments("disable-notifications");
	    edge.addArguments("disable-popup-blocking");
	    driver = new EdgeDriver(edge);
	    driver.get("https://www.apollo247.com/");
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
	}

	
	
}
