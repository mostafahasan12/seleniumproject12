package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage  extends pageBase{
	public EmailPage(WebDriver driver) {
		super(driver);
	}
@FindBy(id = "FriendEmail")
WebElement emailfriendtxt;

@FindBy(id ="PersonalMessage")
WebElement PersonalMessagetxt;

@FindBy(name = "send-email")
WebElement sendEmailBtn;

@FindBy(css ="div.result")
public WebElement messageconfirmation;

public void SendMailToFriend(String friendmail , String personalmessage) 
{
	setElementText(emailfriendtxt, friendmail);
	setElementText(PersonalMessagetxt, personalmessage);
	clickbutton(sendEmailBtn);
	}

}
