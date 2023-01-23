package restAssuredSerialization;

import org.json.simple.JSONArray;

public class CurrentJsonDataString {

	static JsonDataHandling jsonData = new JsonDataHandling();

	public String cleanString(int index) {

		JSONArray jsonArray = jsonData.JsonData();
		String stringClean = jsonArray.get(index).toString();


		return stringClean;
	}

}
