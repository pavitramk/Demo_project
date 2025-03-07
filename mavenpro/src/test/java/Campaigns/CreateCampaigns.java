package Campaigns;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateCampaigns {
	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/browser.properties");

		// step2:- load all the keys from properties file
		Properties pro = new Properties();
		pro.load(fis);

		// step3:- get keys from properties file
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

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

		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.cssSelector("[title=\"Create Campaign...\"]")).click();

		// Random Approach
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

//step1:- connecting the excel file
		FileInputStream file = new FileInputStream("./src/test/resources/Book1Test.xlsx");

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(file);

		// step3:- navigate into excel sheet
		Sheet sheet = book.getSheet("Campaigns");

		// step4:- navigate into row
		Row row = sheet.getRow(0);

		// step5:-navigate into cell
		Cell cell = row.getCell(0);

		String campNAme = cell.getStringCellValue() + ranNum;
		System.out.println(campNAme);
		driver.findElement(By.name("campaignname")).sendKeys(campNAme);

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		if (actData.contains(campNAme)) {
			System.out.println("campagin name is created");
		} else {
			System.out.println("Campaign name is not created");
		}

		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}


}
