package CucumberOptions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/java/features", tags =  "@StockLiftLogin, @PostCreation" ,
//"@StockLiftLogin, @CategoryCreate, @SignUp, @ArticleTypeManagement, @PostCreation, @zoomCallInitiate, @EditProfile, @myProfile, @ChangePassword, @CallDetailsEntry, @AboutUs,  @Forgotpassword,  @MailRepot",  
glue =  { "StepDefinition" }, 
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
monochrome = true
		)
public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("Config/report.xml"));

	}

}

/*
 * Implemented dynamic input method to initiate zoom call. 
 * Implemented getters and setters method for zoom call API.
 */
