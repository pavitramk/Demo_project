package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUp {
	
 public OrgLookUp(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[title=\"Create Organization...\"]")
	private WebElement lookUpI;

	public WebElement getLookUpImg() {
		return lookUpI;
	}

	public void clickCampLookUpImg() {
		lookUpI.click();
	}

	public void clickOrgLookUp() {
		lookUpI.click();
		// TODO Auto-generated method stub
		
	}
}
