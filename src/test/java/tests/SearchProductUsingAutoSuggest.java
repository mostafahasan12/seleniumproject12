package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductsDetailsPage;
import Pages.SearchPage;

public class SearchProductUsingAutoSuggest  extends TestBase{
	SearchPage searchobject;
	ProductsDetailsPage detailsobject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test 
	public void UserCanSearchWithAutoSugguest() 
	{
		try {
			searchobject = new SearchPage(driver);
			searchobject.ProductSearchUsingAutoSuggest("MacB");
			detailsobject = new ProductsDetailsPage(driver);
			Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occured " + e.getMessage());
		}		
	}	
}
