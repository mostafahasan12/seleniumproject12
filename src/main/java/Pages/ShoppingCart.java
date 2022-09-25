package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart  extends pageBase{
	public ShoppingCart(WebDriver driver) {
		super(driver);
	}

	@FindBy (css ="button.remove-btn")
	WebElement removecheckbtn;

	@FindBy (id ="updatecart")
	WebElement updatecartbtn;

	@FindBy (id ="itemquantity11219")
	WebElement quantitytxt;

	@FindBy (css ="span.product-subtotal")
	public WebElement totalLbl;

	@FindBy  (id ="checkout")
	WebElement checkoutBtn;

	@FindBy  (id ="termsofservice")
	WebElement Agreecheckbox;
	
	public void RemoveProductFromcart()
	{
		clickbutton(removecheckbtn);
	}

	public void UpdateProductQuantityInCart(String quantity ) throws InterruptedException 
	{
		//	clear quantity
		clearText(quantitytxt);
		setElementText(quantitytxt, quantity);
		clickbutton(updatecartbtn);
	}
	public void opencheckoutpage()
	{
		clickbutton(Agreecheckbox);
		clickbutton(checkoutBtn);
	}
} 
