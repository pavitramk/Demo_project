package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {

	public CreateCampPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "campaignname")
	private WebElement campName;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getCampName() {
		return campName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void enterCampName(String name)
	{
		campName.sendKeys(name);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
}
