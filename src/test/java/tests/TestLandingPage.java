package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import data.ShopriteTime;
import pages.LandingPage;
import util.UtilInput;

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
		ShopriteTime actualCheckoutTime = landing.getInputTime();
		ShopriteTime expectedCheckoutTime = new ShopriteTime(UtilInput.hour, UtilInput.min, UtilInput.meridian);
		assertEquals(actualCheckoutTime.toString(), expectedCheckoutTime.toString(), 
				"WHEN inputting the time, THEN it SHOULD display the same time.");
	}
	
	@AfterClass
	public void tearDown(){
		landing.endSession();
	}
}
