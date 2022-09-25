package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.ProductsDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCart;

public class AddProductsToShoppingCartTest  extends TestBase{
 ShoppingCart cartObject;
 Homepage homeobject;
 ProductsDetailsPage detailsobject;
 SearchPage searchobject;
 String productName = "Apple MacBook Pro 13-inch";	
 
//	search for product
	@Test (priority = 1 )
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
	
	@Test (priority = 2 )
	public void UserCanAddProductToCart() throws InterruptedException 
	{
		detailsobject.AddToCart();
//		Thread.sleep(1500);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");	
		cartObject = new ShoppingCart(driver);
		assertTrue(cartObject.totalLbl.getText().contains("3,600"));		
	}	
	@Test (priority = 3 )
	public void UserCanRemoveProductFromCart()
	{
		cartObject = new ShoppingCart(driver);
		cartObject.RemoveProductFromcart();		
	}
}
