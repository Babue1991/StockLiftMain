package StepDefinition;

import cucumber.api.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import PojoClasses.loginInputParams;

public class LoginNegative {
	RequestSpecification request;
	RequestSpecification res;
	ResponseSpecification rspspec;
	Response response;
	String expectedResponse;
	
	@Given("^The invalid login input payload with \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_invalid_login_input_payload_with(String email, String password) throws Throwable {
	   RequestSpecification request = new RequestSpecBuilder().setBaseUri("http://www.stocklift.net.farshore.net")
			   .setContentType(ContentType.JSON).build();
	   
	   loginInputParams loginInput = new loginInputParams();
		 loginInput.setEmail(email);
		 loginInput.setPassword(password);
		 
		 res = given().log().all().spec(request).auth().basic("dev", "e5zvfb84")
			   .body(loginInput);
		 
		 rspspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

	}

	@When("^The user calls  with  POST HTTP method to login$")
	public void the_user_calls_with_POST_HTTP_method_to_login() throws Throwable {

		response = res.when().log().all().post("api/login").then().spec(rspspec).extract().response();

	}

	@Then("^The success message should be false and the response should be \"([^\"]*)\"$")
	public void the_success_message_should_be_false_and_the_response_should_be(String arg1) throws Throwable {
		 expectedResponse = response.asString();

		JsonPath js = new JsonPath(expectedResponse);
		String error = js.getString("data.error");
		System.out.println("The success response value is" +error);
		
		String success = js.getString("success");
		System.out.println(success);
	
		System.out.println("Login API response : " + error );
		Assert.assertEquals(error, "Username or password is incorrect.");
		
	}

}
