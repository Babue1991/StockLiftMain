package StepDefinition;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
//import cucumber.api.java.en.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.*;


import org.testng.Assert;

import PojoClasses.loginInputParams;


public class appLogin {
	static String loginResponse;
	static String token;
	static JsonPath js1;
	RequestSpecification res;
	ResponseSpecification rsp;
	RequestSpecification request;
	static String expectedResponse;
	Response response;
	public static String access_token;
	String token1;
	String actualResponse;
	
	@Given("^The login input payload with \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_login_input_payload_with(String email, String password) throws Throwable {
		
	 request = new RequestSpecBuilder().setBaseUri("http://www.stocklift.net.farshore.net")
	//		 .addHeader("Authorization","ZGV2OmU1enZmYjg0")
			.setContentType(ContentType.JSON).build();
		
	 
		 loginInputParams loginInput = new loginInputParams();
		 loginInput.setEmail(email);
		 System.out.println("The username value is "+ email +  " and Password is  "+password);
		 loginInput.setPassword(password);
		 
		 res = given().log().all().spec(request).auth().basic("dev", "e5zvfb84")
				 .body(loginInput);
	
		rsp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
	}


@When("^The user calls  with  HTTP method$")
public void the_user_calls_with_HTTP_method() throws Throwable {
	
		response = res.when().log().all().post("api/login").then().spec(rsp).extract().response();
		expectedResponse = response.asString();
		System.out.println(expectedResponse);
		
	}

	@Then("^The status message should be success and the response should be 200")
	public void the_status_message_should_be_success_and_the_response_should_be() throws Throwable {
		JsonPath js = new JsonPath(expectedResponse);
		String s = js.getString("data.access_token");
		
		System.out.println("The name value is" +s);
		access_token= js.getString("data.access_token");
		actualResponse = js.getString("message");
		System.out.println(access_token);
		System.out.println(actualResponse);
	
		System.out.println("Login API response : " + access_token );
		Assert.assertEquals(actualResponse, "User login successfully.");
	}


}
