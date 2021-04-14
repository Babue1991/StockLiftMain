package StepDefinition;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;

public class Basic_Check {

	public static void main(String[] args) {

		RestAssured.baseURI="https://www.stocklift.net.farshore.net";
		
		String login =	given().log().all().auth().basic("dev", "e5zvfb84").header("Content-Type", "application/json")
				.body("{\r\n"
						+ "        \"email\":\"babufsp5@gmail.com\",\r\n"
						+ "        \"password\":\"Test@123\"\r\n"
						+ "}")
		.when().log().all().post("api/login")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("The login response is" +login);
		
		JsonPath jpath= new JsonPath(login);
		String token = jpath.getString("data.access_token");
		
		System.out.println("Token " +token );
		String tok = "Bearer" +" "+token;
	
		String catCreation =given().log().all()
		.header("Authorization",tok)
		.header("Content-Type", "application/json")
				.body("{\r\n"
						+ "\"name\":\"StockLift web\"\r\n"
						+ "}")
		.when().log().all().post("api/article_category")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jpath1= new JsonPath(catCreation);
		String cat = jpath1.getString("message");
		System.out.println(catCreation);
		System.out.println("Token " +cat );
	}

}
