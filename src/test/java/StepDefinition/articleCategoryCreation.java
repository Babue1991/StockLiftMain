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

public class articleCategoryCreation extends Utils {
	RequestSpecification requestSpec;
	Response response;
	String catCreation;
	static int articleCategory_id;
	@Given("^The Category name as an input Json payload$")
	public void the_Category_name_as_an_input_Json_payload() throws Throwable {
		String tk = appLogin.access_token;
		String tok = "Bearer"+" "+tk;
		System.out.println("In CC page" +tok);
		requestSpec = given().log().all().spec(requestSpecification())
				.body("{\n"
						+ "\"name\":\"StockLift web\"\n"
						+ "}");
	}

	@When("^The user calls  with  POST HTTP method to create category$")
	public void the_user_calls_with_post_http_method_to_create_category() throws Throwable {

		response = requestSpec.when().log().all().post("api/article_category").then().log().all().spec(responseSpecification()).extract().response();

	}

	@Then("^The status message should be success and the message is eqal to \"([^\"]*)\"$")
	public void the_status_message_should_be_success_and_the_message_is_eqal_to_something(String apiResponse) throws Throwable {
		catCreation = response.asString();

		JsonPath js = new JsonPath(catCreation);
		String message = js.getString("message");
		articleCategory_id = js.getInt("data.article_category.id");

		Assert.assertEquals(apiResponse, message);
		System.out.println("The zoom call details API response value is : " + catCreation);
	}
}
