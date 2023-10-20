package pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}
	
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public void loginAction(String username,String password) throws InterruptedException {
         //usernameTextField.clear();
		//Thread.sleep(5000);
		usernameTextField.sendKeys(username);
		//Thread.sleep(5000);
		//passwordTextField.clear();
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
}
