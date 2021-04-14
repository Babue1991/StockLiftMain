package StepDefinition;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import resources.Utils;
import static io.restassured.RestAssured.given;


public class Article_List extends Utils{
	RequestSpecification resquestSpec;
	Response response;

	@Given("^The access token value of users as an header value$")
	public void the_access_token_value_of_users_as_an_header_value() throws Throwable {

		resquestSpec = given().spec(requestSpecification());
	}

	@When("^The user calls  with  GET HTTP method to list a category$")
	public void the_user_calls_with_GET_HTTP_method_to_list_a_category() throws Throwable {
		response =  resquestSpec.when().get("api/article_category").then().log().all().spec(responseSpecification()).extract().response();
	}

	@Then("^The success message should be true and the message is eqal to \"([^\"]*)\"$")
	public void the_success_message_should_be_true_and_the_message_is_eqal_to(String rsp) throws Throwable {
		String articleList = response.asString();
		JsonPath js = new JsonPath(articleList);
		String message = js.getString("message");
		Assert.assertEquals(rsp, message);

		System.out.println("The article list response value is"+articleList);

	}
}
