package TestNG_vtigerApp;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import POM_Repo.CreateProductPage;
import POM_Repo.DeletePrd;
import POM_Repo.HomePage;

public class CreateProductandDelete extends BaseClass{

	@Test 
	public void Productcreatedelete () throws Throwable
	{
	HomePage home = new HomePage(driver);
	home.clickPrdLink();
	
	CreateProductPage prdPage = new CreateProductPage(driver);
	prdPage.clickOnPlusSign();
 
    int ranNum = jlib.getRandomValue();
	
    String prdData = elib.getExcelData("Product", 0, 0)+ranNum;
    prdPage.enterProductName(prdData);
    prdPage.clickOnSaveButton();
	      
    home.clickPrdLink();

    DeletePrd delete = new DeletePrd(driver);
    delete.selectPrdCheckBox(driver, prdData);
    
    delete.clickOnDeleteButton();
    wlib.alertAccept(driver);

    delete.ValidatePrdName(driver, prdData);
    Thread.sleep(1000);
}
}
