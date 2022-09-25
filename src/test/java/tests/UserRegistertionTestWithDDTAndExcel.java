package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.LoginPage;
import Pages.userRegisterationpage;
import data.ExcelReader;

public class UserRegistertionTestWithDDTAndExcel  extends TestBase
{
Homepage homeobject;
userRegisterationpage registerobject; 
LoginPage loginobject;

@DataProvider (name =  "ExcelData")
public Object [] [] UserRegistertion() throws IOException {
//	get data from Excel Reader class 
	ExcelReader ER = new ExcelReader();
	
	return ER.getExcelData();
}

@Test (priority = 1 , dataProvider = "ExcelData" )
public void UserCanRegisterSuccssfully(String firstname , String lastname , String email , String password)
{
	homeobject = new Homepage(driver);
	homeobject.openRegistrationPage();
	registerobject = new userRegisterationpage(driver);
	registerobject.userRegistration(firstname , lastname , email , password);
	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	registerobject.userlogout();
	homeobject.openLoginpage();
	loginobject = new LoginPage(driver);
	loginobject.userLogin(email , password );
	}

}
