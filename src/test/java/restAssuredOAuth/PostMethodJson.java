package restAssuredOAuth;

public class PostMethodJson {


	public String JsonBody(String code) {


		return "{\r\n"
				+ "   \"grant_type\":\"authorization_code\",\r\n"
				+ "   \"code\":\""+ code +"\",\r\n"
				+ "   \"redirect_uri\":\"http://localhost:8180/auth/admin/master/console/\",\r\n"
				+ "   \"client_id\":\"OAuth\"\r\n"
				+ "}";
	}


}
