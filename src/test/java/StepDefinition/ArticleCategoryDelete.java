package StepDefinition;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class ArticleCategoryDelete extends Utils {
	static String dayViewResponse;
	RequestSpecification requestSpec;
	Response response;
	String artCategoryDelete;
	int category_ID = articleCategoryCreation.articleCategory_id;
	
	@Given("^The  Category ID as an input Json payload$")
	public void the_Category_ID_as_an_input_Json_payload() throws Throwable {
		
		requestSpec = given().spec(requestSpecification()).body(category_ID);
	}

	@When("^The user calls  with  DELETE HTTP method to delete a category$")
	public void the_user_calls_with_POST_HTTP_method_to_delete_a_category() throws Throwable {
		  response = requestSpec.when().delete("api/article_category/"+category_ID).then().log().all()
				  .spec(responseSpecification()).extract().response();
	}

	@Then("^The success message should be true and the message is eqal to Article category deleted successfully\\.$")
	public void the_success_message_should_be_true_and_the_message_is_eqal_to_Article_category_deleted_successfully() throws Throwable {
		artCategoryDelete = response.asString();

		JsonPath js = new JsonPath(artCategoryDelete);
		String message = js.getString("message");

		Assert.assertEquals("Article category deleted successfully.", message);
		System.out.println("The zoom call details API response value is : " + artCategoryDelete);
	}

}
