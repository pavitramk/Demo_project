package day1;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsPro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.shoppersstack.com/");
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.name("search")).sendKeys("mac");
		
		//boolean logoisdisplayed= driver.findElement(By.id("home")).isDisplayed();
		
		//driver.findElement(By.linkText("contact us")).click();
		
	List<WebElement> headerlinks=driver.findElements(By.className("menu_catMenu__KGwfB"));
	System.out.println("number of links"+headerlinks.size());
	
	
	List<WebElement> tagnaelinks=driver.findElements(By.tagName("a"));
	System.out.println("number of links"+tagnaelinks.size());
	


	}

}
