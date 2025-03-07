package day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class Testcase_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//open and close the website 
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.shoppersstack.com/");
		
		String actual=driver.getTitle();
		
			if(actual.equals("ShoppersStack"))
			{
				System.out.println("test passed");
			}
			else
			{
				System.out.println("test failed");
				
			}
			
		driver.close();
		
		
	}

}
