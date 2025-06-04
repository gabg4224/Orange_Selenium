package login;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.Base_test;
import io.qameta.allure.Description;
import orange_pages.Dashboard;
import orange_pages.Login_page;
import utils.Allure_utils;
import utils.Excel_utils;
import utils.UiExtensions;

public class Test_login_page extends Base_test {

	@DataProvider(name = "login_data")
	public Object[][] data() {

		try {
			String route = "TestData/TestData.xlsx";
			String sheet = "login";
			return Excel_utils.load_excel(route, sheet);
		} catch (Exception e) {
			e.printStackTrace();
			return new Object[0][0];
		}
	}


	@Test(dataProvider = "login_data")
	@Description("validate login with correct and incorrect credentials")
	public void Login_validation(String USER, String PASSWORD) {

		Login_page login = new Login_page(driver);

		login.introduce_user_name(USER);
		login.introduce_password(PASSWORD);
		Dashboard dashboard = login.click_login();
		boolean wasLoginSuccesfull = dashboard.is_dashboard_visible();
		if (wasLoginSuccesfull) {

			assertTrue(true, "login succesfully");

		} else {

			assertTrue(login.invalid_credentials_validation(), "Dashboard was not displayed");
		}

	}

}
