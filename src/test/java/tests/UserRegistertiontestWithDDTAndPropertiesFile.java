package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.LoginPage;
import Pages.userRegisterationpage;
import data.LoadProperties;

public class UserRegistertiontestWithDDTAndPropertiesFile  extends TestBase
{
Homepage homeobject;
userRegisterationpage registerobject; 
LoginPage loginobject;
String firstname = LoadProperties.userData.getProperty("firstname");
String lastname = LoadProperties.userData.getProperty("lastname");
String email = LoadProperties.userData.getProperty("email");
String password = LoadProperties.userData.getProperty("password");


@Test (priority = 1 )
public void UserCanRegisterSuccssfully()
{
	homeobject = new Homepage(driver);
	homeobject.openRegistrationPage();
	registerobject = new userRegisterationpage(driver);
	registerobject.userRegistration(firstname , lastname,email , password);
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
	loginobject.userLogin(email , password);
}
}
