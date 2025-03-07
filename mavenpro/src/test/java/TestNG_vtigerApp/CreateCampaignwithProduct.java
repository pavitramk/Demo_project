package TestNG_vtigerApp;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;

import POM_Repo.CampLookUpImg;
import POM_Repo.CampValidatePage;
import POM_Repo.CreateCampPage;
import POM_Repo.CreateProductPage;
import POM_Repo.HomePage;
import POM_Repo.ProductLookUpImg;
import POM_Repo.WindowSwitchingPage;

public class CreateCampaignwithProduct extends BaseClass{
	@Test
	public void createCampaignsProduct() throws Throwable {
		HomePage home = new HomePage(driver);
		home.clickPrdLink();

		ProductLookUpImg lookUp = new ProductLookUpImg(driver);
		lookUp.prdLookUpImg();

		int ranNum = jlib.getRandomValue();
		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterProductName(PrdName);
		prdPage.clickOnSaveButton();
		// ---------------------------------------------------------------------------------------------------

		home.clickCamp();

		CampLookUpImg lookUp1 = new CampLookUpImg(driver);
		lookUp1.clickCampLookUpImg();

		String campNAme = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		// driver.findElement(http://By.name("campaignname")).sendKeys(campNAme);

		WindowSwitchingPage window = new WindowSwitchingPage(driver);
		window.clickPrdPlusSign();

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampName(campNAme);

		wlib.windowSwitching(driver, "Products&action");
		window.enterPrdName(PrdName);
		window.clickprdSearchBar();
		window.selectPrdName(driver, PrdName);

		wlib.windowSwitching(driver, "Campaigns&action");
		campPage.clickSaveButton();

		CampValidatePage Validatecamp = new CampValidatePage(driver);
		Validatecamp.ValidateCamp(driver, campNAme);
		Validatecamp.ValidatePrd(driver, PrdName);


	}
}
