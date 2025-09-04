package workflows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.baseTest;
import pages.HomePage;
import pages.ShoppingCartPage;
import pages.WishlistPage;

// happy path
public class checkoutAsGuest extends baseTest {
 // homepage => add item to wishlist => open wishlist => add item from wishlist to shopping cart => 
 // open shopping cart => checkout as guest

 private ShoppingCartPage shoppingcart;

 @BeforeMethod
 public void setUpDropdown() {
  shoppingcart = new ShoppingCartPage(driver);
 }

 @Test
 public void testAddToCartAndCheckoutAsGuest() throws InterruptedException {
  shoppingcart.clickOnItem_WishlistPage();
  Thread.sleep(3000);
  boolean result = shoppingcart.asGuest();
  Thread.sleep(1000);
  
  Assert.assertTrue(result,"It should check out successfully.");
 }
}    