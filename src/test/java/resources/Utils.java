package resources;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import StepDefinition.appLogin;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	public static RequestSpecification request1;
	private String accessToken = "Bearer"+" "+ appLogin.access_token;
	ResponseSpecification responseSpec;

	public RequestSpecification requestSpecification() throws FileNotFoundException {

		if(request1 == null) {
			PrintStream log = new PrintStream("logFile.txt");
			//	PrintStream log = new PrintStream(new FileOutputStream("logFile.txt", true));
			System.out.println("The access token vlaue in util class is" +accessToken);
			request1 = new RequestSpecBuilder().setBaseUri("https://www.stocklift.net.farshore.net")
					.addHeader("Authorization", accessToken)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			return request1;
		}
		return request1;
	}

	public ResponseSpecification responseSpecification() {

		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		return responseSpec;
	}
}
