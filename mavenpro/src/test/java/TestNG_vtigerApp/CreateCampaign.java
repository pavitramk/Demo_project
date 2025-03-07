package TestNG_vtigerApp;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.CampLookUpImg;
import POM_Repo.CampValidatePage;
import POM_Repo.CreateCampPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;

public class CreateCampaign extends BaseClass {

	@Test
	public void createCampaignsTest() throws Throwable {

		HomePage home = new HomePage(driver);
		home.clickCampLink();

		CampLookUpImg campImg = new CampLookUpImg(driver);
		campImg.clickCampLookUpImg();

		int ranNum = jlib.getRandomValue();

		String campNAme = elib.getExcelData("Campaigns", 0, 0) + ranNum;

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampName(campNAme);
		campPage.clickSaveButton();

		CampValidatePage validate = new CampValidatePage(driver);
		validate.ValidateCamp(driver, campNAme);

		
	}


}
