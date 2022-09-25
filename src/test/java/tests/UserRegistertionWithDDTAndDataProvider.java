package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.LoginPage;
import Pages.userRegisterationpage;

public class UserRegistertionWithDDTAndDataProvider extends TestBase {
	Homepage homeobject;
	userRegisterationpage registerobject; 
	LoginPage loginobject;

	@DataProvider (name = "testData")
	public static Object[] [] userData ()
	{
		return new Object [] [] {
				{"mostafa" , "hasasn" , "test457wwqe@gmail.com" ,"0123456"},
		        {"mahmoud" , "emam" , "efsg778est11@gmail.com" , "12345678"}
		};
	}
	
	@Test (priority = 1  , dataProvider = "testData")
	public void UserCanRegisterSuccssfully(String fname ,String lname , String email , String password )
	{
		homeobject = new Homepage(driver);
		homeobject.openRegistrationPage();
		registerobject = new userRegisterationpage(driver);
		registerobject.userRegistration(fname , lname , email , password);
		Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
		registerobject.userlogout();
		homeobject.openLoginpage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin(email , password);
		registerobject.userlogout();
		}

}
