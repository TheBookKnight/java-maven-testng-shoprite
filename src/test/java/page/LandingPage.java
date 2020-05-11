package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	final WebDriver driver;
	final WebDriverWait wait;
	
	public LandingPage(String driverName, int waitSeconds) {
		/* This could be used to determine type of webdriver
		 * Since we only have one driver, we're only concerned about ChromeDriver
		if(driverName.equals("Chrome")) {
			
		}
		 */
		this.driver = new ChromeDriver();
		this.wait = new WebDriverWait(driver, waitSeconds); // 10 second wait
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how=How.ID,using="NextButton")
	public WebElement startBtn;
	
	@FindBy(how=How.ID,using="Index_VisitDateDatePicker")
	public WebElement inputDate;
	
	@FindBy(how=How.ID,using="Index_VisitDateFormattedDate")
	public WebElement inputDateValue;
	
	public WebElement inputDay(String day){
		String elem = "//a[contains(text(),'"+day+"')]";
		return driver.findElement(By.xpath(elem));
	}
	
	@FindBy(how=How.ID,using="InputHour")
	public WebElement inputHour;
	
	@FindBy(how=How.ID,using="InputMinute")
	public WebElement inputMin;
	
	@FindBy(how=How.ID,using="InputMeridian")
	public WebElement inputMeridian;
	
	public Select dropdownHour() {
		return new Select(inputHour);
	}
	
	public Select dropdownMin() {
		return new Select(inputMin);
	}
	
	public Select dropdownMeridian() {
		return new Select(inputMeridian);
	}
	
	public String getDropdownHour(){
		return dropdownHour().getFirstSelectedOption().getText();
	}
	
	public void setDropdownHour(String hour){
		inputHour.click();
		dropdownHour().selectByValue(hour);
	}
	
	public String getDropdownMin(){
		return dropdownMin().getFirstSelectedOption().getText();
	}
	
	public void setDropdownMin(String minute){
		inputMin.click();
		dropdownMin().selectByValue(minute);
	}
	
	public String getDropdownMeridian(){
		return dropdownMeridian().getFirstSelectedOption().getText();
	}
	
	public void setDropdownMeridian(String meridian){
		inputMeridian.click();
		dropdownMeridian().selectByValue(meridian);
	}
	
	public void startShopriteSurvey(){
		driver.get("https://www.myshopriteexperience.com/");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("NextButton")));
	}
	
	public void setInputDate(String day){
		inputDate.click();
		inputDay(day).click();
		wait.until(ExpectedConditions.attributeToBeNotEmpty(
				inputDateValue, "value"));
	}
	
	public String getInputDate() {
		return inputDateValue.getAttribute("value");
	}
	
	public void setInputTime(String hour, String min, String meridian) {
		setDropdownHour(hour);
		setDropdownMin(min);
		setDropdownMeridian(meridian);
	}
	
	public void endSession(){
		driver.close();
	}
}
