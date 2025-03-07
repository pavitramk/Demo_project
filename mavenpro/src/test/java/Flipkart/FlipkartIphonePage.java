package Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartIphonePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		WebElement searchBar = driver.findElement(By.id("q"));
		searchBar.sendKeys("iphone 15 pro max");
		searchBar.submit();
		
		driver.close();
	}

}
