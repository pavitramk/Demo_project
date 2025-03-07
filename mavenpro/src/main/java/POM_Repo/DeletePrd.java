package POM_Repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePrd {
	public DeletePrd(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath = "//input[@value='Delete']")
private WebElement deletePrd;

	public void selectPrdCheckBox(WebDriver driver,String prdName)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prdName+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
	}
	
	public void clickOnDeleteButton()
	{
		deletePrd.click();
	}
	
	public void ValidatePrdName(WebDriver driver,String prdData)
	{
		List<WebElement> allprd = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		boolean flag=false;
		
		for (WebElement prdName : allprd)
		{
			String actData = prdName.getText();
			if(actData.contains(prdData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Product data is deleted");
		}
		else
		{
			System.out.println("Product data is not deleted");
		}
		
	}
}
