package orange_pages.Recruitment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import orange_pages.Base_page;
import orange_pages.components.Side_menu;

public class Recruitment extends Base_page {
	public Side_menu side_menu;

	public Recruitment(WebDriver driver) {
		super(driver);
		this.side_menu = new Side_menu(driver);

	}

	@FindBy(xpath = "Candidates")
	public WebElement candidate_button;

	@FindBy(xpath = "//a[text()=\"Vacancies\"]")
	public WebElement vacancies_button;

	public Candidates_tab get_candidates_tab() {

		return new Candidates_tab(driver);
	}

	public Candidates_tab go_to_candidate_tab() {
		perform_Click(candidate_button);
		return new Candidates_tab(driver);
	}

	public Vacancies_tab go_to_vacancies_tab() {
		perform_Click(vacancies_button);
		return new Vacancies_tab(driver);
	}

}
