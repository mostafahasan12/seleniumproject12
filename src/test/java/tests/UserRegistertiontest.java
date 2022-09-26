package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.LoginPage;
import Pages.userRegisterationpage;

public class UserRegistertiontest  extends TestBase
{
Homepage homeobject;
userRegisterationpage registerobject; 
LoginPage loginobject;

@Test (priority = 1 )
public void UserCanRegisterSuccssfully()
{
	homeobject = new Homepage(driver);
	homeobject.openRegistrationPage();
	registerobject = new userRegisterationpage(driver);
	registerobject.userRegistration("mostafa", "hasan", "test5e4mail@gmail.com", "12345678");
	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	}
@Test (dependsOnMethods = {"UserCanRegisterSuccssfully"})
public void RegisteredUserCanLogout() 
    {
	registerobject.userlogout();
	}
@Test (dependsOnMethods = {"RegisteredUserCanLogout"})
public void RegisteredUserCanLogIn() 
{
	homeobject.openLoginpage();
	loginobject = new LoginPage(driver);
	loginobject.userLogin("test5e4mail@gmail.com", "12345678");
}
}
