package restAssuredSerialization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;

public class RestAssuredJsonAsDataProvider{

	CurrentJsonDataString cleanString = new CurrentJsonDataString();
	int i = 0;
	

	@DataProvider(name="test")
	public Object[][] dpMethod (){
		
		Gson gson = new Gson();
		EmployeeTemplate deserialization = gson.fromJson(cleanString.cleanString(i), EmployeeTemplate.class);

		return new Object[][] {
				{deserialization.getId(),
				deserialization.getName(),
				deserialization.getDepartmentId(), 
				deserialization.getDepartmentIDNum(),
				deserialization.getRegistrationDate()}
		};
	}

	@Test( dataProvider = "test", invocationCount = 6)
	public void test01(int id, String name,String deparmentID, String departmentIDNum, String RegistrationDate) {

		System.out.println("paramaters obtain correctly");
		i++;
	}
	

}
