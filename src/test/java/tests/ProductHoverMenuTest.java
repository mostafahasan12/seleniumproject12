package tests;


import org.testng.annotations.Test;

import Pages.Homepage;

public class ProductHoverMenuTest  extends TestBase {
Homepage homeobject;

@Test 
public void UserCanSelectSubCatagoryFromMainMenu()
{
	homeobject = new Homepage(driver); 
	homeobject.selectNotebooksMenu();
//	Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
}
}


