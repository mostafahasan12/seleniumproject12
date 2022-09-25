package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageReview extends pageBase {

	public ProductPageReview(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;

	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewText;

	@FindBy(id = "addproductrating_4")
	WebElement rating4RdoBtn;

	@FindBy(name = "add-review")
	WebElement submitReviewBtn;
	
	@FindBy(css = "div.result")
	public  WebElement reviewNotification;
	
	public void AddProductReview(String reviewTitle, String reviewMessage) {
		setElementText(reviewTitleTxt, reviewTitle);
		setElementText(reviewText, reviewMessage);
		clickbutton(rating4RdoBtn);
		clickbutton(submitReviewBtn);
	}

}
