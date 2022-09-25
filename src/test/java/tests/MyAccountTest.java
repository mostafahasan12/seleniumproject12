package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.myAccountPage;
import Pages.userRegisterationpage;

public class MyAccountTest extends TestBase {
	Homepage homeobject;
	userRegisterationpage registerobject; 
	LoginPage loginobject;
	myAccountPage myAccountobject;
    String firstName = "mostafa";
    String lastName = "hasan";
    String email = "test798@gmail.com";
    String oldpassword = "1234567";
    String newpassword = "123456789";
	
	@Test (priority = 1 )
	public void UserCanRegisterSuccssfully()
	{
		homeobject = new Homepage(driver);
		homeobject.openRegistrationPage();
		registerobject = new userRegisterationpage(driver);
		registerobject.userRegistration(firstName , lastName , email , oldpassword);
		Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
		}
	@Test (priority = 2)
	public void RegisteredUserCanChangePassword() 
	{
		myAccountobject= new myAccountPage(driver);
		homeobject.OpenMyaccountPage();
		myAccountobject.openChangePassword();
		myAccountobject.changepassword(oldpassword, newpassword);		
		assertTrue(myAccountobject.resultLbl.getText().contains("Password was changed"));
		myAccountobject.closeAssertChangebtnmessage();
		driver.navigate().to("https://demo.nopcommerce.com");		
	}
	@Test (priority = 3)
	public void RegisteredUserCanLogout() 
	    {
		registerobject.userlogout();
		}
	@Test (priority = 4)
	public void RegisteredUserCanLogIn() 
	{
		homeobject.openLoginpage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin(email, newpassword);
//		assertTrue(registerobject.logoutLink.getText().contains("Log out"));
		driver.navigate().to("https://demo.nopcommerce.com");	
	}
	@Test(priority=5)
	public void UserLogout() 
	{
		registerobject.userlogout();
	}
}
