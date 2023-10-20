package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(linkText="Leads")
	private WebElement leadsModule;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationsModule;
	   
	@FindBy(linkText="Contacts")
	private WebElement contactModule;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesModule;
	
	@FindBy(linkText="Products")
	private WebElement productModule;
	
	@FindBy(linkText="More")
	private WebElement moreModule;
	
	@FindBy(linkText="Campaigns")
	private WebElement compaignModule;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorsModule;
	
	@FindBy(linkText="Sales Order")
	private WebElement salesOrderModule;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminitratorImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutModule;
	
	public WebElement getLeadModule() {
		return leadsModule;
	}
	
	public WebElement getOrganisationModule() {
		return organizationsModule;
	}
	
	public WebElement getContactModule() {
		return contactModule;
	}
	
	public WebElement getSignOutModule() {
		return signOutModule;
	}
	
	public WebElement getOpportunityModule() {
		return opportunitiesModule;
	}
	
	public WebElement getProductModule() {
		return productModule;
	}
	
	public WebElement getMoreModule() {
		return moreModule;
	}
	
	public WebElement getCompaignModule() {
		return compaignModule;
	}
	
	public WebElement getVendorModule() {
		return vendorsModule;
	}
	
	
	public WebElement getSalesOrderModule() {
		return salesOrderModule;
	}
	
	public WebElement getAdministratorImage() {
		return adminitratorImage;
	}
	
	public void clickOnOpportunityModule() {
		opportunitiesModule.click();
	}
	
	public void clickOnOrganisationModule() {
		organizationsModule.click();
	}
	
	public void clickOnLeadModule() {
		leadsModule.click();
	}
	
	public void clickOnProductModule() {
		productModule.click();
	}
	
	
	public void clickOnCompaignModule() {
		new Actions(driver).moveToElement(moreModule).perform();
		compaignModule.click();
	}
	
	public void clickOnVendorModule() {
		new Actions(driver).moveToElement(moreModule).perform();
		vendorsModule.click();
	}
	
	public void clickOnSalesModule() {
		new Actions(driver).moveToElement(moreModule).perform();
		salesOrderModule.click();
	}
	
	public void clickOnSignOut() {
		new Actions(driver).moveToElement(adminitratorImage).perform();
		signOutModule.click();
	}	
	
}
