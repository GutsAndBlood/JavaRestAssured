package restAssuredOAuth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM {

	WebDriver driver = null;

	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By buttonSubmit = By.xpath("//input[@id='kc-login']");

	public POM(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void Username(String text) {
		driver.findElement(username).sendKeys(text);
	}

	public void Password(String text) {
		driver.findElement(password).sendKeys(text);
	}

	public void ButtonSubmit() {
		driver.findElement(buttonSubmit).click();
	}

}
