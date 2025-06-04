package clases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages_courses.Handle_windows;
import utils.UiExtensions;

public class Handle_window {
	
	private WebDriver driver;
	
	@BeforeTest
	public void open_browser() {
		UiExtensions.navigate_Handler("https://practice-automation.com/window-operations/");
	}
	
	@Test
	public void manage_new_tab() {
		Handle_windows windows = new Handle_windows(driver);
		windows.click_new_tab_button();
		
		
	}

}
