package restAssuredOAuth;

import static io.restassured.RestAssured.given;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class OAuth2 {

	Credentials credentials = new Credentials();
	private WebDriver driver;
	private String driverPath=System.getProperty("user.dir");

	@BeforeTest
	public void StartUp() {


		System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void getAccess() {

		POM controllerLogin = new POM(driver);
		RestAssured.baseURI = credentials.getURL();

		Response response = given()
								.queryParam("response_type","code")
								.queryParam("client_id",credentials.getClientId())
								.queryParam("scope",credentials.getScope())
								.queryParam("redirect_uri",credentials.getURL())
						 .when()
								.get(credentials.getResourseAuthURL())
						 .then().extract().response();

		Map<String, String> allCookies = response.getCookies();
		
		driver.get("http://localhost:8180/auth/realms/master/protocol/openid-connect/auth?response_type=code&client_id=OAuth&scope=openid&redirect_uri=http://localhost:8180/auth/admin/master/console/");

		controllerLogin.Username(credentials.getUsername());
		controllerLogin.Password(credentials.getPassword());
		controllerLogin.ButtonSubmit();

		String URL= driver.getCurrentUrl();

		String code = URL.split("code=")[1];
		driver.quit();

		MediaTypexwwwform mediaBody = new MediaTypexwwwform();

		Response responsePost = given()
				.header("Content-Type","application/x-www-form-urlencoded")
				.header("Connection","keep-alive")
				.header("Accept-Encoding","gzip, deflate, br")
				.header("Host","localhost:8180/auth")
				.header("Accept","*/*")
				.header("Cache-Control","no-cache")
				.header("AUTH_SESSION_ID",allCookies.get("AUTH_SESSION_ID"))
				.header("AUTH_SESSION_ID_LEGACY",allCookies.get("AUTH_SESSION_ID_LEGACY"))
				.header("KC_RESTART", allCookies.get("KC_RESTART"))
				.body(mediaBody.MediaFormat(code))
		 .when()
				.post("/realms/master/protocol/openid-connect/token")
		 .then().extract().response();
		
		String extractingAccessToken = responsePost.asString().split("access_token\":\"")[1];
		String accessStoken = extractingAccessToken.split("\",\"")[0];

		String finalResponse = given()
				.header("Connection","keep-alive")
				.header("Accept-Encoding","gzip, deflate, br")
				.header("Accept","*/*")
				.header("Authorization","Bearer "+accessStoken)
		 .when()
				.post("/realms/master/protocol/openid-connect/userinfo")
		 .then().extract().response().asString();
		
		
		JsonPath jsonPath = new JsonPath(finalResponse);
		System.out.println(jsonPath.getString("name"));
		System.out.println(jsonPath.getString("email"));
		
	}



}
