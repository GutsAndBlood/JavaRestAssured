package restAssuredJsonAsDataProvider;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;

import com.google.common.base.Splitter;

public class CurrentJsonDataString {

	static JsonDataHandling jsonData = new JsonDataHandling();

	public HashMap<String, String> cleanString(int index) {

		JSONArray jsonArray = jsonData.JsonData();
		String stringClean = jsonArray.get(index).toString().replaceAll("[{}\"]","");

		Map<String, String> currentJsonData = Splitter.on(",")
				.withKeyValueSeparator(":")
				.split(stringClean);

		HashMap<String, String> jsonDataFixed = new HashMap<String, String>();
		jsonDataFixed.putAll(currentJsonData);

		return jsonDataFixed;
	}

}
