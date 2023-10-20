package genericUtility;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {
public int generateRandoNo(int limit) {
		
		Random random = new Random();
		return random.nextInt(limit);
		
	}
	
  public String generateSystemDateTime() {
	Date date=new Date();
	
	//System.out.println(date.toString().replace(" ", "_").replace(":", "_"));
	return date.toString().replace(" ", "_").replace(":", "_");
	//Sun Oct 15 13:38:01 IST 2023
	//Sun_Oct_15_13_42_06_IST_2023
}
}
