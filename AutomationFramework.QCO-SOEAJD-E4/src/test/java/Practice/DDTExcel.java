package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

public class DDTExcel {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\sandip\\Desktop\\TestData.xlsx");
		 Workbook book=WorkbookFactory.create(fis);
		    Sheet sheet=book.getSheet("Sheet1");
		    Row row=sheet.getRow(1);
		    Cell cel=row.getCell(3);
		    String value=cel.getStringCellValue();
		    System.out.println(value);
		    book.close();

	}

}
