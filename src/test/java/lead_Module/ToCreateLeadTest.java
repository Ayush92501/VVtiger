package lead_Module;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pom_class.CreatingNewLeadPage;
import pom_class.HomePage;
import pom_class.LeadInformationPage;
import pom_class.LeadsPage;
@Listeners(genericUtility.ListenersImplementationClass.class)
public class ToCreateLeadTest extends BaseClass {
	
	@Test//(retryAnalyzer=genericUtility.RetryImplementationClass.class)
	public void toCreateALeadAndToVerifyLeadInformationTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String leadSalutation=eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 1, 5);
		System.out.println(leadSalutation  );
		
		String leadFirstName=eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 1, 1);
		System.out.println(leadFirstName);
		String leadLastName=eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 1, 2);
		System.out.println(leadLastName);
		String companyName=eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 1, 3);
		System.out.println(companyName);
		String industryName=eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 1, 4);
		System.out.println(industryName);
		
		HomePage home=new HomePage(driver);
		LeadsPage lead = new LeadsPage(driver);
		CreatingNewLeadPage createLead = new CreatingNewLeadPage(driver);
		LeadInformationPage leadInfo = new LeadInformationPage(driver);
		
		
	     	home.clickOnLeadModule();
	     	
		lead.clickOnLeadPlusButton();
		//Assert.fail();
		wUtils.waitForPageToLoad(driver);
	
		createLead.enterCompanyName(companyName);
	
	
		createLead.enterFirstName(leadFirstName);
		createLead.enterLastName(leadLastName);
		createLead.passIndustryNameInIndustryDropdown(industryName);
		createLead.passLeadNameSalutationDropdown(leadSalutation);
		createLead.clickOnSaveButton();
		
		String actualLeadName=leadInfo.verifyLeadInformationPage(leadLastName);
		
		Assert.assertTrue(actualLeadName.contains(leadLastName));
		//if(actualLeadName.contains(leadLastName))
		System.out.println("The Lead information has been verified");
		
	}
	/*@Test//(retryAnalyzer=genericUtility.RetryImplementationClass.class)
	public void demo1() {
		System.out.println("Demo1 method is running");
		Assert.fail();
	}
	
	@Test
	public void demo2() {
		System.out.println("Demo2 method is running");
		Assert.fail();
	}
	
	
	@Test
	public void demo3() {
		System.out.println("Demo3 method is running");
		Assert.fail();
	}*/
	
	
}
