package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageBase {
	protected WebDriver drviers;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action ; 
	
// create constructor 
	public pageBase (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	 protected static void clickbutton(WebElement button) 
	    {
	    	button.click();
	    }
	    protected static void setElementText(WebElement settextelement1 , String value1 ) 
	    {
	    	settextelement1.sendKeys(value1);
	    }
	    public void ScrollBottom() 
	    {
	    	jse.executeScript("scrollBy(0,2500)");
	    }
	    
	    public void clearText(WebElement element) {
	    	element.clear();
	    }
	    
	    
}