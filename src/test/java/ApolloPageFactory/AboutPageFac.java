package ApolloPageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ApolloDriverSetup.Login;



public class AboutPageFac {
	
	WebDriver driver;
	Login log;
	String parentWindowHandle;
	JavascriptExecutor js;
	Robot r;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

	
	//---------------------- Methods for background --------------------------------------
	
	public AboutPageFac(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void windowHandle() {
		parentWindowHandle = driver.getWindowHandle();
 
		Set<String> allWindowHandles = driver.getWindowHandles();
 
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				
			}
		}
	}
	
	//--------------------- WebElements for callback -------------------------------
	
	@FindBy(xpath="//a[@title=\"Health Queries\"]") 
	WebElement healthqueries;
	@FindBy(xpath="//div[@class=\"WhyApollo_root__1uoLJ\"]//div[@class=\"AskApolloCta_callApolloNew__wQdNb\"]//h4") 
	WebElement callback;
	@FindBy(xpath="//input[@maxlength=\"20\"]") 
	WebElement pname;
	@FindBy(xpath="//span[text()=\"SUBMIT\"]") 
	WebElement submitbtn;
	
	
	//--------------------- Methods for callback -------------------------------
	
	public void healthqueries() 
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3000)");
		wait.until(ExpectedConditions.elementToBeClickable(healthqueries));
		healthqueries.click();
		windowHandle();
	}
	
	public void reqcallback()  
	{
        wait.until(ExpectedConditions.elementToBeClickable(callback));
		callback.click();
	}
	
	public void pass(String name,String email,String mobile) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(pname));
		pname.sendKeys(name);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).sendKeys(email).build().perform();
		act.sendKeys(Keys.TAB).sendKeys(mobile).build().perform();
	}
	
	public void submit() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(submitbtn));
		submitbtn.click();
	}
	
	public String popup()
	{
		String url = driver.getCurrentUrl();
		System.out.println("Catching the message from url: "+url);
		return url;
	}
	//--------------------- WebElements for comment -------------------------------
	
	@FindBy(xpath="//a[@title=\"Blogs\"]") 
	WebElement blogs;
	@FindBy(xpath="//input[@placeholder=\"Search Articles\"]") 
	WebElement searchbar;
	@FindBy(xpath="//button[@aria-label=\"search product\"]") 
	WebElement searchicon;
	@FindBy(xpath="//input[@placeholder=\"Enter name\"]") 
	WebElement Name;
	@FindBy(xpath="//span[text()=\"post comment\"]") 
	WebElement postbtn;
	@FindBy(xpath="//span[text()=\"1\"]") 
	WebElement comment;
	

	//--------------------- Methods for comment -------------------------------
	
	public void blog() 
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3700)");
		wait.until(ExpectedConditions.elementToBeClickable(blogs));
		blogs.click();
		windowHandle();
	}
	
	public void pass(String article) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchbar));
		searchbar.sendKeys(article);
		wait.until(ExpectedConditions.elementToBeClickable(searchicon));
		searchicon.click();
	}
	

	public void fwd() throws AWTException 
	{
		r = new Robot();
		r.delay(3000);
        r.mouseMove(140, 400); // location of x & y login
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        
	}
	
	public int checkbefore() throws IOException, AWTException
	{
		wait.until(ExpectedConditions.elementToBeClickable(comment));
		String count = comment.getText();
		int finalcount = Integer.parseInt(count);
		System.out.println("BeforePost: "+count);
		return finalcount+1;
	}
	
	public void data() throws IOException, AWTException
	{
		File file = new File ("C:\\Users\\SAKRAVIN\\Desktop\\Apollo_About\\resources\\Excel Data\\Comment.xlsx");
		FileInputStream fis = new FileInputStream(file);

		//create workbook
		
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheetAt(0);
		String name = s.getRow(0).getCell(0).getStringCellValue();
		String mail = s.getRow(0).getCell(1).getStringCellValue();
		String com = s.getRow(0).getCell(2).getStringCellValue();
		
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3500)");
		wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name.sendKeys(name);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).sendKeys(mail).build().perform();
		act.sendKeys(Keys.TAB).sendKeys(com).build().perform();		
		
	}
	
	public void post()
	{
		wait.until(ExpectedConditions.elementToBeClickable(postbtn));
		postbtn.click();
	}
	
	public int checkafter() throws IOException, AWTException
	{

		wait.until(ExpectedConditions.elementToBeClickable(comment));
		String count = comment.getText();
		int finalcount = Integer.parseInt(count);
		System.out.println("AfterPost: "+count);
		return finalcount;
	}
	
	//--------------------- WebElements for bookdoctor -------------------------------
	
	@FindBy(xpath="//a[@title=\"Hospitals And Clinics\"]") 
	WebElement hospitals;
	@FindBy(xpath="//span[text()=\"apollo clinics\"]/following-sibling::span") 
	WebElement type;
	@FindBy(xpath="//span[text()=\"delhi\"]/following-sibling::span") 
	WebElement location;
	@FindBy(xpath="//div[@class=\"jss99\"]/ul/div[text()=\"Clinical Psychology\"]") 
	WebElement specialities;
	//p[@title="Specialty"]
	@FindBy(xpath="//p[@title=\"Specialty\"]") 
	WebElement doctor;
	
	//--------------------- Methods for bookdoctor -------------------------------
	
	
	public void hospitals()
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3500)");
		wait.until(ExpectedConditions.elementToBeClickable(hospitals));
		hospitals.click();
		windowHandle();
	}
	
	public void filters()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(type));
		type.click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(location));
		location.click();
		//type.click();
	}
	
	public void details() throws AWTException 
	{
		
        r = new Robot();
        r.delay(3000);
        r.mouseMove(450, 550); // location of x & y login
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public void choose()  
	{
		wait.until(ExpectedConditions.elementToBeClickable(specialities));
		specialities.click();
	}
	
	public String doctorinfo()
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.elementToBeClickable(doctor));
		String speciality = doctor.getText();
		System.out.println("Spcialist in: "+speciality);
		return speciality;
		
	}
	
	//--------------------- WebElements for location -------------------------------
	
	@FindBy(xpath="//a[@title=\"Diagnostics Centres\"]") 
	WebElement centres;
	@FindBy(id="ddlState") 
	WebElement dropdown1;
	@FindBy(xpath="//li[@stateurl=\"maharashtra\"]") 
	WebElement state;
	@FindBy(id="ddlCity") 
	WebElement dropdown2;
	@FindBy(xpath="//li[@cityurl=\"thane\"]") 
	WebElement city;
	@FindBy(id="ddlAreaname") 
	WebElement dropdown3;
	@FindBy(xpath="//li[@areanameurl=\"sector-2-thane\"]") 
	WebElement area;
	@FindBy(xpath="//a[@class=\"sk-button sk-primary-outline\"]") 
	WebElement website;
	@FindBy(xpath="//button[@title=\"Get Direction of Apollo 247 Diagnostics in Sector 2- Thane, Thane\"]") 
	WebElement map;
	@FindBy(id="slick-slide01") 
	WebElement test;
	
	//--------------------- Methods for location -------------------------------
	
	public void centres()
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3500)");
		wait.until(ExpectedConditions.elementToBeClickable(centres));
		centres.click();
		windowHandle();
	}
	
	public void location() throws AWTException
	{
		Robot r = new Robot();
		r.delay(3000);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown1));
		dropdown1.click();
		wait.until(ExpectedConditions.elementToBeClickable(state));
		state.click();
		r.delay(2000);
		dropdown2.click();
		wait.until(ExpectedConditions.elementToBeClickable(city));
		city.click();
		r.delay(2000);
		dropdown3.click();
		wait.until(ExpectedConditions.elementToBeClickable(area));
		area.click();
		
	}
	
	public void website() throws AWTException
	{
		Robot r = new Robot();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)"); 
		r.delay(2000);
		wait.until(ExpectedConditions.elementToBeClickable(website));
        website.click();
	}
	
	public void direction() throws AWTException 
	{
		Robot r = new Robot();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		r.delay(2000);
		wait.until(ExpectedConditions.elementToBeClickable(map));
		map.click();
		windowHandle();
		
	}
	
	public void book() throws AWTException 
	{
		Robot r = new Robot();
		driver.switchTo().window(parentWindowHandle);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		r.delay(2000);
		js.executeScript("window.scrollBy(0,-500)");
        r.delay(3000);
//        wait.until(ExpectedConditions.elementToBeClickable(test));
//        test.click();
        r.mouseMove(230, 330); // location of x & y login
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        r.delay(1000);
	}
	
	public String confirm()
	{
		String url = driver.getCurrentUrl();
		System.out.println("Navigating to url: "+url);
		return url;
		
	}
	
