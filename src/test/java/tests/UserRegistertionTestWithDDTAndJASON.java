package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.LoginPage;
import Pages.userRegisterationpage;
import data.JsonDataReader;

public class UserRegistertionTestWithDDTAndJASON  extends TestBase
{
Homepage homeobject;
userRegisterationpage registerobject; 
LoginPage loginobject;

@Test (priority = 1 )
public void UserCanRegisterSuccssfully() throws FileNotFoundException, IOException, ParseException
{
	JsonDataReader jsonReader =new JsonDataReader();
	jsonReader.jsonReader();
	
	homeobject = new Homepage(driver);
	homeobject.openRegistrationPage();
	registerobject = new userRegisterationpage(driver);
	registerobject.userRegistration(jsonReader.firstname,jsonReader.lastname,jsonReader.email,jsonReader.password);
	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	registerobject.userlogout();
	homeobject.openLoginpage();
	loginobject = new LoginPage(driver);
	loginobject.userLogin(jsonReader.email ,jsonReader.password);
	registerobject.userlogout();
	}
   
}
