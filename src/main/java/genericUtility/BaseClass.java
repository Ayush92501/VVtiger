       package genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysql.jdbc.Driver;

import pom_class.HomePage;
import pom_class.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	public JavaUtility jUtils = new JavaUtility();
	DataBaseUtility database=new DataBaseUtility();
	public static WebDriver sdriver;
	public Connection connection;
	@BeforeSuite(groups="regression")
public void bsConfig() throws SQLException {
			// 1. Creating an object of Driver of MY SQL vendor
			Driver dataBaseDriver = new Driver();
			// 2. Registering driver to JDBC API
			DriverManager.registerDriver(dataBaseDriver);
			// 3. Establishing connection with the data base
			connection = DriverManager.getConnection(IPathConstant.JDBC_URL, "root", "root");
			/*System.out.println("The Data base connection has been established");
			database.updateDataInDataBase(connection, "insert into lead values('Chandan','Roy','Wipro');");
			database.fetchDataFromDataBase(connection, "select* from lead", 1);*/
		
	}
	
	@BeforeClass(groups={"smoke","regression"})
public void bcConfig() throws IOException {
		
		String browser = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");

		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		System.out.println("The "+browser+" browser has been launched");
		wUtils.waitForPageToLoad(driver);
		wUtils.maximizeTheWindow(driver);
		driver.get(url);
		System.out.println("The user has navigated to "+url);
		
	}
	
	
	@BeforeMethod(groups={"smoke","regression"})
	public void bmConfig() throws IOException, InterruptedException {
		sdriver=driver;
		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");
		
		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("The login was successfull");
		
	}
	
	@AfterMethod(groups={"smoke","regression"})
	public void amConfig() {
		HomePage home=new HomePage(driver);
		home.clickOnSignOut();
		System.out.println("The user has logged out successfully");
	}
	
	@AfterClass(groups={"smoke","regression"})
	public void acConfig() throws IOException {
		String browser = fUtils.fetchDataFromPropertyFile("browser");
		driver.quit();
		System.out.println("The "+browser+" browser has been closed");
		
	}
	
	@AfterSuite(groups={"smoke","regression"})
	public void asConfig() {
		
	}
	
	
	
	
	
}
