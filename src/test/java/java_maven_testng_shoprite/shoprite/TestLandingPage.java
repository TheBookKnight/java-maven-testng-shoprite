package java_maven_testng_shoprite.shoprite;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLandingPage {
	WebDriver driver;
	@Test
	public void openShopritePage() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.myshopriteexperience.com/");
		Thread.sleep(3000L);
	}
}
