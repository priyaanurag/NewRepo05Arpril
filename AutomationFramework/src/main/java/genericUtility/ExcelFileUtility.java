package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	
	
	
	public String toReadDatafromExcelFile(String sheetname ,int row ,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestDataforVtiger.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		String sheetvalue = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return sheetvalue;
	}

}
