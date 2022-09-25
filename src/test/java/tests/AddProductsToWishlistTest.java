package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.ProductsDetailsPage;
import Pages.SearchPage;
import Pages.WishListPage;

public class AddProductsToWishlistTest  extends TestBase {
	Homepage homeobject;
	ProductsDetailsPage detailsobject;
	SearchPage searchobject;
	String productName = "Apple MacBook Pro 13-inch";	
	WishListPage wishlistobject;
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
	public void UserCanAddProductToWishlist() 
	{
		detailsobject = new ProductsDetailsPage(driver);
		detailsobject.AddProductToWishlist();
		driver.navigate().to("https://demo.nopcommerce.com"+"/wishlist");
		wishlistobject = new WishListPage(driver);
		assertTrue(wishlistobject.wishlistheader.isDisplayed());
		assertTrue(wishlistobject.productcell.getText().contains(productName));
	}
	@Test (priority = 3 )
	public void UserCanAddRemoveProductFromCart() 
	{
    wishlistobject.removeProductFromWishlist();
    assertTrue(wishlistobject.EmptyCartLabel.getText().contains("The wishlist is empty!"));
	}
}   
