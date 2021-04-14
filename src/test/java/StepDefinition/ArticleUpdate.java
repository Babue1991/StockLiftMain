package StepDefinition;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class ArticleUpdate extends Utils {
	RequestSpecification requestSpec;
	Response response;
	String CatUpdate;
	String catCreation;
	int Category_ID = articleCategoryCreation.articleCategory_id;
	
	
	@Given("^The user ID and name as an input payload$")
	public void the_user_ID_and_name_as_an_input_payload() throws Throwable {
	
		requestSpec = given().spec(requestSpecification()).body("{\r\n"
				+ "\"name\":\"New one updated\"\r\n"
				+ "}");
		
	}

	@When("^The user calls  with  PUT HTTP method to update a category$")
	public void the_user_calls_with_PUT_HTTP_method_to_update_a_category() throws Throwable {
		response = requestSpec.when().put("api/article_category/"+Category_ID).then().spec(responseSpecification()).extract().response();
	}

	@Then("^The success message should be true and the message is eqal to Article category updated successfully\\.$")
	public void the_success_message_should_be_true_and_the_message_is_eqal_to_Article_category_updated_successfully() throws Throwable {
		CatUpdate = response.asString();

		JsonPath js = new JsonPath(CatUpdate);
		String message = js.getString("message");
//		articleCategory_id = js.getInt("data.article_category.id");
		
		Assert.assertEquals("Article category updated successfully.", message);
		System.out.println("The zoom call details API response value is : " + catCreation);
		
	}

}
