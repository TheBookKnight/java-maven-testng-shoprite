package java_maven_testng_shoprite.shoprite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java_maven_testng_shoprite.shoprite.util.UtilInput;
import page.LandingPage;

import static org.testng.Assert.*;

public class TestLandingPage {
	LandingPage landing;
	
	@BeforeClass
	public void setUp() {
		landing = new LandingPage("Chrome", 10);
	}
	
	@Test
	public void openShopritePageTest() throws InterruptedException{
		landing.startShopriteSurvey();
		assertNotNull(landing.startBtn, "WHEN you navigate to 'www.myshopriteexperience.com', "
				+ "THEN you SHOULD see the Start Btn.");
	}
	
	@Test(dependsOnMethods = { "openShopritePageTest" })
	public void typeDateInputTest() throws InterruptedException{
		landing.setInputDate(UtilInput.day);
		assertEquals(landing.getInputDate(), UtilInput.fullDate, 
				"WHEN the date was entered in Calendar dropdown, THEN you SHOULD see date in the Input Field");
	}
	
	@Test(dependsOnMethods = { "typeDateInputTest" })
	public void typeTimeTest() throws InterruptedException{
		landing.setInputTime(UtilInput.hour, UtilInput.min, UtilInput.meridian);
		SoftAssert testTime = new SoftAssert();
		testTime.assertEquals(landing.getDropdownHour(), UtilInput.hour, 
				"WHEN inputting the hour, THEN it SHOULD display the same hour.");
		testTime.assertEquals(landing.getDropdownMin(), UtilInput.min, 
				"WHEN inputting the minute, THEN it SHOULD display the same minute.");
		testTime.assertEquals(landing.getDropdownMeridian(), UtilInput.meridian, 
				"WHEN inputting the meridian, THEN it SHOULD display the same meridian.");
	}
	
	@AfterClass
	public void tearDown(){
		landing.endSession();
	}
}
