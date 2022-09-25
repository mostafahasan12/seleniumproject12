package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CheckoutPage;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.OrderDetailsPage1;
import Pages.ProductsDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCart;
import Pages.userRegisterationpage;

public class RegisteredUserCheckoutProductTest  extends TestBase{
	/*
	 * 1- Register User
	 * 2- Search for product
	 * 3- Add to Cart
	 * 4- Checkout
	 * 5- Logout 
	 */
	Homepage homeobject;
	userRegisterationpage registerobject; 
	LoginPage loginobject;
	ProductsDetailsPage detailsobject;
	SearchPage searchobject;
	String productName = "Apple MacBook Pro 13-inch";	
	 ShoppingCart cartObject;
	 CheckoutPage checkoutobject;
	 OrderDetailsPage1  Orderobject;
	 
	 @Test (priority = 1 , alwaysRun = true )
	 public void UserCanRegisterSuccssfully()
	 {
	 	homeobject = new Homepage(driver);
	 	homeobject.openRegistrationPage();
	 	registerobject = new userRegisterationpage(driver);
	 	registerobject.userRegistration("mostafa", "hasan", "test4785email@gmail.com", "12345678");
	 	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	 	}
	 @Test (priority = 2)
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
	 
	 @Test (priority = 3 )
		public void UserCanAddProductToCart() throws InterruptedException 
		{
			detailsobject.AddToCart();
//			Thread.sleep(1500);
			driver.navigate().to("https://demo.nopcommerce.com"+"/cart");	
			cartObject = new ShoppingCart(driver);
			assertTrue(cartObject.totalLbl.getText().contains("3,600"));		
		}	
	 

		@Test(priority=4)
		public void UserCanCheckoutProduct() throws InterruptedException {
			checkoutobject = new CheckoutPage(driver);
			cartObject.opencheckoutpage();
			checkoutobject.RegisteredUserCheckoutProduct("Egypt", "test address", "123456", "32445566677", "Cairo", productName);
			Assert.assertTrue(checkoutobject.prodcutName.isDisplayed());
			Assert.assertTrue(checkoutobject.prodcutName.getText().contains(productName));
			checkoutobject.confirmOrder();
			Assert.assertTrue(checkoutobject.ThankYoulbl.isDisplayed());
			checkoutobject.viewOrderDetails();
			Orderobject = new OrderDetailsPage1(driver);
			Orderobject.DownloadPDFInvoice();
			Orderobject.PrintOrderDetails();
		}
		
		@Test(priority=5)
		public void RegisteredUserCanLogout() 
		{
			registerobject.userlogout();
		}
}
		
	
