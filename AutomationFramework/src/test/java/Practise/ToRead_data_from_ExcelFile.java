package Practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToRead_data_from_ExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestDataforVtiger.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		String lastname = wb.getSheet("Contacts").getRow(0).getCell(2).getStringCellValue();
		
		System.out.println(lastname);
		
		
	}

}
