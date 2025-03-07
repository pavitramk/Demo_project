package CampaignsPOM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.CampLookUpImg;
import POM_Repo.CampValidatePage;
import POM_Repo.CreateCampPage;
import POM_Repo.CreateProductPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.ProductLookUpImg;
import POM_Repo.WindowSwitchingPage;

public class CreateCampaignWithProduct {
	public static void main(String[] args) throws Throwable {

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_utility elib = new Excel_utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

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
		home.clickPrdLink();

		ProductLookUpImg lookUp = new ProductLookUpImg(driver);
		lookUp.prdLookUpImg();

		int ranNum = jlib.getRandomValue();
		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterProductName(PrdName);
		prdPage.clickOnSaveButton();
		// ---------------------------------------------------------------------------------------------------

		home.clickCamp();

		CampLookUpImg lookUp1 = new CampLookUpImg(driver);
		lookUp1.clickCampLookUpImg();

		String campNAme = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		// driver.findElement(http://By.name("campaignname")).sendKeys(campNAme);

		WindowSwitchingPage window = new WindowSwitchingPage(driver);
		window.clickPrdPlusSign();

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampName(campNAme);

		wlib.windowSwitching(driver, "Products&action");
		window.enterPrdName(PrdName);
		window.clickprdSearchBar();
		window.selectPrdName(driver, PrdName);

		wlib.windowSwitching(driver, "Campaigns&action");
		campPage.clickSaveButton();

		CampValidatePage Validatecamp = new CampValidatePage(driver);
		Validatecamp.ValidateCamp(driver, campNAme);
		Validatecamp.ValidatePrd(driver, PrdName);

		home.logOut(driver);
		driver.quit();

	}

}
