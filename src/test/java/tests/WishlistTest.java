package tests;

import base.baseTest;
import pages.WishlistPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishlistTest extends baseTest {
	WishlistPage wishlist;

	@BeforeMethod
	public void setUpPages() {
		wishlist = new WishlistPage(driver);
	}

	@Test(priority = 1)
	public void addToWishlist_HomePage() throws InterruptedException {
//		wishlist.register();
		boolean displayed = wishlist.clickOnItem_HomePage();
		Assert.assertTrue(displayed, "Item not added");
		wishlist.returnHomePage();
	}

	@Test(priority = 3)
	public void addToWishlist_DesktopPage() throws InterruptedException {
//		wishlist.register();
		boolean displayed = wishlist.clickOnItem_DesktopPage();
		Assert.assertTrue(displayed, "Item not added");
		wishlist.returnHomePage();
	}

	@Test(priority = 2)
	public void removeItem() throws InterruptedException {
		boolean displayed = wishlist.removeItem();
		Assert.assertTrue(displayed, "Item not added");
		wishlist.returnHomePage();
	}
	
	@Test(priority = 4)
	public void errorMSG() throws InterruptedException {
		boolean displayed = wishlist.errorMSG();
		Assert.assertTrue(displayed, "MSG Not Displayed");
		wishlist.returnHomePage();
	}

}
