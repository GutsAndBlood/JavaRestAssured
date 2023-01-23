package restAssureJira;

public class UserCredentials {

	private String username = "angel.gonzalez";
	private String password = "admin123";



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "{ \r\n"
				+ "    \"username\": \""+getUsername()+"\", \r\n"
				+ "    \"password\": \""+getPassword()+"\" \r\n"
				+ "}";
	}




}
