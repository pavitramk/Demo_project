package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampWithPrdWindowSwitching {
	public CampWithPrdWindowSwitching(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath = "//img[@alt='Select']")
private WebElement prdPlusSign;

@FindBy(name="search_text")
private WebElement enterPrdName;

@FindBy(name="search")
private WebElement searchPrd;

public WebElement getPrdPlusSign() {
	return prdPlusSign;
}

public WebElement getEnterPrdName() {
	return enterPrdName;
}

public WebElement getSearchPrd() {
	return searchPrd;
}
/**
 * 
 */
public void clickOnPrdPlusSign()
{
	prdPlusSign.click();
}

public void enterPrdName(String name)
{
	enterPrdName.sendKeys(name);
}

public void searchPrdName()
{
	searchPrd.click();
}

public void prdDynamicElement(WebDriver driver,String name)
{
	 driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		
}
}
