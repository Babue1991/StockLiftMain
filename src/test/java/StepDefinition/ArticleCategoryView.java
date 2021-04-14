package StepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class ArticleCategoryView extends Utils {
	
	static String dayViewResponse;
	RequestSpecification requestSpec;
	Response response;
	String artViewResponse;

	int category_ID = articleCategoryCreation.articleCategory_id;

	@Given("^The \"([^\"]*)\" as an URL input$")
	public void the_as_an_URL_input(String arg1) throws Throwable {
		requestSpec = given().spec(requestSpecification());
	}

	@When("^The user calls  with  GET HTTP method to view a category$")
	public void the_user_calls_with_POST_HTTP_method_to_view_a_category() throws Throwable {
		  response = requestSpec.when().log().all().get("api/article_category/"+category_ID).then().spec(
				  responseSpecification()).extract().response();
	}

	@Then("^The success message should be true and the message is eqal to Single article category!\\.$")
	public void the_success_message_should_be_true_and_the_message_is_eqal_to_Single_article_category() throws Throwable {
		artViewResponse = response.asString();

		JsonPath js = new JsonPath(artViewResponse);
		String message = js.getString("message");

		Assert.assertEquals("Single article category!.", message);
		System.out.println("The article details API response value is : " + artViewResponse);
	}

}
