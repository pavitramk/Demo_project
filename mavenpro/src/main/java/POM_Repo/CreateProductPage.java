package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement plusSign;
	
	@FindBy(name = "productname")
	private WebElement prdName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getPlusSign() {
		return plusSign;
	}

	public WebElement getPrdName() {
		return prdName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void clickOnPlusSign()
	{
		plusSign.click();
	}
	public void enterProductName(String productName)
	{
		prdName.sendKeys(productName);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
}
