package Products_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.CampValidatePage;
import POM_Repo.CreateProductPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.ProductLookUpImg;

public class CreateProductPOM {
	
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
	
		
		
				Thread.sleep(3000);
				HomePage home1 = new HomePage(driver);
				home1.logOut(driver);
				//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				//driver.findElement(By.linkText("Sign Out")).click();
				driver.quit();
	}

}