//--------------------- WebElements for calories -------------------------------
	
	@FindBy(xpath="//a[@href=\"https://www.apollo247.com/blog/health-tools\"]") 
	WebElement healthtools;
	@FindBy(xpath="//input[@type=\"number\"]") 
	WebElement num;
	@FindBy(xpath="//span[@class=\"calories-required_icon-ic_arrow_right__Milxp\"]") 
	WebElement fwd;
	@FindBy(xpath="//span[text()=\"Female\"]") 
	WebElement gender;
	@FindBy(xpath="//div[@aria-haspopup=\"listbox\"]") 
	WebElement listbox;
	@FindBy(xpath="//li[@data-value=\"cm\"]") 
	WebElement fac;
	@FindBy(xpath="//span[text()=\"Active\"]") 
	WebElement level;
	@FindBy(xpath="//span[text()=\"CALCULATE\"]")	
	WebElement calbtn;
	@FindBy(xpath="//p[text()=\"Estimate calories spent on common activities\"]")	
	WebElement content;
	@FindBy(xpath="//div[@class=\"calories-result_imgContainer__L72sP\"]//h1")	
	WebElement result;
	
	//--------------------- Methods for calories -------------------------------
	

	public void login() throws AWTException, InterruptedException
	{
		log = new Login(driver);
		log.signin();
	}
	
	public void healthtools() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		wait.until(ExpectedConditions.elementToBeClickable(healthtools));
		healthtools.click();
		windowHandle();
	}
	
	public void calculate() throws AWTException
	{
        Robot r = new Robot();
        r.delay(2000);
        r.mouseMove(680, 530); // location of x & y login
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        
	}
	
	public void reqdata() throws IOException
	{
		
		File file = new File ("C:\\Users\\SAKRAVIN\\Desktop\\Apollo_About\\resources\\Excel Data\\calories.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheetAt(0);
		
		
		Number age=s.getRow(1).getCell(0).getNumericCellValue();
		Number height=s.getRow(1).getCell(1).getNumericCellValue();
		Number weight=s.getRow(1).getCell(2).getNumericCellValue();
	    String years = String.valueOf(age);
	    String cm = String.valueOf(height);
	    String kg = String.valueOf(weight);
	    JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		wait.until(ExpectedConditions.elementToBeClickable(num));
	    num.sendKeys(years);
	    wait.until(ExpectedConditions.elementToBeClickable(fwd));
	    fwd.click();
	    wait.until(ExpectedConditions.elementToBeClickable(gender));
	    gender.click();
	    wait.until(ExpectedConditions.elementToBeClickable(fwd));
	    fwd.click();
	    wait.until(ExpectedConditions.elementToBeClickable(num));
	    num.sendKeys(cm);
	    wait.until(ExpectedConditions.elementToBeClickable(listbox));
	    listbox.click();
	    wait.until(ExpectedConditions.elementToBeClickable(fac));
	    fac.click();
	    wait.until(ExpectedConditions.elementToBeClickable(fwd));
	    fwd.click();
	    wait.until(ExpectedConditions.elementToBeClickable(num));
	    num.sendKeys(kg);
	    wait.until(ExpectedConditions.elementToBeClickable(fwd));
	    fwd.click();
	    js.executeScript("window.scrollBy(0,200)");
	    level.click();

	}
	
	public void calculatecal()
	{
		wait.until(ExpectedConditions.elementToBeClickable(calbtn));
		calbtn.click();
	}
	
	public String verify()
	{
		wait.until(ExpectedConditions.elementToBeClickable(content));
		String res = content.getText();
		wait.until(ExpectedConditions.elementToBeClickable(result));
		String cal = result.getText();
		System.out.println("Result:"+cal);
		return res;
		
	}
	
}
