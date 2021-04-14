package StepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import cucumber.api.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class CategoryList extends Utils {
	RequestSpecification requestSpec;
	Response response;
	static String HomeScreenResponse;
	String message;
	String actualResponse;
	
    @Given("^The user access token key$")
    public void the_user_access_token_key() throws Throwable {
		requestSpec = given().spec(requestSpecification());
	}

    @When("^The user calls  with  GET HTTP method to get category list$")
    public void the_user_calls_with_get_http_method_to_get_category_list() throws Throwable {
		response = requestSpec.when().post("api/article_category").then().spec(responseSpecification()).extract().response();
	}
	
	
    @Then("^The status code should be \"([^\"]*)\" and the response message should be \"([^\"]*)\"$")
    public void the_status_code_should_be_something_and_the_response_message_should_be_something(String strArg1, String strArg2) throws Throwable {
		HomeScreenResponse = response.asString();  
		System.out.println("The home screen response String is" +HomeScreenResponse);
		
		JsonPath js = new JsonPath(HomeScreenResponse);
		  message =  js.getString("message"); // actualResponse = js.getString("message"); //
	  System.out.println(message);
	  System.out.println("The home screen API response value is : " +message );
	  Assert.assertEquals(message, "Article category Lists!."); 
	  }
	 
	 
}
