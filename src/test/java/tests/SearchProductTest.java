package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.ProductsDetailsPage;
import Pages.SearchPage;

public class SearchProductTest extends TestBase {
String productName = "Apple MacBook Pro 13-inch";
SearchPage searchobject;
ProductsDetailsPage detailsobject;

@Test 
public void UserCanSearchForProducts()
{
	searchobject = new SearchPage(driver);
	detailsobject = new ProductsDetailsPage(driver);
	searchobject.productsearch(productName);
	searchobject.openProductdetailspage();
	Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productName));
//	Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
}
}
