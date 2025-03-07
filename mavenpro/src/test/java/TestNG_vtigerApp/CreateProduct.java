package TestNG_vtigerApp;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import POM_Repo.CreateProductPage;
import POM_Repo.HomePage;
import POM_Repo.ProductLookUpImg;

public class CreateProduct extends BaseClass{
	
	@Test
	public void Createproductpage() throws Throwable
	{
		
	HomePage home = new HomePage(driver);
	home.clickPrdLink();

	ProductLookUpImg lookUp = new ProductLookUpImg(driver);
	lookUp.prdLookUpImg();
	

	int ranNum = jlib.getRandomValue();
	String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;

	CreateProductPage prdPage = new CreateProductPage(driver);
	
	
	prdPage.enterProductName(PrdName);
	prdPage.clickOnSaveButton();

	
}
}

