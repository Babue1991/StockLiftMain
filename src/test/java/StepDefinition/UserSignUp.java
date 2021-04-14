package StepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import PojoClasses.SignUpInputParams;
import cucumber.api.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Utils;

public class UserSignUp extends Utils{
	RequestSpecification request;
	ResponseSpecification rsp;

	Response response;
	String signUpResponse;
	RequestSpecification res;
	int i =1;



	@Given("^The user information as input payload$")
	public void the_user_information_as_input_payload() throws Throwable {
		request = new RequestSpecBuilder().setBaseUri("http://www.stocklift.net.farshore.net")
				//		 .addHeader("Authorization","ZGV2OmU1enZmYjg0")
				.setContentType(ContentType.JSON).build();

		SignUpInputParams SignUp = new SignUpInputParams();
		SignUp.setFirst_name("Babu");
		SignUp.setLast_name("Eaga");
		SignUp.setEmail("test21@mail.com");
		SignUp.setPassword("Test@123");
		SignUp.setC_password("Test@123");
		SignUp.setCompany("FSP");
		SignUp.setCity("Madurai");
		SignUp.setState("Tamilnadu");
		SignUp.setCountry("India");
		SignUp.setProfile_image("Image");
		SignUp.setAccount_type_id(1);

		res = given().log().all().spec(request).auth().basic("dev", "e5zvfb84")
				.body(SignUp);
		rsp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	}

	@When("^The user calls post HTTP method to create new user$")
	public void the_user_calls_post_HTTP_method_to_create_new_user() throws Throwable {
		response = res.when().log().all().post("api/register").then().log().all().spec(rsp).extract().response();
		//	response = res.when().log().all().post("api/login").then().spec(rsp).extract().response();


	}

	@Then("^The status code should return (\\d+) and response should contain Thank you message\\.$")
	public void the_status_code_should_return_and_response_should_contain_Thank_you_message(int arg1) throws Throwable {
		signUpResponse = response.asString();
		System.out.println("The signup response is " +signUpResponse);
		JsonPath js = new JsonPath(signUpResponse);
		String message = js.getString("message");

		Assert.assertEquals("Account confirmation link sent to your registered email.", message);
		System.out.println("The Sign up API response is : " + signUpResponse);

	}
}
