package Practice_selenium;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {
	public static void main(String[] args) throws Throwable {

		// step1:- connecting the excel file
		FileInputStream file = new FileInputStream("./src/test/resources/Book1Test.xlsx");

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(file);

		// step3:- navigate into excel sheet
		Sheet sheet = book.getSheet("Sheet1");

		int rowNum = sheet.getLastRowNum();
		for (int i = 0; i < rowNum; i++) 
		{
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			String links = cell.getStringCellValue();
		System.out.println(links);
		}
		
	
	}

}
