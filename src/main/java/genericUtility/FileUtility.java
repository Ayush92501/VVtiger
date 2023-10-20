package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String fetchDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\SaleniumJava\\Akash\\VVtiger\\src\\main\\resources\\commonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		 return prop.getProperty(key);
	}
	

}
