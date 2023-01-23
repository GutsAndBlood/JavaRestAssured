package restAssuredJsonAsDataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonDataHandling {

	public JSONArray JsonData() {
		JSONParser parser = new JSONParser();
		JSONArray jsonRead = null;

		try{
			FileReader reader = new FileReader("dataTwo.json");
			Object jsonObject = parser.parse(reader);
			jsonRead = (JSONArray) jsonObject;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonRead;
	}

}
