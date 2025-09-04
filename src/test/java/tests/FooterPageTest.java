package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.baseTest;
import pages.FooterPage;

public class FooterPageTest extends baseTest  {
	FooterPage footer;
	 @BeforeMethod 
	  public void object() {
		 footer = new FooterPage(driver);
	  }
	  @Test (priority=1)
	    public void TC_FOOTER_01_VerifyFooterLinksClickable() {
	        
	        Assert.assertTrue(footer.areAllFooterLinksClickable(), "Some footer links are not clickable!");
	    }
	
	    @Test (priority=2)
	    public void TC_FOOTER_02_VerifySocialIconsClickable() {
	        Assert.assertTrue(footer.areAllSocialIconsClickable(), "Some social icons are not clickable!");
	    }

	    @Test (priority=3)
	    public void TC_FOOTER_03_VerifyNewsletterSubscription() throws InterruptedException {
	        footer.subscribeToNewsletter("majdabuhassanien@gmail.com");
	      String msg = footer.getNewsletterResultMessage();
	      String successmsg="Thank you for signing up! A verification email has been sent. We appreciate your interest.";
	       Assert.assertTrue(msg.equalsIgnoreCase(successmsg),
	               "Newsletter subscription failed! Message: " + msg);
	    }
}

