package StepDefinition;

import cucumber.api.java.en.*;
import resources.SendMail;

public class MailCompose extends SendMail {
	String  to[]= { "babu@farshore.com", "babufsp4@gmail.com", "mohannagarajan@farshore.com" };
	
	@Given("^Extense report file$")
	public void extense_report_file() throws Throwable {
	//	String  to[]= { "babu@farshore.com", "babufsp4@gmail.com" };

	}

	@When("^The script execution is over$")
	public void the_script_execution_is_over() throws Throwable {
	
	}

	@Then("^Send a mail to all recipients$")
	public void send_a_mail_to_all_recipients() throws Throwable {
	    SendMail.send("babufsp1@gmail.com", to, "Acacia Care Team APP Rest assured API Automation Test Report", "Please check the PDF attachment.");

	}
}
