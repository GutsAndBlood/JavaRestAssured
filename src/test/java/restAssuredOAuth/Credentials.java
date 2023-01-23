package restAssuredOAuth;

public class Credentials {

	private String clientId = "OAuth";
	private String clientSecret = "BayXZXVqyZgp9dCOXvjvBVs8KgEdhTSQ";
	private String URL = "http://localhost:8180/auth";
	private String scope = "openid";
	private String resourseAccessToken = "/realms/master/protocol/openid-connect/token";
	private String resourseAuthURL = "/realms/master/protocol/openid-connect/auth";
	private String callbackURL = "";
	private String username = "admin";
	private String password = "admin123";
	

	public String getClientId() {
		return clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public String getURL() {
		return URL;
	}
	public String getScope() {
		return scope;
	}
	public String getResourseAccessToken() {
		return resourseAccessToken;
	}
	public String getResourseAuthURL() {
		return resourseAuthURL;
	}
	public String getCallbackURL() {
		return callbackURL;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

}
