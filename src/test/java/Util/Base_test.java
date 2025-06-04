package Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import orange_pages.Base_page;
import utils.Allure_utils;

public class Base_test {

	protected WebDriver driver;

	@BeforeMethod
	@Parameters("url")
	public void setup(@Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String browser) {
		driver = Base_page.navigate_Handler(browser);

	}

	@AfterMethod
	public void close_browser() {
		Allure_utils.takeScreenshot(driver);

		
	}

}
