package genericUtility;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer {
	int limit=1;
	int count=0;
	public boolean retry(ITestResult result) {
		System.out.println("RetryImplementation Class is running");
		while(count<limit) {
			count++;
			return true;
		}
		return false;
	}

}
