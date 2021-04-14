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

public class articleTyeList extends Utils {
	
	RequestSpecification requestSpec;
	Response response;
	String typeList;
	@Given("^The user sends article type ID in URL$")
	public void the_user_sends_article_type_ID_in_URL() throws Throwable {
	
		requestSpec = given().log().all().spec(requestSpecification());
	}

	@When("^The user calls GET http method to get article type view$")
	public void the_user_calls_GET_http_method_to_get_article_type_view() throws Throwable {
		response = requestSpec.when().log().all().get("api/article_type").then().log().all().spec(responseSpecification()).extract().response();

	}

	@Then("^The user should receive \"([^\"]*)\" message in response\\.$")
	public void the_user_should_receive_message_in_response(String arg1) throws Throwable {
		typeList = response.asString();

		JsonPath js = new JsonPath(typeList);
		String message = js.getString("message");

		Assert.assertEquals(arg1, message);
		System.out.println("The type creation response value is : " + typeList);
	}
}
