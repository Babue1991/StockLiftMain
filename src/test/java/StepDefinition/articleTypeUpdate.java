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

public class articleTypeUpdate extends Utils {
	RequestSpecification requestSpec;
	Response response;
	String typeUpdate;
	int article_ID = articleTypeCreation.articleCategory_id;
	
	   @Given("^The article name and article ID as an input param$")
	    public void the_article_name_and_article_id_as_an_input_param() throws Throwable {
	
		requestSpec = given().log().all().spec(requestSpecification())
				.body("{\r\n"
						+ "\"name\":\"Babu's new update\"\r\n"
						+ "}\r\n"
						+ "");
	}

	    @When("^The user calls PUT http method to update article type list$")
	    public void the_user_calls_put_http_method_to_update_article_type_list() throws Throwable {
		response = requestSpec.when().log().all().put("api/article_type/"+article_ID).then().log().all().spec(responseSpecification()).extract().response();

	}


	    @Then("^The user should receive Article type updated successfully message in response\\.$")
	    public void the_user_should_receive_Article_type_updated_successfully_message_in_response() throws Throwable {
		typeUpdate = response.asString();

		JsonPath js = new JsonPath(typeUpdate);
		String message = js.getString("message");

		Assert.assertEquals("Article type updated successfully.", message);
		System.out.println("The article type updated response value is : " + typeUpdate);
	}
}
