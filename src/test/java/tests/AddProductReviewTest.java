package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailPage;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.ProductPageReview;
import Pages.ProductsDetailsPage;
import Pages.SearchPage;
import Pages.userRegisterationpage;


public class AddProductReviewTest extends TestBase {
	Homepage homeobject;
	userRegisterationpage registerobject; 
	LoginPage loginobject;
	ProductsDetailsPage detailsobject;
	SearchPage searchobject;
	String productName = "Apple MacBook Pro 13-inch";
	ProductPageReview reviewobject;
	EmailPage  emailobject;
	
//	1 - user registertion
	@Test (priority = 1 )
	public void UserCanRegisterSuccssfully()
	{
		homeobject = new Homepage(driver);
		homeobject.openRegistrationPage();
		registerobject = new userRegisterationpage(driver);
		registerobject.userRegistration("mostafa", "hasan", "test8email@gmail.com", "12345678");
		Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
		}
//	2- search for product
	@Test (priority = 2 )
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
	
//	3- Email to friend
	@Test (priority = 3)
	public void RegisteredUserCanReviewForproduct() 
	{
		detailsobject.OpenReviewPage();
		reviewobject = new ProductPageReview(driver);
		reviewobject.AddProductReview("New Review", "the product is good");
		Assert.assertTrue(reviewobject.reviewNotification.getText()
				.contains("Product review is successfully added."));
	}	
//	4- user logout 	
	@Test (priority = 4)
	public void RegisteredUserCanLogout() 
	    {
		registerobject.userlogout();
		}
}
