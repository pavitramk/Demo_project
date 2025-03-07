package Organization_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.CreateOrganizationPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.OrgLookUp;
import POM_Repo.ValidationAndVerificationPage;

public class CreateOrganizationPOM {

	public static void main(String[] args) throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();

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
		wlib.maximizeWindow(driver);
		wlib.loadTheElements(driver);

		driver.get(URL);
			
	    	LoginPageEx login = new LoginPageEx(driver);
			login.loginToApp(USERNAME, PASSWORD);

			HomePage home = new HomePage(driver);
			home.clickOrganizationLink();

			OrgLookUp lookUp = new OrgLookUp(driver);
			lookUp.clickOrgLookUp();

			Java_Utility jlib = new Java_Utility();
			int ranNum = jlib.getRandomValue();

			Excel_utility elib = new Excel_utility();
			String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;

			driver.findElement(By.name("accountname")).sendKeys(OrgName);
	////-----------------------------------------------------------------------------------------------
	//
			String phnNum = elib.readDataUsingDataFormatter("Organization", 1, 0);

			String mailId = elib.getExcelData("Organization", 2, 0);

			CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
			orgPage.enterOrganizationData(OrgName, phnNum, mailId);
			orgPage.clickOnSaveButton();
	//------------------------------------------------------------------------------------------

			ValidationAndVerificationPage validate = new ValidationAndVerificationPage(driver);
			validate.orgValidation(driver, OrgName);

			home.logOut(driver);
		
		}
		
}
