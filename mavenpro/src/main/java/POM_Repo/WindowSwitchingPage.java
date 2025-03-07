package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchingPage {

	public WindowSwitchingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[alt=\"Select\"]")
	private WebElement selectPrd;

	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement enterPrd;

	@FindBy(name = "search")
	private WebElement prdSearchBar;

	
	public void clickPrdPlusSign() {
		selectPrd.click();
	}

	public WebElement getSelectPrd() {
		return selectPrd;
	}

	public WebElement getEnterPrd() {
		return enterPrd;
	}

	public WebElement getPrdSearchBar() {
		return prdSearchBar;
	}

	public void enterPrdName(String name)
	{
		enterPrd.sendKeys(name);
	}

	public void clickprdSearchBar()
	{
		prdSearchBar.click();
	}
	public void selectPrdName(WebDriver driver, String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']")).click();
	}
}
