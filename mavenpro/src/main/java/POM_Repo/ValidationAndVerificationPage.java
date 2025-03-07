package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage {
	public ValidationAndVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
public void orgValidation(WebDriver driver, String data)
	{
String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();	
		
	    if(actData.contains(data))
	    {
	    	System.out.println("org data is passed");
	    }
	    else
	    {
	    	System.out.println("org data is not passed");
	    }
	}
}
