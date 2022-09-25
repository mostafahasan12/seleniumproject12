package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class AmazonTestHover {
	ChromeDriver driver ; 
	   @BeforeTest
	   public void openUrl ()
	   {
		   System.setProperty("webdriver.chrome.driver" 
		   ,   System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		   driver = new ChromeDriver();
		   driver.navigate().to("https://www.amazon.eg/");	   
	   }
	   @Test
	   public void  testSelectList() throws InterruptedException 
	   {
		   WebElement mainlist = driver.findElement(By.id("nav-link-accountList-nav-line-1"));  
		   Thread.sleep(3000);
		   WebElement accountlist = driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]/span"));
           Actions action = new Actions(driver);
           action.moveToElement(mainlist).moveToElement(accountlist).click().build().perform();
           Thread.sleep(3000);

	   }
	   @AfterTest
	   public void closedriver() {
	  
		  driver.quit();

	  }
}
