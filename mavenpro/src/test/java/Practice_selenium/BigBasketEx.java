package Practice_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasketEx {
	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//input[@placeholder='Search for Products...'])[2]")).sendKeys("Apples");

		Thread.sleep(2000);
//		List<WebElement> allEle = driver.findElements(By.xpath("//ul[@class=\"overscroll-contain\"]//li"));

		List<WebElement> allEle = driver.findElements(
				By.xpath("//span[@class='Label-sc-15v1nk5-0 QuickSearch___StyledLabel2-sc-rtz2vl-7 gJxZPQ gFDEBU']"));

		for (WebElement ele : allEle) {
			String apple = ele.getText();
			System.out.println(apple);

			if (ele.getText().equals("Apple - Shimla, Regular")) {
				ele.click();
				break;
			}

		}
		Thread.sleep(1000);

		WebElement add = driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]"));

		add.click();
	}



}
