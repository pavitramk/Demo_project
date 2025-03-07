package TestNG_vtigerApp;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;

import POM_Repo.CreateOrganizationPage;
import POM_Repo.HomePage;
import POM_Repo.OrgLookUp;
import POM_Repo.ValidationAndVerificationPage;

public class CreateOrganization extends BaseClass {
		@Test
		public void createOrganization() throws Throwable {
		
			HomePage home = new HomePage(driver);
			home.clickOrganizationLink();

			OrgLookUp lookUp = new OrgLookUp(driver);
			lookUp.clickOrgLookUp();

			int ranNum = jlib.getRandomValue();

			String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;

			driver.findElement(By.name("accountname")).sendKeys(OrgName);
	////-----------------------------------------------------------------------------------------------
	//
			String phnNum = elib.readDataUsingDataFormatter("Organization", 1, 0);

			String mailId = elib.getExcelData("Organization", 2, 0);

			CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
			orgPage.enterOrganizationData(OrgName, phnNum, mailId);
			orgPage.clickOnSaveButton();
	//------------------------------------------------------------------------------------------

			ValidationAndVerificationPage validate = new ValidationAndVerificationPage(driver);
			validate.orgValidation(driver, OrgName);

		}
}
