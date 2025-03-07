package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.shoppersstack.com/");
		
		driver.manage().window().maximize();

		//xpath with single attribute
		driver.findElement(By.xpath("//button[@id='loginBtn']")).click();
		
		//xpath with multiple attribute
		
		//driver.findElement(By.xpath("//button[@id='loginBtn'][@name='loginBtn']")).click();
		
							
		
	}

}
