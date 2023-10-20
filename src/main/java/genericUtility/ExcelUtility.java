package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String fetchStringDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new  FileInputStream("C:\\SaleniumJava\\Akash\\VVtiger\\src\\test\\resources\\testingExData\\TestingData.xlsx");
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();

	}
	
	public long fetchNumericDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new  FileInputStream("C:\\SaleniumJava\\Akash\\VVtiger\\src\\test\\resources\\testingExData\\TestingData.xlsx");
		return (long)WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	
	public boolean fetchBooleanDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new  FileInputStream("C:\\SaleniumJava\\Akash\\VVtiger\\src\\test\\resources\\testingExData\\TestingData.xlsx");
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
	}
	
	public String fetchStringDateDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new  FileInputStream("C:\\SaleniumJava\\Akash\\VVtiger\\src\\test\\resources\\testingExData\\TestingData.xlsx");
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getLocalDateTimeCellValue().toString().substring(0,10);
	}
}
