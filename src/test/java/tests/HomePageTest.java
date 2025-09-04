package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.baseTest;
import pages.ComputersDesktopsPage;
import pages.HomePage;

public class HomePageTest extends baseTest  {
	 HomePage home;
	 @BeforeMethod 
	  public void object() {
			  home = new HomePage(driver);

	  }
	 @Test (priority=1)
	    public void TC_HOME_01_LogoRedirectsToHome() {
	        ComputersDesktopsPage compDesk = new ComputersDesktopsPage(driver);
	        compDesk.goToDesktopsFromTopMenu();
	        Assert.assertTrue(compDesk.isOnDesktops(), "Not on Desktops page.");
	        home.clickLogo();
	        Assert.assertTrue(home.isOnHome(), "Home page not displayed after clicking logo.");
	    }
	    
	    
	    //poll voting
	    @Test (priority=2)
	    public void TC_HOME_02_votingisrestricted() throws InterruptedException{
//	        super.setUp();
	        driver.navigate().to("https://demo.nopcommerce.com/");

	        home.votingExcellent();
	        String msg = home.getErrorMessage();
	        String Error="Only registered users can vote.";
	        Assert.assertTrue(msg.equalsIgnoreCase(Error), "Newsletter subscription failed! Message: " + msg);
	    }
	    
		}
		
	    

