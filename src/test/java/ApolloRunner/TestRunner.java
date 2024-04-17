package ApolloRunner;
 
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
// io.cucumber.testng.CucumberOptions; - to run through testng, change the runner file type into xml
 
@RunWith(Cucumber.class)
@CucumberOptions(features = "resources\\Features\\Callback.feature", // we can just run till features folder
		glue = "ApolloStepDefinition",// package name for test file
tags="@runall", 
plugin = {"pretty","html:target/HTMLReports/ApolloReport.html",  // pretty -getting feature file girkin code on console})
		"json:target/JSON Reports/ApolloReport.json",
		"junit:target/JUNITReports/ApolloReport.xml", // generating reports 
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
 
//)
public class TestRunner extends AbstractTestNGCucumberTests {
 
}