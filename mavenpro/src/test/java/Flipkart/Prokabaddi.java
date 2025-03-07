package Flipkart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prokabaddi {


		public static void main(String[] args) throws Throwable {
			
			
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.prokabaddi.com/standings");
			driver.manage().window().maximize();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@aria-label=\"Close\"]")).click();

			//String won = driver.findElement(By.xpath("//p[text()='Patna Pirates']/ancestor::div[@class='row-head']//div[@class='table-data matches-won']")).getText();
			//System.out.println(won);
				
			//Dynamic xpath
			String teamName = "Patna Pirates";
			String won = driver.findElement(By.xpath("//p[text()='"+teamName+"']/ancestor::div[@class='row-head']//div[@class='table-data matches-won']")).getText();
			System.out.println(won);
				}
}

