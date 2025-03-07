package Organizations_Utility;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;

public class CreateOrganization {
	public static void main(String[] args) throws Throwable {

//		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesData3pm.properties");
//
//		// step2:- load all the keys from properties file
//		Properties pro = new Properties();
//		pro.load(fis);
//
//		// step3:- get keys from properties file
//		String BROWSER = pro.getProperty("browser");
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");


		File_Utility flib = new File_Utility();
		String BROWSER = flib.getCommonData("browser");
		String URL = flib.getCommonData("url");
		String USERNAME = flib.getCommonData("username");
		String PASSWORD = flib.getCommonData("password");
		
		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Random Approach
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
//
////step1:- connecting the excel file
//		FileInputStream file = new FileInputStream("./src/test/resources/ExcelData3.xlsx");
//
//		// step2:- keep excel in read mode
//		Workbook book = WorkbookFactory.create(file);
//
//		// step3:- navigate into excel sheet
//		Sheet sheet = book.getSheet("Organization");
//
//		// step4:- navigate into row
//		Row row = sheet.getRow(0);
//
//		// step5:-navigate into cell
//		Cell cell = row.getCell(0);
//
//		String OrgName = cell.getStringCellValue() + ranNum;
//		System.out.println(OrgName);
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomValue();
		Excel_utility elib = new Excel_utility();
		String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
//-----------------------------------------------------------------------------------------------

		// step4:- navigate into row
	//	Row row1 = sheet.getRow(1);

		// step5:-navigate into cell
	//	Cell cell1 = row1.getCell(0);

//		DataFormatter format = new DataFormatter();
//		String phnNum = format.formatCellValue(cell1);
//		System.out.println(phnNum);
		String phnNum = elib.readDataUsingDataFormatter("Organization", 1, 0);
		driver.findElement(By.name("phone")).sendKeys(phnNum);
//-------------------------------------------------------------------------------------------------
//		Row row2 = sheet.getRow(2);
//
//// step5:-navigate into cell
//		Cell cell2 = row2.getCell(0);
//
//		String mailId = cell2.getStringCellValue();
	//	System.out.println(mailId);
		String mailId = elib.readDataUsingDataFormatter("Organization", 2, 0);
		
		driver.findElement(By.id("email1")).sendKeys(mailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//------------------------------------------------------------------------------------------
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

		if (actData.contains(OrgName)) {
			System.out.println("Organization is created");
		} else {
			System.out.println("Organization is not created");
		}

		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}



}
