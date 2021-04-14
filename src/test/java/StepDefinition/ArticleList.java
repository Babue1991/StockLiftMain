package StepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class ArticleList extends Utils {
	RequestSpecification requestSpec;
	Response response;
	String typeView;
	String articleList;
	int post_id;
	static int articleCategory_id = articleTypeCreation.articleCategory_id;
	
	@Given("^The user auth token as an input header$")
	public void the_user_auth_token_as_an_input_header() throws Throwable {
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

	@When("^The user calls with GET http method to get article list$")
	public void the_user_calls_with_GET_http_method_to_get_article_list() throws Throwable {
		response = requestSpec.when().log().all().post("api/article").then().log().all().spec(responseSpecification()).extract().response();
	}

	@Then("^The user should receive Article list! as an message\\.$")
	public void the_user_should_receive_Article_list_as_an_message() throws Throwable {
		articleList = response.asString();

		JsonPath js = new JsonPath(articleList);
		String message = js.getString("message");
		post_id = js.getInt("data.article.id");

		Assert.assertEquals("Post created successfully.", message);
		System.out.println("The post creation response value is : " + articleList);
	}
}
