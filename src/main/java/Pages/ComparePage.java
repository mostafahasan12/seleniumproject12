package Pages;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends  pageBase {
	public ComparePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.clear-list")
	WebElement  clearlistlink;
	
	@FindBy(css = "div.no-data")
	WebElement noDataLabel;
	
	@FindBy(css =  "table.compare-products-table")
	WebElement comparetable;
	
	@FindBy (css ="tr")
	public List<WebElement> allRows;
	
	@FindBy (css ="td")
	public List<WebElement> allCol;
	
     @FindBy(linkText="Asus N551JK-XO076H Laptop")
	 public WebElement firstProductName; 
	    
     @FindBy(linkText="Apple MacBook Pro 13-inch")
     public WebElement secodProductName ; 

	public void clearCompareList() 
	{
		clickbutton(clearlistlink);
	}
	public void CompareProducts() 
	{
//		get all rows
		System.out.println(allRows.size() );
//		get data from each Row 
		for (WebElement row : allRows) {
			System.out.println(row.getText()+ "\t");
			for (WebElement col : allCol) {
				System.out.println(col.getText()+ "\t");
			}
		}		
	}
	
}
