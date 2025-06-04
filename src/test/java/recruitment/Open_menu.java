package recruitment;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.Base_test;
import orange_pages.Base_page;
import orange_pages.Dashboard;
import orange_pages.Login_page;
import orange_pages.Recruitment.Add_vacancy;
import orange_pages.Recruitment.Recruitment;
import orange_pages.Recruitment.Vacancies_tab;
import utils.Excel_utils;

public class Open_menu extends Base_test {

	@DataProvider(name = "job_titles")
	public Object[][] data() {

		try {

			String route = "Testdata/Testdata.xlsx";
			String sheet = "jobtitles";
			return Excel_utils.load_excel(route, sheet);
		} catch (Exception e) {
			return new Object[0][0];
		}

	}

	@Test(dataProvider = "job_titles")
	public void add_vancacy(String TITLES) {

		Login_page login = new Login_page(driver);
		login.introduce_user_name("admin");
		login.introduce_password("admin123");
		Dashboard dashboard = login.click_login();

		Recruitment recruitment = dashboard.side_menu.go_to_recruitment();
		Vacancies_tab vacancy_tab = recruitment.go_to_vacancies_tab();

		Add_vacancy add_vacancy_tab = vacancy_tab.add_vacancy();

		add_vacancy_tab.introduce_job_title(TITLES);
		add_vacancy_tab.introduce_vacancy_name(TITLES);
		add_vacancy_tab.introduce_description(TITLES);
		add_vacancy_tab.introduce_hiring_manager();
		add_vacancy_tab.introduce_number_of_position();

		add_vacancy_tab.click_in_save_vacancy();

		add_vacancy_tab.assert_vacancy_created();

	}

}
