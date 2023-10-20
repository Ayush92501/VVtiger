package genericUtility;
import genericUtility.TestUtil;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;
import genericUtility.TestUtil;
public class ListenersImplementationClass extends TestUtil implements ITestListener{
			
	JavaUtility jUtil=new JavaUtility();
	
	String sysTime=jUtil.generateSystemDateTime();
	public void onTestFailure(ITestResult result) {
		System.out.println("Listener Class is ruuning");
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(".//Screenshot//"+methodName+"_"+sysTime+".png");
		try {
			//FileUtils.copyFile(source, destination);
			Files.copy(source, destination);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

 }
