package workflows;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseTest;
import pages.DropdownPage;
import pages.HomePage;
import pages.RegisterPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

// happy path
public class checkoutWithoutSearch extends baseTest {
//	valid register => homepage => add to cart => shoppingCart => Checkout

	private RegisterPage register;
	private HomePage homepage;
	private SearchPage searchpage;
	private ShoppingCartPage shoppingcart;


	@BeforeMethod
	public void setUpDropdown() {
		register = new RegisterPage(driver);
		homepage = new HomePage(driver);
		searchpage = new SearchPage(driver);
		shoppingcart=new ShoppingCartPage(driver);
	}

	@DataProvider(name = "registerData")
	public Object[][] registerData() {
		String uniqueEmail = "user" + (System.currentTimeMillis() + new Random().nextInt(1000)) + "@gmail.com";
		return new Object[][] { { "feras", "alfara", uniqueEmail, "21335@g585", "21335@g585" } };
	}

	@Test(dataProvider = "registerData")
	public void testRegisterAddToCartAndCheckout(String firstName, String lastName, String email, String password,
			String confirmPassword) throws InterruptedException {
		register.openRegisterPage();
		register.register(firstName, lastName, email, password, confirmPassword);
		Thread.sleep(3000);
		shoppingcart.returnHomePage();
		shoppingcart.clickOnItem_HomePage();
		Thread.sleep(3000);
		homepage.clickShoppingCart();
		Thread.sleep(3000);
		shoppingcart.checkOut();
		Thread.sleep(3000);

}

}
