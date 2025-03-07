package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campLink;

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Products")
	private WebElement prdLink;

	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement admLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampLink() {
		return campLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getPrdLink() {
		return prdLink;
	}

	public WebElement getAdmLink() {
		return admLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	public void clickMoreLink()
	{
		moreLink.click();
	}
	// BusinessLogics
	public void clickCampLink() {
		moreLink.click();
		campLink.click();
	}

	public void logOut(WebDriver driver) {
			admLink.click();
			signOutLink.click();
	    
	}
	
	public void clickPrdLink()
	{
		prdLink.click();
	}
	
	public void clickOrganizationLink() {
		orgLink.click();
	}
	
	public void clickCamp()
	{
	moreLink.click();
	campLink.click();
	}
	
	public void clickAdmImg()
	{
		admLink.click();
	}
	
	public void clickOnSignOut()
	{
		signOutLink.click();
	}
}
