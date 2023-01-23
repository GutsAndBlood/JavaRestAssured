package restAssuredRefresh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


@SuppressWarnings("unused")
public class TestCases {

	private WebDriver driver;
	private String driverPath=System.getProperty("user.dir");
	
	@BeforeSuite
	public void StartUp() {
		
		System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver.exe");		  
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	@Test
	public void TestCase01() {
		
		driver.get("https://reqres.in/");
		
		POM controllerPom = new POM(driver);
		String currentLinkToValidated = controllerPom.LinkHolder();

		baseURI = "https://reqres.in/";
		
		String response = given()
				.when().get(currentLinkToValidated)
				.then().extract().jsonPath().getString("data");
		
		
		System.out.println(response);
		
	}
	
	
	
	@AfterSuite
	public void TearDown() {
		driver.quit();
	}
}
