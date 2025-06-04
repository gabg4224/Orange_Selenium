package orange_pages.Recruitment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import orange_pages.Base_page;

public class Vacancies_tab extends Base_page {
	public Vacancies_tab(WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath = "//button[contains(., 'Add')]")
	private WebElement add_vacancy_button;

	public Add_vacancy add_vacancy() {

		perform_Click(add_vacancy_button);
		return new Add_vacancy(driver);
	}
}
