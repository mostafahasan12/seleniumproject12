package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage  extends pageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
  @FindBy(id = "small-searchterms") 
  WebElement searchtextBtn;
  
  @FindBy(css = "button.button-1.search-box-button") 
  WebElement searchbtn1;
  
  @FindBy(id = "ui-id-1") 
  List<WebElement> productlist;
  
 @FindBy(linkText = "Apple MacBook Pro 13-inch") 
 WebElement producttitle;
 
  public void productsearch(String productName ) 
  {
	  setElementText(searchtextBtn, productName);
	  clickbutton(searchbtn1);
  }
  public void openProductdetailspage() 
  {
	  clickbutton(producttitle);
  }
  public void ProductSearchUsingAutoSuggest(String searchtxt)
  {
	  setElementText(searchtextBtn, searchtxt);
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  productlist.get(0).click();
  }
  
}
