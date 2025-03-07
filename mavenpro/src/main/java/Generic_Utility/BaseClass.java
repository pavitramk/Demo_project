package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;

public class BaseClass {

public static WebDriver_Utility wlib = new WebDriver_Utility();
public static Excel_utility elib = new Excel_utility();
public static Java_Utility jlib = new Java_Utility();
public static File_Utility flib = new File_Utility();
public static WebDriver driver;

	@BeforeSuite
	public void BS() {
		System.out.println("DataBase connection");
	}

	@BeforeTest
	public void BT() {
		System.out.println("Parallel execution");
	}

	@BeforeClass
	public void BC() throws Throwable {

		String BROWSER = flib.getCommonData("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		System.out.println("Launching Browser");
	}

	@BeforeMethod
	public void BM() throws Throwable {

	
		String URL = flib.getCommonData("url");
		String USERNAME = flib.getCommonData("username");
		String PASSWORD = flib.getCommonData("password");
		wlib.maximizeWindow(driver);
		wlib.loadTheElements(driver);

		driver.get(URL);

		// using Business Logics
		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(USERNAME, PASSWORD);

	}
	

	@AfterMethod
	public void AM() {
		HomePage home = new HomePage(driver);
		home.logOut(driver);
		System.out.println("Logout from App");
	}

	@AfterClass
	public void AC() {
		driver.quit();
		System.out.println("Close the browser");
	}

	@AfterTest
	public void AT() {
		System.out.println("Parallel execution");
	}

	@AfterSuite
	public void AS() {
		System.out.println("DataBase Connection close");
	}

}
