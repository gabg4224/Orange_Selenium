package orange_pages.Recruitment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import orange_pages.Base_page;
import utils.Data_generator;

public class Add_vacancy extends Base_page {

	public Add_vacancy(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//label[text()='Vacancy Name']/parent::div/following-sibling::div//input")
	private WebElement vacancy_name_input;

	@FindBy(xpath = "//label[text()='Description']/parent::div/following-sibling::div//textarea")
	private WebElement description_input;

	@FindBy(xpath = "//label[text()='Job Title']/parent::div/following-sibling::div")
	private WebElement job_title;

	@FindBy(xpath = "//div[@role='listbox']")
	private WebElement job_title_dropdown;

	private String job_title_dropdown_options = "//div[@class='oxd-select-option']//span";
	private String hiring_manager_options = "//div[contains(@class,'oxd-autocomplete-option')]";
	@FindBy(xpath = "//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
	private WebElement job_title_item_selected;

	@FindBy(xpath = "//label[text()='Hiring Manager']/parent::div/following-sibling::div//input")
	private WebElement hiring_manager_input;

	@FindBy(xpath = "//div[contains(@class,'oxd-autocomplete-dropdown')]")
	private WebElement hiring_manager_dropdown;

	@FindBy(xpath = "//label[text()='Number of Positions']/parent::div/following-sibling::div//input")
	private WebElement number_of_positions_input;

	@FindBy(xpath = "//p[text()='Active']/following::div//input[@type='checkbox']")
	private WebElement active_toggle_input;

	@FindBy(xpath = "//p[text()='Publish in RSS Feed and Web Page']/following::div//input[@type='checkbox']")
	private WebElement RSS_toggle_input;

	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement save_vacancy;

	@FindBy(xpath = "//p[text()='Success']")
	private WebElement success_flag;

	public void introduce_job_title(String value) {

		no_select_dropdown(job_title, job_title_dropdown_options, value);
	}

	public void introduce_vacancy_name(String value) {

		perform_Introduce_Text(vacancy_name_input, "Test_" + dataGen.random_milis() + value);
	}

	public void introduce_description(String value) {

		perform_Introduce_Text(description_input, "description " + value);
	}

	public void introduce_hiring_manager() {
		perform_Introduce_Text(hiring_manager_input, "a");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		List<WebElement> realOptions = wait.until(driver -> {
			List<WebElement> options = driver.findElements(By.xpath(hiring_manager_options));
			for (WebElement option : options) {
				String text = option.getText().trim();
				if (!text.isEmpty() && !text.equalsIgnoreCase("Searching....")) {
					return options;
				}
			}
			return null; // sigue esperando
		});

		// Opcional: selecciona la primera opción real
		for (WebElement option : realOptions) {
			String text = option.getText().trim();
			if (!text.equalsIgnoreCase("Searching....")) {
				option.click();
				break;
			}
		}
	}

	public void introduce_number_of_position() {
		String value = generate_random_number(1, 99);
		perform_Introduce_Text(number_of_positions_input, value);

	}

	public void active_field_toggle_on() {
		turn_on_toggle(active_toggle_input);
	}

	public void rss_field_toggle_on() {
		turn_on_toggle(RSS_toggle_input);
	}

	public void click_in_save_vacancy() {

		perform_Click(save_vacancy);

	}

	public boolean validate_job_title(String value) {
		try {

			return validate_fields(job_title_item_selected, value);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean assert_vacancy_created() {

		try {

			
			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement flag = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//p[contains(@class, 'oxd-text--toast-message') and contains(text(),'Successfully Saved')]") // O el selector real de tu flag
	        ));
			System.out.println(flag);
			return flag.isDisplayed();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
