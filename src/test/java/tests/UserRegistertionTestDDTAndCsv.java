package tests;

import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Pages.Homepage;
import Pages.LoginPage;
import Pages.userRegisterationpage;

public class UserRegistertionTestDDTAndCsv  extends TestBase
{
Homepage homeobject;
userRegisterationpage registerobject; 
LoginPage loginobject;

CSVReader reader;

@Test (priority = 1 )
public void UserCanRegisterSuccssfully() throws CsvValidationException, IOException
{
    String Csv_file = System.getProperty("user.dir")+"/src/test/java/data/UserData.csv"; 
    reader = new CSVReader(new FileReader(Csv_file));
    
    String [] csvCell ;
//     while loop will be executed till the last value in csv file 
    while ((csvCell = reader.readNext()) != null ) {
		String firstname = csvCell [0];
		String lastname = csvCell [1];
		String email = csvCell [2];
		String password =  csvCell [3];
	
	homeobject = new Homepage(driver);
	homeobject.openRegistrationPage();
	registerobject = new userRegisterationpage(driver);
	registerobject.userRegistration(firstname , lastname , email , password);
	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	registerobject.userlogout();
	homeobject.openLoginpage();
	loginobject = new LoginPage(driver);
	loginobject.userLogin(email , password );
	registerobject.userlogout(); 
	} 
  }
}
