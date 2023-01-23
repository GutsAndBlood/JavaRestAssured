package restAssuredRefresh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM {
	
	WebDriver driver;
	
	By linkHolder = By.xpath("//span[@data-key='url']");

	public POM(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String LinkHolder() {
		
		String CurrentLink = driver.findElement(linkHolder).getText();	
		return CurrentLink;
	}
	
}
