package orange_pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import orange_pages.Base_page;
import orange_pages.Recruitment.Recruitment;

public class Side_menu extends Base_page {

	public Side_menu(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='Recruitment']")
	private WebElement Recruitment_page;

	public Recruitment go_to_recruitment() {
		perform_Click(Recruitment_page);

		return new Recruitment(driver);
	}

}
