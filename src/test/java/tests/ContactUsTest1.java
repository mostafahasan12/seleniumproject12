package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.Homepage;

public class ContactUsTest1 extends TestBase {
 Homepage homeObject;
 ContactUsPage contactobject;
 
 String email = "test@test.com";
 String fullName = "test user";
 String enquiry = "Hello Admin , this is for test";
 
 @Test
 public void UserCanUseContactUS() 
 {
	 homeObject = new Homepage(driver);
	 homeObject.openContactUsPage();
	 contactobject = new ContactUsPage(driver);
	 contactobject.ContactUs(fullName, email, enquiry);
	 assertTrue(contactobject.successMessage.getText()
			 .contains("Your enquiry has been successfully sent to the store owner."));
 }
 
}
