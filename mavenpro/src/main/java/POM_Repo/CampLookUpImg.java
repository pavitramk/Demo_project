package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUpImg {

	public CampLookUpImg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[title=\"Create Campaign...\"]")
	private WebElement lookUpImg;

	public WebElement getLookUpImg() {
		return lookUpImg;
	}

	public void clickCampLookUpImg() {
		lookUpImg.click();
	}
}
