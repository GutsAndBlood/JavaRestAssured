package restAssureJira;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class RestAssuredJiraCreateIssueWithCookies {

	UserCredentials test = new UserCredentials();
	UserComment userComments= new UserComment();
	String sessionName;
	String sessionID;

	public void Setup() {
		RestAssured.baseURI = "http://localhost:8080/";
	}



	@Test(priority = 1)
	public void LoginIntoJira() {

		String response = given()
								.header("Content-Type","application/json").body(test.toString())
							.when()
								.post("/rest/auth/1/session")
							.then()
								.extract().response().asString();

		JsonPath jsonExtract = new JsonPath(response);

		sessionName = jsonExtract.getString("session.name");
		sessionID = jsonExtract.getString("session.value");

	}

	@Test(priority = 2)
	public void AddCommentInJiraIssue() {

		String response = given()
								.header("Content-Type","application/json")
								.header("Cookie",sessionName+"="+ sessionID)
								.body(userComments.AddComment())
							.when()
								.post("/rest/api/2/issue/"+10002+"/comment")
							.then()
								.extract().response().asString();

		System.out.println(response);

		//JsonPath jsonExtract = new JsonPath(response);



	}



}
