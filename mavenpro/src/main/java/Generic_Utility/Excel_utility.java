package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {

	
	/**
	 * This method is used to read data from excel file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws Throwable
	 * @author Shobha
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
	// step1:- connecting the excel file
			FileInputStream file = new FileInputStream("./src/test/resources/Book1Test.xlsx");

			// step2:- keep excel in read mode
			Workbook book = WorkbookFactory.create(file);

			// step3:- navigate into excel sheet
			Sheet sheet = book.getSheet(sheetName);

			// step4:- navigate into row
			Row row = sheet.getRow(rowNum);

			// step5:-navigate into cell
			Cell cell = row.getCell(cellNum);

			String excelData = cell.getStringCellValue();
			System.out.println(excelData);
			return excelData;
}
//-----------------------------------------------------------------------------------------------------------	
	public String readDataUsingDataFormatter(String sheetName,int rowNum,int cellNum ) throws Throwable
	{
		FileInputStream file = new FileInputStream("./src/test/resources/Book1Test.xlsx");

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(file);

		// step3:- navigate into excel sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- navigate into row
		Row row = sheet.getRow(rowNum);

		// step5:-navigate into cell
		Cell cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		System.out.println(ExcelData);
		return ExcelData;

	}
}