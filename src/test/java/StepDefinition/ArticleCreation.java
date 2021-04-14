package StepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class ArticleCreation extends Utils{
	RequestSpecification requestSpec;
	Response response;
	String articleCreation;
	static int article_id;
	
	@Given("^The json input payload for article creation$")
	public void the_json_input_payload_for_article_creation() throws Throwable {
		requestSpec = given().log().all().spec(requestSpecification())
				.body("{\r\n"
						+ "	\"title\":\"New post march 16 article\",\r\n"
						+ "	\"link\":\"https://google.com\",\r\n"
						+ "	\"summary\":\"Article Summary\",\r\n"
						+ "	\"author\":\"Article Author\",\r\n"
						+ "	\"content\":\"Article Content\",\r\n"
						+ "	\"image\":\"Article Image\",\r\n"
						+ "	\"article_type_id\":2,\r\n"
						+ "	\"article_categories_id\":[1,2,3],\r\n"
						+ "    \"user_mentioned_id\":[2, 3]\r\n"
						+ "}\r\n"
						+ "");   
	}

	@When("^The user sends post http method to create article$")
	public void the_user_sends_post_http_method_to_create_article() throws Throwable {
		response = requestSpec.when().log().all().post("api/article").then().log().all().spec(responseSpecification()).extract().response();
	}

	@Then("^The user should get \"([^\"]*)\" message$")
	public void the_user_should_get_message(String arg1) throws Throwable {
		articleCreation = response.asString();

		JsonPath js = new JsonPath(articleCreation);
		String message = js.getString("message");
		article_id = js.getInt("data.article.id");

		Assert.assertEquals("Article created successfully.", message);
		System.out.println("The article creation response value is : " + articleCreation);

		
	}


}
