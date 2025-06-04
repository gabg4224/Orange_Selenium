package login;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import orange_pages.Dashboard;
import orange_pages.Login_page;
import utils.Allure_utils;
import utils.Excel_utils;
import utils.UiExtensions;

public class Test_login_page2 {

	private WebDriver driver;

	@DataProvider(name = "login_prov")
	public Object[][] dataProv() {
		try {
			String route = "TestData/TestData.xlsx";
			String sheet = "login";
			return Excel_utils.load_excel(route, sheet);

		} catch (Exception e) {
			e.printStackTrace();
			return new Object[0][0];
		}

	}

	@BeforeMethod
	public void open_browser() {

		driver = UiExtensions.navigate_Handler("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(dataProvider = "login_prov")
	public void validate_login(String USER, String PASSWORD) {

		Login_page login = new Login_page(driver);

		login.introduce_user_name(USER);
		login.introduce_password(PASSWORD);
		Dashboard dashboard = login.click_login();

		if (dashboard.is_dashboard_visible()) {

			assertTrue(true, "login successfull");
		} else {

			assertTrue(login.invalid_credentials_validation(), "invalid credentials successfully captured");
		}

	}

	@AfterMethod
	public void close_browser() {
		Allure_utils.takeScreenshot(driver);
		driver.quit();
	}

}
