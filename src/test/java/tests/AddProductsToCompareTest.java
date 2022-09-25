package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ComparePage;
import Pages.Homepage;
import Pages.ProductsDetailsPage;
import Pages.SearchPage;

public class AddProductsToCompareTest  extends TestBase {
	SearchPage searchobject;
	ProductsDetailsPage detailsobject;
	ComparePage compareobject;
	Homepage homepage;
	
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	
// 1- first product number 1
	@Test (priority = 1 )
	public void UserCanSearchWithAutoSugguest() 
	{
		try {
			searchobject = new SearchPage(driver);	
			detailsobject = new ProductsDetailsPage(driver);
			compareobject = new ComparePage(driver);
			
			searchobject.ProductSearchUsingAutoSuggest("MacB");
			Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), firstProductName);
			detailsobject.AddProductToCompareList();
			
			searchobject.ProductSearchUsingAutoSuggest("Asus");
			Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), secondProductName);
			detailsobject.AddProductToCompareList();
			Thread.sleep(1000);
			
			driver.navigate().to("https://demo.nopcommerce.com"+"/compareproducts");
			Assert.assertTrue(compareobject.firstProductName.getText().equals("Asus N551JK-XO076H Laptop"));
			Assert.assertTrue(compareobject.secodProductName.getText().equals("Apple MacBook Pro 13-inch"));
			compareobject.CompareProducts();
		} catch (Exception e) {
			System.out.println("Error occured " + e.getMessage());
		}
	}
	@Test (priority = 2 )
	public void UserCanClearCompareList() 
	{
		compareobject.clearCompareList();
	}
	
}
