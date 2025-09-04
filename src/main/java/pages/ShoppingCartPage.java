package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCartPage {

	private WebDriver driver;
	private Actions actions;

	private By homePage = By.xpath("(//a[@href='/'])[1]");
	private By itemHTC_shCart = By.xpath("(//div[@class='item-box'])[6]//button[@type='button'][1]");
	private By itemHTC_shCart2=By.xpath("(//button[@type=\"button\"])[1]");
	private By shCartPage = By.xpath("(//a[@href='/cart'])[1]");
	private By itemOnShCartPage = By.tagName("tr");
	private By computersHover = By.xpath("(//a[@href='/computers'])[1]");
	private By desktopPage = By.xpath("(//a[@href='/desktops'])[1]");
	private By lenovoItem_shCart = By.xpath("(//div[@class='item-box'])[3]//button[@type='button'][1]");
	private By itemHTC_wishlist = By.xpath("(//div[@class='item-box'])[6]//button[@type='button'][3]");
	private By wishListPageBtn = By.xpath("(//a[@href='/wishlist'])[1]");
	private By checkBox = By.name("addtocart");
	private By addToCartBtn = By.xpath("//button[@name='addtocartbutton']");
	private By htcPage = By.xpath("(//a[@href='/htc-smartphone'])[4]");
	private By pathOfHTC = By.className("current-item");
	private By increase = By.xpath("//div[starts-with(@id, 'quantity-up')]");
	private By decrease = By.xpath("//div[starts-with(@id, 'quantity-down')]");
	private By itemQuantity = By.className("qty-input");
	private By agree = By.id("termsofservice");
	private By checkoutBtn = By.id("checkout");
	private By cheackoutPage = By.xpath("//h1[text()='Checkout']");
	private By guest = By.xpath("(//button[@type='button'])[2]");

	private By regPage = By.className("ico-register");
	private By firstNameField = By.id("FirstName");
	private By lastNameField = By.id("LastName");
	private By emailField = By.id("Email");
	private By passwordField = By.id("Password");
	private By passwordFieldConfirmation = By.id("ConfirmPassword");
	private By regBtn = By.id("register-button");

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void returnHomePage() throws InterruptedException {
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	public void register() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(regPage).click();
		driver.findElement(firstNameField).sendKeys("user");
		driver.findElement(lastNameField).sendKeys("name");
		driver.findElement(emailField).sendKeys("userfaisal2024@gmail.com");
		driver.findElement(passwordField).sendKeys("username1234");
		driver.findElement(passwordFieldConfirmation).sendKeys("username1234");
		driver.findElement(regBtn).click();
		Thread.sleep(3000);
	}
	
	public void addItemToShCart() {
		driver.findElement(itemHTC_shCart2).click();
	}
	
//	public void ()

	public boolean clickOnItem_HomePage() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(itemHTC_shCart).click();
		driver.findElement(shCartPage).click();
		boolean displayed = driver.findElement(itemOnShCartPage).isDisplayed();
		if (!displayed) {
			System.out.println("Item Not Added to the wishlist");
			return false;
		}
		System.out.println("Item added successfully to the shopping cart");
		return true;
	}

	public boolean clickOnItem_DesktopPage() throws InterruptedException {
		actions.moveToElement(driver.findElement(computersHover)).perform();
		driver.findElement(desktopPage).click();
		Thread.sleep(3000);
		driver.findElement(lenovoItem_shCart).click();
		Thread.sleep(3000);
		driver.findElement(shCartPage).click();
		boolean displayed = driver.findElement(itemOnShCartPage).isDisplayed();
		if (!displayed) {
			System.out.println("Item Not Added to the wishlist");
			return false;
		}
		System.out.println("Item added successfully to the shopping cart");
		return true;
	}

	public boolean clickOnItem_WishlistPage() throws InterruptedException {
		driver.findElement(itemHTC_wishlist).click();
		Thread.sleep(3000);
		driver.findElement(wishListPageBtn).click();
		Thread.sleep(3000);
		driver.findElement(checkBox).click();
		Thread.sleep(3000);
		driver.findElement(addToCartBtn).click();
		Thread.sleep(3000);
		driver.findElement(shCartPage).click();
		boolean displayed = driver.findElement(itemOnShCartPage).isDisplayed();
		if (!displayed) {
			System.out.println("Item Not Added to the wishlist");
			return false;
		}
		System.out.println("Item added successfully to the shopping cart");
		return true;
	}

	public boolean itemPage() throws InterruptedException {
//  driver.findElement(itemHTC_shCart).click();
//  Thread.sleep(3000);
		driver.findElement(shCartPage).click();
		Thread.sleep(3000);
		driver.findElement(htcPage).click();
		Thread.sleep(3000);
		String text = driver.findElement(pathOfHTC).getText();
//  System.out.println(text);
		String text2 = "HTC smartphone";
		if (!text.equals(text2)) {
			System.out.println("Item page not opened.");
			return false;
		}
		System.out.println("Item page opened.");
		return true;
	}

	public boolean increaseOrDecrease() throws InterruptedException {
//  driver.navigate().refresh();
//  driver.findElement(itemHTC_shCart).click();
//  Thread.sleep(3000);
		driver.findElement(shCartPage).click();
		Thread.sleep(3000);
		driver.findElement(increase).click();
		Thread.sleep(500);
		driver.findElement(increase).click();
		Thread.sleep(500);
		driver.findElement(decrease).click();

		System.out.println("Item Increased and Decreased Successfully.");
		return true;
	}

	public boolean checkOutAsGuest() throws InterruptedException {
//  driver.navigate().refresh();
//  driver.findElement(itemHTC_shCart).click();
//  Thread.sleep(3000);
		driver.findElement(shCartPage).click();
		Thread.sleep(3000);
		driver.findElement(agree).click();
		Thread.sleep(3000);
		driver.findElement(checkoutBtn).click();
		Thread.sleep(3000);
		driver.findElement(guest).click();

		boolean displayed = driver.findElement(cheackoutPage).isDisplayed();
		if (!displayed) {
			System.out.println("Checkout Page is not Desplayed");
			return false;
		}
		Thread.sleep(3000);
		System.out.println("Checkout Page is Desplayed");
		return true;
	}

	public boolean checkOutAsUser() throws InterruptedException {
		driver.findElement(homePage).click();
		driver.findElement(itemHTC_shCart).click();
		Thread.sleep(3000);
		driver.findElement(shCartPage).click();
		Thread.sleep(3000);
		driver.findElement(agree).click();
		Thread.sleep(3000);
		driver.findElement(checkoutBtn).click();
		Thread.sleep(2000);

		boolean displayed = driver.findElement(cheackoutPage).isDisplayed();
		if (!displayed) {
			System.out.println("Checkout Page is not Desplayed");
			return false;
		}
		Thread.sleep(3000);
		System.out.println("Checkout Page is Desplayed");
		return true;
	}
	
	public boolean checkOut()throws InterruptedException{
		driver.findElement(agree).click();
		Thread.sleep(3000);
		driver.findElement(checkoutBtn).click();
		boolean displayed = driver.findElement(cheackoutPage).isDisplayed();
		if (!displayed) {
			System.out.println("Checkout Page is not Desplayed");
			return false;
		}
		Thread.sleep(3000);
		System.out.println("Checkout Page is Desplayed");
		return true;
	}

}
