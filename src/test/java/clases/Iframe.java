package clases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages_courses.Page_iframe;
import utils.UiExtensions;

public class Iframe {

	private WebDriver driver;

	
	@BeforeTest
	public void startBrowser() {
		
		driver = UiExtensions.navigate_Handler("https://practice-automation.com/iframes/");
	}
	
	@Test
	public void validations_iframe_playwrite() {
		Page_iframe frame = new Page_iframe(driver);
		frame.access_frame_playwrite();
		
		frame.validate_community_tab();
		assertEquals(frame.validate_title_community_playwrite(), "Welcome");
		frame.back_to_normal();
		assertEquals(frame.validate_title_default(), "Iframes");
		
		
		

	}

}
