package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewVendorPage {

	public CreatingNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		@FindBy(name="vendorname")
		private WebElement vendorNameTextField;
		
		@FindBy(name="button")
		private WebElement saveButton;

		public WebElement getVendorNameTextField() {
			return vendorNameTextField;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}
		
		public void enterVendorName(String vendorName) {
			vendorNameTextField.sendKeys(vendorName);
		}
		
		public void clickOnSaveButton() {
			saveButton.click();
		}
}
