package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import base.baseTest;
import pages.ComputersDesktopsPage;
import pages.HomePage;

public class ComputersDesktopsPageTest extends baseTest {
	ComputersDesktopsPage compDesk ;
	 @BeforeMethod 
	  public void object() {
		 compDesk = new ComputersDesktopsPage(driver);
	  }
	   @Test (priority=1)
	    public void DESK_01_NavigateToDesktops() {
	        HomePage home = new HomePage(driver);
	       Assert.assertTrue(home.isOnHome(), "Not on Home before navigation.");
	        compDesk.goToDesktopsFromTopMenu();
	        Assert.assertTrue(compDesk.isOnDesktops(), "Desktops page title not detected.");
	    }
	   @Test (priority=2)
	    public void DESK_02_ListIconSwitchesLayoutToListView() {
		   compDesk.convertTOlist();
	    }
	   
	   
	   
}
