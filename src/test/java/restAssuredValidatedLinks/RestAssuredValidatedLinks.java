package restAssuredValidatedLinks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class RestAssuredValidatedLinks {

	private WebDriver driver;
	private String driverPath=System.getProperty("user.dir");
	private String baseURI = "https://www.unosquare.com/";

	@BeforeTest
	public void StartUp() {


		System.setProperty("webdriver.chrome.driver", driverPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();		  
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}



	@Test
	public void ValidatedLinks() throws InterruptedException {

		driver.get(baseURI);
		String originalWindow = driver.getWindowHandle();
		int validLinks = 0;
		int nullLinks = 0;

		List<WebElement> links =  driver.findElements(By.tagName("a"));
		int numberOfLinks = links.size();

		for(int i=0;i<numberOfLinks;i++) {

			String currentLink = links.get(i).getAttribute("href");
			String currentLinkName = links.get(i).getAttribute("text");
			System.out.println(currentLink);

			if(currentLink != null) {
				validLinks++;
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(currentLink);
				String currentTitle = driver.getTitle();

				System.out.println(currentTitle);

				int response = given()
						.when().get(currentLink)
						.then().extract().statusCode();


				System.out.println("Status code: "+response);

				driver.close();
				driver.switchTo().window(originalWindow);
			}else {
				nullLinks++;
				System.out.println("Link with the follow text: "+ currentLinkName +" is null");
			}

		}

		System.out.println("On "+baseURI+" Are "+validLinks+ " Valid links and "+nullLinks+" Invalid Links");

	}


	@AfterTest
	public void TearDown() {
		driver.quit();
		driver = null;
	}

}
