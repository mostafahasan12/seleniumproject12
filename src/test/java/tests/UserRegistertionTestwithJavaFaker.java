package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.Homepage;
import Pages.LoginPage;
import Pages.userRegisterationpage;

public class UserRegistertionTestwithJavaFaker  extends TestBase
{
Homepage homeobject;
userRegisterationpage registerobject; 
LoginPage loginobject;

Faker fakedata = new Faker();
String firstname = fakedata.name().firstName();
String lastname = fakedata.name().lastName();
String email = fakedata.internet().emailAddress();
String password = fakedata.number().digits(8).toString();

@Test (priority = 1 )
public void UserCanRegisterSuccssfully()
{
	homeobject = new Homepage(driver);
	homeobject.openRegistrationPage();
	registerobject = new userRegisterationpage(driver);
	registerobject.userRegistration(firstname , lastname , email , password );
	System.out.println("The Userr Data is : "+ firstname + " " + lastname + " " + email + " " + password);
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
