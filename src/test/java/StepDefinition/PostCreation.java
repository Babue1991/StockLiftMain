package StepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class PostCreation extends Utils{

	RequestSpecification requestSpec;
	Response response;
	String postCreation;
	static int post_id;
	@Given("^The json input payload for post creation$")
	public void the_json_input_payload_for_post_creation() throws Throwable {
	
		requestSpec = given().log().all().spec(requestSpecification())
				.body("{\r\n"
						+ "	\"title\":\"New post march 16 article\",\r\n"
						+ "	\"link\":\"https://google.com\",\r\n"
						+ "	\"summary\":\"Article Summary\",\r\n"
						+ "	\"author\":\"Article Author\",\r\n"
						+ "	\"content\":\"Article Content\",\r\n"
						+ "	\"image\":\"Article Image\",\r\n"
						+ "	\"article_type_id\":1,\r\n"
						+ "	\"article_categories_id\":[1,2,3],\r\n"
						+ "    \"user_mentioned_id\":[2, 3]\r\n"
						+ "}\r\n"
						+ "");
	}

	@When("^The user calls post HTTP method to create a new post$")
	public void the_user_calls_post_HTTP_method_to_create_a_new_post() throws Throwable {
		response = requestSpec.when().log().all().post("api/article").then().log().all().spec(responseSpecification()).extract().response();
	}

	@Then("^The post should be created successfuly$")
	public void the_post_should_be_created_successfuly() throws Throwable {
		postCreation = response.asString();

		JsonPath js = new JsonPath(postCreation);
		String message = js.getString("message");
		post_id = js.getInt("data.article.id");

		Assert.assertEquals("Post created successfully.", message);
		System.out.println("The post creation response value is : " + postCreation);

	}

}
