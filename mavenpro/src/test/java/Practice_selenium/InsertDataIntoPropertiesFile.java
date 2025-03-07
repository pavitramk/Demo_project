package Practice_selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {

		// Keeping the properties file in read mode
		Properties pro = new Properties();
		pro.setProperty("browser", "edge");
		pro.setProperty("url", "https://www.flipkart.com");

		//inserting data into properties file
		FileOutputStream fos = new FileOutputStream("./src/test/resources/browser.properties");
		//FileInputStream fis;
		
//----------------------------------------------------------------------------------------------------------------
		FileInputStream fis = new FileInputStream("./src/test/resources/browser.properties");
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
		driver=new FirefoxDriver();	
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		
		
		
	}
}
