package restAssuredJsonAsDataProvider;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RestAssuredJsonAsDataProvider {

	CurrentJsonDataString jsonDataString = new CurrentJsonDataString();
	int i = 0;

	@DataProvider(name="test")
	public Object[][] dpMethod (){

		HashMap<String, String> jsonDataHashMap = jsonDataString.cleanString(i);

		return new Object[][] {
			{jsonDataHashMap.get("name"), jsonDataHashMap.get("id"), jsonDataHashMap.get("DepartmentID"), jsonDataHashMap.get("RegistrationDate")}
		};
	}

	@Test(invocationCount = 6, dataProvider = "test")
	public void test01(String name,String id, String DepartmentID, String RegistrationDate) {

		System.out.println(name);
		i++;
	}

}
