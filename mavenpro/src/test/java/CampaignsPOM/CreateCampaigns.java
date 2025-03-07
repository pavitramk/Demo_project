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
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;

public class CreateCampaigns {
	public static void main(String[] args) throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		Excel_utility elib = new Excel_utility();
		Java_Utility jlib = new Java_Utility();
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

		// using Business Logics
		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(USERNAME, PASSWORD);

		HomePage home = new HomePage(driver);
		home.clickCampLink();

		CampLookUpImg campImg = new CampLookUpImg(driver);
		campImg.clickCampLookUpImg();

		int ranNum = jlib.getRandomValue();

		String campNAme = elib.getExcelData("Campaigns", 0, 0) + ranNum;

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampName(campNAme);
		campPage.clickSaveButton();

		CampValidatePage validate = new CampValidatePage(driver);
		validate.ValidateCamp(driver, campNAme);

		home.logOut(driver);
		
		driver.quit();
		
	}


}
