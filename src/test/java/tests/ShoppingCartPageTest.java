package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.baseTest;
import pages.ShoppingCartPage;

public class ShoppingCartPageTest extends baseTest {

 ShoppingCartPage shoppingCart;

 @BeforeMethod
 public void setUpPages() {
  shoppingCart = new ShoppingCartPage(driver);
 }

 @Test(priority = 1)
 public void addToShCart_HomePage() throws InterruptedException {
//  shoppingCart.register();
  boolean displayed = shoppingCart.clickOnItem_HomePage();
  Assert.assertTrue(displayed, "Item not added.");
  shoppingCart.returnHomePage();
 }

 @Test(priority = 2)
 public void addToShCart_DesktopPage() throws InterruptedException {
//  shoppingCart.register();
  boolean displayed = shoppingCart.clickOnItem_DesktopPage();
  Assert.assertTrue(displayed, "Item not added.");
  shoppingCart.returnHomePage();
 }

 @Test(priority = 3)
 public void addToShCart_WishListPage() throws InterruptedException {
//  shoppingCart.register();
  boolean displayed = shoppingCart.clickOnItem_WishlistPage();
  Assert.assertTrue(displayed, "Item not added.");
  shoppingCart.returnHomePage();
 }

 @Test(priority = 4)
 public void openItemPage() throws InterruptedException {
  boolean display = shoppingCart.itemPage();
  Assert.assertTrue(display, "Item Not Found.");
  shoppingCart.returnHomePage();
 }

 @Test(priority = 5)
 public void increseOrDecreaseItem() throws InterruptedException {
  boolean display = shoppingCart.increaseOrDecrease();
  Assert.assertTrue(display, "Item Did Not Increased or Decreased.");
  shoppingCart.returnHomePage();
 }
 
 @Test(priority = 6)
 public void checkoutAsGuest() throws InterruptedException {
  boolean display = shoppingCart.checkOutAsGuest();
  Assert.assertTrue(display,"Checkout Page not displayed.");
  shoppingCart.returnHomePage();
 }
 
 @Test(priority = 7)
 public void checkoutAsUser() throws InterruptedException {
  shoppingCart.register();
  boolean display = shoppingCart.checkOutAsUser();
  Assert.assertTrue(display,"Checkout Page not displayed.");
  shoppingCart.returnHomePage();
 }
}