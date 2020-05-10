package java_maven_testng_shoprite.shoprite;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java_maven_testng_shoprite.shoprite.util.UtilInput;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLandingPage {
	WebDriver driver;
	WebDriverWait wait; // creates a wait until web element is found
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10); // 10 second wait
	}
	
	@Test
	public void openShopritePageTest() throws InterruptedException{
		driver.get("https://www.myshopriteexperience.com/");
		wait_for_start_btn();
		WebElement startBtn = driver.findElement(By.id("NextButton"));
		Assert.assertNotNull(startBtn, "WHEN you navigate to 'www.myshopriteexperience.com', "
				+ "THEN you SHOULD see the Start Btn.");
	}
	
	@Test(dependsOnMethods = { "openShopritePageTest" })
	public void typeDateInputTest() throws InterruptedException{
		WebElement input_date = driver.findElement(By.id("Index_VisitDateDatePicker"));
		input_date.click();
		String day = "//a[contains(text(),'"+UtilInput.day+"')]";
		WebElement input_day = driver.findElement(By.xpath(day));
		input_day.click();
		WebElement input_date_value = driver.findElement(By.id("Index_VisitDateFormattedDate"));
		String dateChosen = input_date_value.getAttribute("value");
		wait.until(ExpectedConditions.attributeToBeNotEmpty(input_date_value, "value"));
		Assert.assertEquals(dateChosen, UtilInput.fullDate, 
				"WHEN the date was entered in Calendar dropdown, THEN you SHOULD see date in the Input Field");
	}
	
	@Test(dependsOnMethods = { "typeDateInputTest" })
	public void typeTimeTest() throws InterruptedException{
		SoftAssert testTime = new SoftAssert();
		WebElement input_hour = driver.findElement(By.id("InputHour"));
		input_hour.click();
		Select dropdown_hour = new Select(driver.findElement(By.id("InputHour")));
		dropdown_hour.selectByValue(UtilInput.hour);
		WebElement input_min = driver.findElement(By.id("InputMinute"));
		input_min.click();
		Select dropdown_min = new Select(driver.findElement(By.id("InputMinute")));
		dropdown_min.selectByValue(UtilInput.min);
		WebElement input_meridian = driver.findElement(By.id("InputMeridian"));
		input_meridian.click();
		Select dropdown_meridian = new Select(driver.findElement(By.id("InputMeridian")));
		dropdown_meridian.selectByValue(UtilInput.meridian);
		testTime.assertEquals(dropdown_hour.getFirstSelectedOption().getText(), 
				UtilInput.hour, "WHEN the hour is inputted, THEN it SHOULD display the same hour.");
		testTime.assertEquals(dropdown_min.getFirstSelectedOption().getText(), 
				UtilInput.min, "WHEN the minute is inputted, THEN it SHOULD display the same minute.");
		testTime.assertEquals(dropdown_meridian.getFirstSelectedOption().getText(), 
				UtilInput.meridian, "WHEN the meridian is inputted, THEN it SHOULD display the same meridian.");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	public void wait_for_start_btn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("NextButton")));
	}
	
}
