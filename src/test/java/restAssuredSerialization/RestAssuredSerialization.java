package restAssuredSerialization;

import com.google.gson.Gson;

public class RestAssuredSerialization {
	
	static EmployeeTemplate employee = new EmployeeTemplate(10, "Jhon", "HR", "2", "2015-01-01");
	static Gson gson = new Gson();
	static CurrentJsonDataString cleanString = new CurrentJsonDataString();
	
	public String Serialization() {

		String jsonFormat = gson.toJson(employee);
		return jsonFormat;
	}
	
	public  Object Deserialization(int index) {

			EmployeeTemplate deserialization = gson.fromJson(cleanString.cleanString(index), EmployeeTemplate.class);
			return deserialization;
		}
}
