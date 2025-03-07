package Products_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.CreateProductPage;
import POM_Repo.DeletePrd;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;

public class CreateProductandDeletePOM {
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
		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();
     
        int ranNum = jlib.getRandomValue();
		
        String prdData = elib.getExcelData("Product", 0, 0)+ranNum;
        prdPage.enterProductName(prdData);
        prdPage.clickOnSaveButton();
		      
        home.clickPrdLink();
    
        DeletePrd delete = new DeletePrd(driver);
        delete.selectPrdCheckBox(driver, prdData);
        //driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td/input[@type='checkbox']")).click();
        //driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prdData+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
        
        delete.clickOnDeleteButton();
        wlib.alertAccept(driver);

        delete.ValidatePrdName(driver, prdData);
        Thread.sleep(1000);
	
         home.logOut(driver);

	}
}
