package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailPage;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.ProductsDetailsPage;
import Pages.SearchPage;
import Pages.userRegisterationpage;

public class EmailFriendTest extends TestBase {

	Homepage homeobject;
	userRegisterationpage registerobject; 
	LoginPage loginobject;
	SearchPage searchobject;
	ProductsDetailsPage detailsobject;
	EmailPage  emailobject;
	String productName = "Apple MacBook Pro 13-inch";
	
//	1 - user Registration
	@Test (priority = 1 )
	public void UserCanRegisterSuccssfully()
	{
		homeobject = new Homepage(driver);
		homeobject.openRegistrationPage();
		registerobject = new userRegisterationpage(driver);
		registerobject.userRegistration("mostafa", "hasan", "test869email@gmail.com", "12345678");
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
	public void RegisteredUserCanSendProductToFriend() 
	{
		detailsobject.OpenSendEmail();
		emailobject = new EmailPage(driver);
		emailobject.SendMailToFriend("mostafa455@test.com", "hello my friend , check this product");
		assertTrue(emailobject.messageconfirmation.getText().contains("Your message has been sent."));
	}	
//	4- user logout 	
	@Test (priority = 4)
	public void RegisteredUserCanLogout() 
	    {
		registerobject.userlogout();
		}
}
