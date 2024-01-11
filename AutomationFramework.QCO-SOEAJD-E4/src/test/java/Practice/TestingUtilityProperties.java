package Practice;

import java.io.IOException;

import UtilityMethods.ReadingFromExcel;
import UtilityMethods.ReadingFromPropertyFile;

public class TestingUtilityProperties {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		ReadingFromPropertyFile u=new ReadingFromPropertyFile();
		String value = u.utilityPro("username");
		System.out.println(value);
		
		ReadingFromExcel data=new ReadingFromExcel();
		String excelData = data.UtilityMethod("Sheet1",1,5);
		System.out.println(excelData);
		

	}

}
