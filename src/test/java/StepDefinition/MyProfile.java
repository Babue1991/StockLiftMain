package StepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class MyProfile extends Utils{
	static String dayViewResponse;
	RequestSpecification requestSpec;
	Response response;
	String myProfileResponse;
	String FirstName;

	@Given("^The  user access token as an header value$")
	public void the_user_access_token_as_an_header_value() throws Throwable {
	    
		requestSpec = given().spec(requestSpecification());
	}
	
	@When("^The user calls  with  GET HTTP method to get user profile data$")
	public void the_user_calls_with_GET_HTTP_method_to_get_user_profile_data() throws Throwable {
	 
	  response = requestSpec.when().post("webapp/careteamAppV1/myprofile").then().spec(responseSpecification()).extract().response();
	 
	 }

	@Then("^The message should be success and the my profile API response status code value should be \"([^\"]*)\"$")
	public void the_message_should_be_success_and_the_my_profile_API_response_status_code_value_should_be(String arg1) throws Throwable {
		myProfileResponse = response.asString();

		JsonPath js = new JsonPath(myProfileResponse);
		String message = js.getString("message");
		String FirstName = js.getString("profile_fname");

		Assert.assertEquals("success", message);
		System.out.println("The my Profile API response value is : " + myProfileResponse);
		System.out.println("The users first name value is " +FirstName);
	}


}
