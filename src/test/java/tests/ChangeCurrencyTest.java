package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.ProductsDetailsPage;
import Pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
Homepage homeobject;
ProductsDetailsPage detailsobject;
SearchPage searchobject;

String productName = "Apple MacBook Pro 13-inch";


@Test (priority = 1)
public void UserCanChangeCurrency()
{
	homeobject = new Homepage(driver);
	homeobject.changeCurrency();
	}
@Test (priority = 2)
public void UserCanSearchWithAutoSugguest() 
{
	try {
		searchobject = new SearchPage(driver);
		searchobject.ProductSearchUsingAutoSuggest("MacB");
		detailsobject = new ProductsDetailsPage(driver);
		Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
		Assert.assertTrue(detailsobject.productpricelbl.getText().contains("€"));
	} catch (Exception e) {
		System.out.println("Error occured " + e.getMessage());
	}	
}
}
