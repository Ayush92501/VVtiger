package genericUtility;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.IMPLICIT_WAIT));
	}
	
	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitForElemenetToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void waitForElementToCustom(WebDriver driver, int pollingTime, WebElement element) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofMillis(IPathConstant.POLLING_PERIOD));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void switchToWindow(WebDriver driver, String partialWindow) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wTle = it.next();
			driver.switchTo().window(wTle);
			String currentWindow = driver.getTitle();
			if (currentWindow.contains(partialWindow)) {
				break;
			}
		}
	}
	
}
