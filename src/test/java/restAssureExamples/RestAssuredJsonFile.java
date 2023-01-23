package restAssureExamples;


import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import restAssuredRequest.Request;

@Test
public class RestAssuredJsonFile {

	List<Object> arrayCourses = new ArrayList<Object>();

	public void getJsonFile() {

		
		JsonPath jsonResponse = new JsonPath(Request.JsonFile());
		int courseCount = jsonResponse.getList("courses").size();
		arrayCourses = jsonResponse.getList("courses");
		int totalPrice = 0;
		int purchaseAmount = jsonResponse.getInt("dashboard.purchaseAmount");

		System.out.println("The number of Courses is: " + courseCount);
		System.out.println("The purcharse Amount is: " + purchaseAmount);
		System.out.println("The title of the first course is: " + jsonResponse.getString("courses[0].title"));

		for(int i =0; i<arrayCourses.size();i++) {
			String titleCourse = jsonResponse.getString("courses["+i+"].title");
			int priceCourse = jsonResponse.getInt("courses["+i+"].price");
			int copiesCourse = jsonResponse.getInt("courses["+i+"].copies");

			totalPrice = totalPrice + (priceCourse*copiesCourse);

			System.out.println("The Title: "+titleCourse);
			System.out.println("has a Prices of: "+priceCourse);
		}

		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertEquals(totalPrice, purchaseAmount,"Not Equal price ====>");
		softAssertion.assertAll();



	}


}
