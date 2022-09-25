package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends Homepage {

	public myAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy(id = "NewPassword")
	WebElement NewPasswordTxt;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement ConfirmNewPasswordTxt;
	
	@FindBy(css ="button.button-1.change-password-button")
	WebElement Changepasswordbtn;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
	public WebElement resultLbl;
	
	@FindBy(css = "span.close")
	public WebElement  closeAssertChangebtn;
	
	public void openChangePassword() 
	{
		clickbutton(changePasswordLink);
	}
	
	public void changepassword(String oldpassword , String newpassword) 
	{
		setElementText(oldPasswordTxt, oldpassword);
		setElementText(NewPasswordTxt, newpassword);
		setElementText(ConfirmNewPasswordTxt, newpassword);
		clickbutton(Changepasswordbtn);
	}
	public void closeAssertChangebtnmessage()
	{
		clickbutton(closeAssertChangebtn);
	}
}
