package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends pageBase {
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "input.button-1.checkout-as-guest-button")
	private WebElement guestBtn;
	
	@FindBy(id = "BillingNewAddress_FirstName")
	private WebElement fnTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lnTxt;

	@FindBy(id = "BillingNewAddress_Email")
	private WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryList;
	
	@FindBy(id = "BillingNewAddress_StateProvinceId")
	private WebElement StateProvinceList;


	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement addressTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement postCodeTxt;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneTxt;
	
	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[4]")
	private WebElement continuebtn;
	
	@FindBy(id = "shippingoption_1")
	private WebElement shippingMethodRdo;
	
	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
	private WebElement continueShippingBtn;
	
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
	private WebElement continuepaymentbtn;
	
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
	private WebElement continueInfoBtn;
	
	@FindBy(css = "a.product-name")
	public WebElement prodcutName;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	private WebElement confirmBtn;

	@FindBy(css = "h1")
	public WebElement ThankYoulbl;

	@FindBy(css = "div.title")
	private WebElement successMessage;

	@FindBy(linkText = "Click here for order details.")
	private WebElement orderDetailsLink;

	public void RegisteredUserCheckoutProduct(String countryName, String address, 
			String postcode, String phone, String city, String productName) throws InterruptedException {
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setElementText(cityTxt, city);
		setElementText(addressTxt, address);
		setElementText(postCodeTxt, postcode);
		setElementText(phoneTxt, phone);
		clickbutton(continuebtn);
		clickbutton(shippingMethodRdo);
		clickbutton(continueShippingBtn);
		Thread.sleep(1000);
		clickbutton(continuepaymentbtn);
		Thread.sleep(1000);
		clickbutton(continueInfoBtn);
	}
	public void confirmOrder() throws InterruptedException 
	{
		clickbutton(confirmBtn);
		Thread.sleep(2000);
	}
	public void viewOrderDetails() {
		clickbutton(orderDetailsLink);
	}
	public void CheckoutProduct(String firstName, String lastName, String countryName,
			String email, String address, String postcode, 
			String phone, String city, String productName) throws InterruptedException {
		setElementText(fnTxt, firstName);
		setElementText(lnTxt, lastName);
		setElementText(emailTxt, email);
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setElementText(cityTxt, city);
		setElementText(addressTxt, address);
		setElementText(postCodeTxt, postcode);
		setElementText(phoneTxt, phone);
		clickbutton(continuebtn);
		clickbutton(shippingMethodRdo);
		clickbutton(continueShippingBtn);
		Thread.sleep(2000);
		clickbutton(continuepaymentbtn);
		Thread.sleep(2000);
		clickbutton(continueInfoBtn);
	}
}
