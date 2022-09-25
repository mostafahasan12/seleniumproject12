package steps;


import org.testng.Assert;


import Pages.Homepage;
import Pages.LoginPage;
import Pages.userRegisterationpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import tests.TestBase;

public class UserRegistration extends TestBase{
	Homepage homeObject ; 
	userRegisterationpage registerObject ; 
	LoginPage loginobject;
	
	@Given("^the user in the home page$")
	public void the_user_in_the_home_page() throws Throwable {
		homeObject = new Homepage(driver); 
		homeObject.openRegistrationPage();
	}

	@When("^I click on register link$")
	public void i_click_on_register_link()  {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*@When("^I entered the user data$")
	public void i_entered_the_user_data()  {
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("Moataz", "Nabil", "moataz@test.com", "12345678");
	}*/

	@When("^I entered \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registerObject = new userRegisterationpage(driver); 
		registerObject.userRegistration(firstname, lastname,email,password);
	}

	@Then("^The registration page displayed successfully$")
	public void the_registration_page_displayed_successfully()  {
		registerObject.userlogout();
	}
}
