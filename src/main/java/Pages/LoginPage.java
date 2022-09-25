package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Homepage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "Email")
	WebElement emailtxtbox;
	
	@FindBy(id = "Password")
	WebElement passwordtxtbox;
	
	@FindBy(linkText ="Log in")
	WebElement loginbtn;
	
	public void userLogin(String email , String password) 
	{
		setElementText(emailtxtbox ,"");
		setElementText(passwordtxtbox ,"");
		clickbutton(loginbtn);
	}
}
