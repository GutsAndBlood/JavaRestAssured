package restAssureExamples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restAssuredRequest.Request;

public class RestAssureExamples {

	String placeID;

	@Test(priority = 1)
	public void PostRequest() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().queryParam("key", "qaclick123")
							.header("Content-Type","application/json")
							.body(Request.PostRequestInfo())
						  .when()
						  	.post("/maps/api/place/add/json")
						  .then()
						  	.assertThat().statusCode(200).body("scope", equalTo("APP"))
						  	.extract().response().asString();

		JsonPath json = new JsonPath(response);
		placeID = json.getString("place_id");

		System.out.println(response);
	}


	  @Test(priority = 2) public void PutRequest() {

	  RestAssured.baseURI = "https://rahulshettyacademy.com";

	  String response = given().queryParam("key", "qaclick123")
			  				.header("Content-Type","application/json")
			  				.body(Request.PutRequestInfo(placeID))
			  			.when()
			  				.put("/maps/api/place/update/json")
			  			.then() .extract().response().asString();

	  JsonPath json = new JsonPath(response);
	  String messageResponse = json.getString("msg");

	  Assert.assertEquals(messageResponse, "Address successfully updated");

	  System.out.println(response);

	  }



}
