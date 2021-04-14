package StepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import PojoClasses.forgotPasswordInputParams;
import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class forgotPassword extends Utils{
	RequestSpecification requestSpec;
	Response response;
	static String forgotpasswordResponse;

	@Given("^The users email address$")
	public void the_users_email_address() throws Throwable {

		forgotPasswordInputParams forgotPwd = new forgotPasswordInputParams();
		forgotPwd.setEmail("test@test.com");
				
		requestSpec = given().spec(requestSpecification())
				.body(forgotPwd);
	}

	@When("^The user calls ForgotPassword method with post HTTP method$")
	public void the_user_calls_ForgotPassword_method_with_post_HTTP_method() throws Throwable {
		response = requestSpec.when().post("webapp/careteamAppV1/forgotPassword").then().spec(responseSpecification()).extract().response();

	}

	@Then("^The status code should return (\\d+) and the response should contain the status as (\\d+)$")
	public void the_status_code_should_return_and_the_response_should_contain_the_status_as(int arg1, int arg2) throws Throwable {
		forgotpasswordResponse = response.asString();

		JsonPath js = new JsonPath(forgotpasswordResponse);
		String message = js.getString("message");

		Assert.assertEquals("Your new password has been sent to your mail. Please check your email.", message);
		System.out.println("The forgot password response is :" + forgotpasswordResponse);

	}

}
