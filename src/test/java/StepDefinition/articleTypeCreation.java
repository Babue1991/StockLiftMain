package StepDefinition;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class articleTypeCreation extends Utils {
	RequestSpecification requestSpec;
	Response response;
	String typeCreation;
	static int articleCategory_id;
	
	@Given("^The article name as input payload$")
	public void the_article_name_as_input_payload() throws Throwable {
	
		requestSpec = given().log().all().spec(requestSpecification())
				.body("{\n"
						+ "\"name\":\"Babu's Article\"\n"
						+ "}");
	}

	@When("^The user calls POST http method to create article type$")
	public void the_user_calls_POST_http_method_to_create_article_type() throws Throwable {
		response = requestSpec.when().log().all().post("api/article_type").then().log().all().spec(responseSpecification()).extract().response();

	}

	@Then("^The user should receive \"([^\"]*)\" message\\.$")
	public void the_user_should_receive_message(String arg1) throws Throwable {
		typeCreation = response.asString();

		JsonPath js = new JsonPath(typeCreation);
		String message = js.getString("message");
		articleCategory_id = js.getInt("data.article_type.id");

		Assert.assertEquals(arg1, message);
		System.out.println("The type creation response value is : " + typeCreation);
	}

}
