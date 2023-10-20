package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadPage {
	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver,CreatingNewLeadPage.this);
	}
	
	@FindBy(name="salutationtype")
	private WebElement leadNameSalutationDropdown;
	
	@FindBy(name="firstname")
	private WebElement leadFirstNameTextBox;
	
	@FindBy(name="lastname")
	private WebElement leadLastNameTextBox;
	
	@FindBy(name="company")
	private WebElement leadCompanyNameTextBox;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	public WebElement getFirstNameTextBox() {
		return leadFirstNameTextBox;
	}
	
	public WebElement getLeadNameSalutationDropdown() {
		return leadNameSalutationDropdown;
	}
	
	public WebElement getLastNameTextBox() {
		return leadLastNameTextBox;
	}
	
	public WebElement getCompanyNameTextBox() {
		return leadCompanyNameTextBox;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void passLeadNameSalutationDropdown(String option) {
		Select select=new Select(leadNameSalutationDropdown);
		select.selectByVisibleText(option);
	}
	
	public void enterFirstName(String firstName) {
		leadFirstNameTextBox.sendKeys(firstName);
	}
	
	public void enterLastName(String lasttName) {
		leadLastNameTextBox.sendKeys(lasttName);
	}
	
	public void enterCompanyName(String companyName) {
		leadCompanyNameTextBox.sendKeys(companyName);
	}
	
	public void passIndustryNameInIndustryDropdown(String option) {
		Select select=new Select(industryDropdown);
		select.selectByVisibleText(option);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	
	
	
	
}
