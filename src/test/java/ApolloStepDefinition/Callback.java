package ApolloStepDefinition;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ApolloDriverSetup.BaseSteps;
import ApolloDriverSetup.Login;
import ApolloPageFactory.AboutPageFac;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Callback {

	static WebDriver driver;
	BaseSteps bs;
	Login log;
	AboutPageFac about;
	
//----------------------------HomePage----------------------------------------------------
	/*
	 * Created By: Sakshi Shinde 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a mandatory step to start all scenarios
	 */
	
	@Given("User is on Apollo homepage")
	public void user_is_on_apollo_homepage() throws AWTException, InterruptedException {
		driver = BaseSteps.chromedriver();
		log = new Login(driver);
		//log.login();
		about = new AboutPageFac(driver);
	}

//------------------------------ callback ------------------------------------------
	/*
	 * Created By: Sakshi Shinde 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a mandatory step to get a notification for the request a callback
	 */
	
	@When("user clicks on health queries option")
	public void user_clicks_on_health_queries_option(){
		
		about.healthqueries();
	}

	@When("clicks on Request a callback button")
	public void clicks_on_request_a_callback_button(){
		about.reqcallback();
	}

	@When("enters patient name, email id and mobile number")
	public void enters_patient_name_email_id_and_mobile_number(io.cucumber.datatable.DataTable credentials) throws Exception {
		List<List<String>> cells = credentials.cells();
		about.pass(cells.get(0).get(0), cells.get(0).get(1), cells.get(0).get(2));
	    
	}

	@When("clicks on sumbit button")
	public void clicks_on_sumbit_button() throws InterruptedException {
		about.submit();
	}

	@Then("it should give the success message")
	public void it_should_give_the_success_message() {
		String actual = about.popup();
		Assert.assertTrue(actual.contains("health-queries"));
	}


	//------------------------------ comment ------------------------------------------
	
	/*
	 * Created By: Sakshi Shinde 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a mandatory step to increase the count of comment after posting comment
	 */
	
	@When("user clicks on blogs option")
	public void user_clicks_on_blogs_option(){
		about.blog();
	}

	@When("searches any article")
	public void searches_any_article(io.cucumber.datatable.DataTable credentials) {
		List<List<String>> cells = credentials.cells();
		about.pass(cells.get(0).get(0));
		
	}

	@When("choose any option from the suggested articles")
	public void choose_any_option_from_the_suggested_articles() throws AWTException {
		about.fwd();
	    
	}

	@When("post a comment on the article using credentials")
	public void post_a_comment_on_the_article_using_credentials() throws IOException, AWTException{
		about.checkbefore();
		about.data();
	}

	@When("submit the comment")
	public void submit_the_comment() throws InterruptedException, IOException, AWTException {
		about.post();
		about.checkafter();
	}

	@Then("it should increase the count")
	public void it_should_increase_the_count() throws IOException, AWTException {
		int expected = about.checkbefore();
		int actual= about.checkafter();
	    Assert.assertEquals(expected,actual);
	}

	//------------------------------ bookdoctor ------------------------------------------
	
	/*
	 * Created By: Sakshi Shinde 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a mandatory step to get a doctor detail 
	 */

	@When("user clicks on hospitals and clinics option")
	public void user_clicks_on_hospitals_and_clinics_option() throws InterruptedException {
		about.hospitals();
	}

	@When("chooses filters for type and location")
	public void chooses_filters_for_type_and_location() throws InterruptedException {
	    about.filters();
	}

	@When("clicks on view details for any option from the list")
	public void clicks_on_view_details_for_any_option_from_the_list() throws AWTException {
	    about.details();
	}

	@When("chooses any of the specialty")
	public void chooses_any_of_the_specialty() throws InterruptedException {
	   about.choose();
	}

	@Then("it should show the list of speciality doctors")
	public void it_should_show_the_list_of_speciality_doctors() {
		String expected = "CLINICAL PSYCHOLOGIST";
		String actual= about.doctorinfo();
		Assert.assertEquals(expected,actual);
	}


	//------------------------------ location ------------------------------------------
	
	/*
	 * Created By: Sakshi Shinde 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a mandatory step to navigate to booking function after choosing location
	 */
	
	@When("user clicks on diagnostics centre option")
	public void user_clicks_on_diagnostics_centre_option() throws InterruptedException {
	    about.centres();
	}

	@When("chooses dropdowns of location")
	public void chooses_dropdowns_of_location() throws AWTException {
	    about.location();
	}

	@When("clicks on website of the result location")
	public void clicks_on_website_of_the_result_location() throws AWTException{
	    about.website();
	}

	@When("get the direction of the location")
	public void get_the_direction_of_the_location() throws AWTException{
	   about.direction();
	}

	@When("click on book now")
	public void click_on_book_now() throws AWTException{
	   about.book();
	}

	@Then("it should redirect to the book function")
	public void it_should_redirect_to_the_book_function() {
		String actual = about.confirm();
		Assert.assertTrue(actual.contains("lab-tests"));
		
	}

 //------------------------------ calories ------------------------------------------
	
	/*
	 * Created By: Sakshi Shinde 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a mandatory step to get the result of calories burnt
	 */
	
	@When("user clicks on Blogs option")
	public void user_clicks_on_Blogs_option() throws InterruptedException, AWTException {
		
		about.login();
		about.blog();
	}

	@When("clicks on Health tools option")
	public void clicks_on_health_tools_option() throws InterruptedException {
	    about.healthtools();
	}

	@When("clicks on calculate calories button")
	public void clicks_on_calculate_calories_button() throws AWTException, InterruptedException {
		about.calculate();
	}

	@When("enters age, gender, height, weight, activity level")
	public void enters_age_gender_height_weight_activity_level() throws IOException, InterruptedException {
	    about.reqdata();
	}

	@When("clicks on calculate button")
	public void clicks_on_calculate_button() {
	    about.calculatecal();
	}

	@Then("it should give the result")
	public void it_should_give_the_result() {
		String expected = "Estimate calories spent on common activities";
		String actual = about.verify();
	    Assert.assertEquals(expected,actual);
	}

	//------------------------------ screenshots ------------------------------------------
	
	@AfterStep // after each step
	public static void Closedown(Scenario scenario)
	{
			TakesScreenshot ts = (TakesScreenshot)driver;
			final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src,"image/png", scenario.getName());
			
	}

}
