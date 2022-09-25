package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userRegisterationpage extends pageBase {

	public userRegisterationpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "gender-male")
	WebElement genderrdobtn;
	
	@FindBy(id = "gender-female")
	WebElement genderrdobtn2;
	
	@FindBy(id="FirstName")
	WebElement fnTxtBox; 
	
	@FindBy(id="LastName")
	WebElement lnTxtBox ; 
	
	@FindBy(id="Email")
	WebElement emailTxtBox ; 
	
	@FindBy(id="Password")
	WebElement passwordTxtBox ; 
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxtBox ; 
	
	@FindBy(id="register-button")
	WebElement registerBtn ; 
	
	@FindBy(className = "result")
	public WebElement sucessmessage;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public 	WebElement logoutLink ;
 		 
	public void userRegistration(String firstname , String lastname , String email , String password) 
	{
		clickbutton(genderrdobtn);
		clickbutton(genderrdobtn2);	
		setElementText(fnTxtBox, firstname);
		setElementText(lnTxtBox, lastname);
		setElementText(emailTxtBox , email);
		setElementText(passwordTxtBox , password);
		setElementText(confirmPasswordTxtBox , password);
		clickbutton(registerBtn);
	}
	public void userlogout() 
	{
		clickbutton(logoutLink);
	}	
}
