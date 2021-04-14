package StepDefinition;

import static cucumber.api.java.en.Given.*;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class articleTypeView extends Utils {
	RequestSpecification requestSpec;
	Response response;
	String typeView;
	static int articleCategory_id = articleTypeCreation.articleCategory_id;
	
	@Given("^The access token value as input param$")
	public void the_access_token_value_as_input_param() throws Throwable {
		requestSpec = given().log().all().spec(requestSpecification());
		
	}

	@When("^The user calls GET http method to get article type list$")
	public void the_user_calls_GET_http_method_to_get_article_type_list() throws Throwable {
		response = requestSpec.when().log().all().get("api/article_type/"+articleCategory_id).then().log().all().spec(responseSpecification()).extract().response();
	}

	@Then("^The user should receive Single article type!\\. message in response\\.$")
	public void the_user_should_receive_Single_article_type_message_in_response() throws Throwable {
		typeView = response.asString();

		JsonPath js = new JsonPath(typeView);
		String message = js.getString("message");
		articleCategory_id = js.getInt("data.article_type.id");

		Assert.assertEquals("Single article type!.", message);
		System.out.println("The article type view response value is : " + typeView);
	}
}
