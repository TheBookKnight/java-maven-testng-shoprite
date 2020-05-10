package java_maven_testng_shoprite.shoprite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	final WebDriver driver;
	final WebDriverWait wait;
	
	public LandingPage(String driverName, int waitSeconds) {
		this.driver = new ChromeDriver();
		this.wait = new WebDriverWait(driver, waitSeconds); // 10 second wait
	}
}
