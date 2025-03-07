package Practice_selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcel {
public static void main(String[] args) throws Throwable {
		
		// step1:- connecting the excel file
				FileInputStream file = new FileInputStream("./src/test/resources/Book1Test.xlsx");

				// step2:- keep excel in read mode
				Workbook book = WorkbookFactory.create(file);

				// step3:- navigate into excel sheet
				Sheet sheet = book.getSheet("Sheet1");
				
				Row row = sheet.createRow(5);
				
				Cell cell = row.createCell(3);
				
				cell.setCellValue("Nike");
				
				FileOutputStream fos = new FileOutputStream("./src/test/resources/Book1Test.xlsx");
				book.write(fos);
				book.close();
				
	}

}
