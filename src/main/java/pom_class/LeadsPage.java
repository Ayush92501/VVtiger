package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement leadPlusButton;
	
	public WebElement getLeadPlusButton() {
		return leadPlusButton;
	}
	
	public void clickOnLeadPlusButton() {
		leadPlusButton.click();
	}
}
