package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUpImg {
	public ProductLookUpImg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[alt=\"Create Product...\"]")
	private WebElement prdlookUp;
	
	public void prdLookUpImg()
	{
		prdlookUp.click();
	}
}
