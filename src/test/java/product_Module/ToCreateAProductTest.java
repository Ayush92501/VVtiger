package product_Module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pom_class.CreatingNewProductPage;
import pom_class.CreatingNewVendorPage;
import pom_class.HomePage;
import pom_class.ProductInformationPage;
import pom_class.ProductPage;
import pom_class.VendorInformationPage;
import pom_class.VendorPage;
@Listeners(genericUtility.ListenersImplementationClass.class)
public class ToCreateAProductTest extends BaseClass{
	@Test//(retryAnalyzer=genericUtility.RetryImplementationClass.class,groups="regression",priority=2)
	public void toCreateAProductWithVendorInformationTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String path=eUtils.fetchStringDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 1, 4);
		String vendorName=eUtils.fetchStringDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 1, 0);
		String productName=eUtils.fetchStringDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME,1,1);
		String salesStartDate=eUtils.fetchStringDateDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 1, 2);
		String salesEndDate=eUtils.fetchStringDateDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME,1,3);
		System.out.println(salesStartDate);
		System.out.println(salesEndDate);
		System.out.println(path);
		
	 HomePage home=new HomePage(driver);
	 VendorPage vPage=new VendorPage(driver);
	CreatingNewVendorPage newVPage=new CreatingNewVendorPage(driver);
	VendorInformationPage vInfoPage=new VendorInformationPage(driver);
	ProductPage productPage=new ProductPage(driver);
	CreatingNewProductPage newPPage=new CreatingNewProductPage(driver);
	ProductInformationPage pInfoPage=new ProductInformationPage(driver);
	home.clickOnVendorModule();
	Assert.fail();
	vPage.clickOnVendorPlusButton();
	newVPage.enterVendorName(vendorName);
	newVPage.clickOnSaveButton();
	String actualVendorName=vInfoPage.verifyVendorInformation(vendorName);
	Assert.assertTrue(actualVendorName.contains(vendorName));
	System.out.println("Pass :The Vendor is created");
	
	home.clickOnProductModule();
	productPage.clickOnVendorPlusButton();
	newPPage.enterProductName(productName);
	newPPage.enterSalesStartDate(salesStartDate);
	newPPage.enterSalesEndDate(salesEndDate);
	newPPage.clickOnVendorLookUpPlusButton();
	//Thread.sleep(5000);
	newPPage.selectVendorNameFromLookPage("Vendors&action", vendorName, "Products&action");
	//Thread.sleep(5000);
	newPPage.uploadImage(path);
	newPPage.clickOnSaveButton();
	String actualProductName=pInfoPage.verifyProductInformation(productName);
	Assert.assertTrue(actualProductName.contains(productName));
	
	System.out.println("Pass:  Product name is verified");
	
	
	} 
	
}
