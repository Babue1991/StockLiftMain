package StepDefinition;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import com.mongodb.util.JSON;

public class Learn {

	public static void main(String[] args) {

		
		RestAssured.baseURI="https://www.stocklift.net.farshore.net";
		
		String str = given().log().all().auth().basic("dev", "e5zvfb84").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "        \"email\":\"babufsp5@gmail.com\",\r\n"
				+ "        \"password\":\"Test@123\"\r\n"
				+ "}")
		.when().post("api/login")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(str);
		
		JsonPath js = new JsonPath(str);
	String scs = 	js.getString("data.id");
	
	System.out.println("the resonse is "+scs);

		
		
		
	}

}
