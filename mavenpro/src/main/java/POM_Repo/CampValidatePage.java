package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampValidatePage {
	public CampValidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateCamp(WebDriver driver,String campName)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		if (actData.contains(campName)) {
			System.out.println("campagin name is created");
		} else {
			System.out.println("Campaign name is not created");
		}
		
	}
	
	public void ValidatePrd(WebDriver driver,String prdName)
	{
		String data = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();

		if (data.contains(prdName)) {
			System.out.println("Product name is created");
		} else {
			System.out.println("Product name is not created");
		}
	}
}
