package restAssureJira;

public class UserComment {

	public String AddComment() {
		return "{\r\n"
				+ "    \"body\": \"As QA I validated the current Story/Bug as successful\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}";
	}
}
