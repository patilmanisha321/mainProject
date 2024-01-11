package UtilityMethods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingFromExcel 
{
	public String UtilityMethod(String SheetName, int rowNo, int cellNo) throws Throwable, IOException
	{
	FileInputStream fis=new FileInputStream("C:\\Users\\sandip\\Desktop\\TestData.xlsx");
	 Workbook book=WorkbookFactory.create(fis);
	    Sheet sheet=book.getSheet(SheetName);
	    Row row=sheet.getRow(rowNo);
	    Cell cel=row.getCell(cellNo);
	    String value=cel.getStringCellValue();
		return value;
	}
 
}
