package pom_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreatingNewProductPage {
	WebDriver driver;
	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
		
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(name="sales_start_date")
	private WebElement salesStartDateCalendar;
	
	@FindBy(name="sales_end_date")
	private WebElement salesEndDateCalendar;
	
	@FindBy(xpath="//img[@alt=\"Select\"]")
	private WebElement vendorLookUpButton;
	
	@FindBy(name="search_text")
	private WebElement vendorNameSearchBox;
	
	
	@FindBy(name="search")
	private WebElement saerchNowButton;
	
	/*public void clickOnVendorNameFromLookUpPage(String vendorName) {
		 driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
	}*/
	
	@FindBy(id="my_file_element")
	private WebElement productImageUploadButton;
	
	@FindBy(name="button")
	public WebElement saveButton;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSalesStartDateCalendar() {
		return salesStartDateCalendar;
	}

	public WebElement getSalesEndDateCalendar() {
		return salesEndDateCalendar;
	}

	public WebElement getVendorLookUpButton() {
		return vendorLookUpButton;
	}

	public WebElement getVendorNameSearchBox() {
		return vendorNameSearchBox;
	}

	public WebElement getSaerchNowButton() {
		return saerchNowButton;
	}

	public WebElement getProductImageUploadButton() {
		return productImageUploadButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void enterProductName(String productName) {
		productNameTextField.sendKeys(productName);
	}
	
	public void enterSalesStartDate(String salesStartDate) {
		salesStartDateCalendar.sendKeys(salesStartDate);
	}
	
	public void enterSalesEndDate(String salesEndDate) {
		salesEndDateCalendar.sendKeys(salesEndDate);
	}
	
	public void selectVendorNameFromLookPage(String lookUpPageTitle,String vendorName,String productPageTitle) {
		WebDriverUtility wUtils=new WebDriverUtility();
		wUtils.switchToWindow(driver, lookUpPageTitle);
		vendorNameSearchBox.sendKeys(vendorName);
		saerchNowButton.click();
		 driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		wUtils.switchToWindow(driver, productPageTitle);
	}
		public void uploadImage(String path) {
			productImageUploadButton.sendKeys(path);
		}
		
		public void clickOnSaveButton() {
			saveButton.click();
		}
		
		public void clickOnVendorLookUpPlusButton() {
			vendorLookUpButton.click();
		}
		
		
		
	}
	
	

