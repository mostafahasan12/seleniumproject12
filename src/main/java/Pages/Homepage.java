package Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Homepage extends pageBase{

	public Homepage(WebDriver driver) {
		super(driver);	
		 jse = (JavascriptExecutor) driver;
		 action = new Actions(driver); 
	}
    @FindBy(linkText ="Register")
    WebElement registerlink;                
    
    @FindBy(linkText ="Log in")
    WebElement loginlink; 
    
    @FindBy (linkText = "Contact us")
    WebElement contacttxt;
     
    @FindBy(css ="a.ico-account")
	 WebElement MyaccountLink;
    
    @FindBy(id = "customerCurrency")
    WebElement currencydrl;
    
	@FindBy(linkText="Electronics")
	WebElement ElectronicsMenu; 
	
	@FindBy(linkText="Cell phones")
	WebElement CellMenu; 
    
    public void openRegistrationPage() 
    {
    	registerlink.click();
    }  
   
    public void openLoginpage() 
    {
    	registerlink.click();
    }  
    public void OpenMyaccountPage() 
    {
    	clickbutton(MyaccountLink);
    }

    public void openContactUsPage() 
    {
    	ScrollBottom();
    	clickbutton(contacttxt);
    }
    
    public void changeCurrency() 
    {
    	select = new Select(currencydrl);
    	select.selectByVisibleText("Euro");
    }
    
  
    public void selectNotebooksMenu() 
 	{}
//    	action
//    	.moveToElement(ElectronicsMenu)
////    	.moveToElement(CellMenu)
//    	.click()
//    	.build()
//    	.perform();
    	
//    	 Consumer < By > hover = (By by) -> {
//     action.moveToElement(driver.findElement(by))
//            .perform();
//  //
//  //@Test
//  //public void hoverTest() {
////      driver.get("https://www.bootply.com/render/6FC76YQ4Nh");
//  //
////      hover.accept(By.linkText("Dropdown"));
////      hover.accept(By.linkText("Dropdown Link 5"));
////      hover.accept(By.linkText("Dropdown Submenu Link 5.4"));
////      hover.accept(By.linkText("Dropdown Submenu Link 5.4.1"));
//  //}
// 	}
 	}
