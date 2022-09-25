package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends pageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
@FindBy (css ="td.product")
public WebElement productcell;

@FindBy (css = "h1")
public WebElement wishlistheader;


@FindBy (css ="button.remove-btn")
private WebElement removefromWishlistbtn;

//@FindBy (id ="removefromcart")
//private WebElement removefromcartCheck;

@FindBy(css ="div.no-data")
public WebElement EmptyCartLabel;

public void removeProductFromWishlist() {
	clickbutton(removefromWishlistbtn);
//	clickbutton(updateWishlistbtn);
}

}
