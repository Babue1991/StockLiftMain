package StepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import PojoClasses.editProfileInputResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;

public class EditProfile extends Utils{
	static String editProfileResponse;
	RequestSpecification requestSpec;
	Response response;
	String myProfileResponse;
	String FirstName;

	@Given("^The  user information as input payload \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_information_as_input_payload_and(String fname, String lname, String Timezone, String phone, String email) throws Throwable {
	    
		editProfileInputResponse editProfile = new editProfileInputResponse();
		editProfile.setProfile_fname(fname);
		editProfile.setProfile_lname(lname);
		editProfile.setProfile_SelectedTimeZone(Timezone);
		editProfile.setProfile_phone(phone);
		editProfile.setProfile_email(email);
		
		requestSpec = given().spec(requestSpecification())
				.body(editProfile);
	}
	
	@When("^The user calls  with  GET HTTP method to update user profile data$")
	public void the_user_calls_with_GET_HTTP_method_to_update_user_profile_data() throws Throwable {
	 
	  response = requestSpec.when().post("webapp/careteamAppV1/editprofile").then().spec(responseSpecification()).extract().response();
	 
	 }

	@Then("^The response message should be success$")
	public void the_response_message_should_be_success() throws Throwable {
		editProfileResponse = response.asString();

		JsonPath js = new JsonPath(editProfileResponse);
		String message = js.getString("message");

		Assert.assertEquals("Profile has been updated successfully", message);
		System.out.println("The edit Profile API response value is : " + editProfileResponse);
	}


}
