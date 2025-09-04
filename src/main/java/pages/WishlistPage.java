package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WishlistPage {
	private WebDriver driver;
	private Actions actions;

	private By homePage = By.xpath("(//a[@href='/'])[1]");
	private By itemHTC_wishlist = By.xpath("(//div[@class='item-box'])[6]//button[@type='button'][3]");
	private By wishListPage = By.xpath("(//a[@href='/wishlist'])[1]");
	private By itemOnWishlistPage = By.tagName("tr");
	private By computersHover = By.xpath("(//a[@href='/computers'])[1]");
	private By desktopPage = By.xpath("(//a[@href='/desktops'])[1]");
	private By lenovoItem_wishlist = By.xpath("(//div[@class='item-box'])[3]//button[@type='button'][3]");
	private By removeBtn = By.className("remove-btn");
	private By itemComp = By.xpath("(//div[@class='item-box'])[4]//button[@type='button'][3]");
	private By addToWishList = By.id("add-to-wishlist-button-1");
	private By errMsg = By.xpath("//p[@class='content']");
	private By closeErrMSG = By.className("close");

	private By regPage = By.className("ico-register");
	private By firstNameField = By.id("FirstName");
	private By lastNameField = By.id("LastName");
	private By emailField = By.id("Email");
	private By passwordField = By.id("Password");
	private By passwordFieldConfirmation = By.id("ConfirmPassword");
	private By regBtn = By.id("register-button");

	public WishlistPage(WebDriver driver) {
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
		Thread.sleep(2000);
		driver.findElement(lastNameField).sendKeys("name");
		Thread.sleep(2000);
		driver.findElement(emailField).sendKeys("username2@gmail.com");
		Thread.sleep(2000);
		driver.findElement(passwordField).sendKeys("username1234");
		Thread.sleep(2000);
		driver.findElement(passwordFieldConfirmation).sendKeys("username1234");
		Thread.sleep(2000);
		driver.findElement(regBtn).click();
		Thread.sleep(3000);
	}

	public boolean clickOnItem_HomePage() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(itemHTC_wishlist).click();
//		Thread.sleep(3000);
		driver.findElement(wishListPage).click();
		Thread.sleep(3000);
		boolean displayed = driver.findElement(itemOnWishlistPage).isDisplayed();
		if (!displayed) {
			System.out.println("Item Not Added to the wishlist");
			return false;
		}
		System.out.println("Item added successfully to the wishlist");
		Thread.sleep(1000);
		return true;
	}

	public boolean clickOnItem_DesktopPage() throws InterruptedException {
		actions.moveToElement(driver.findElement(computersHover)).perform();
		driver.findElement(desktopPage).click();
		Thread.sleep(3000);
		driver.findElement(lenovoItem_wishlist).click();
		Thread.sleep(3000);
		driver.findElement(wishListPage).click();
		Thread.sleep(3000);
		boolean displayed = driver.findElement(itemOnWishlistPage).isDisplayed();
		if (!displayed) {
			System.out.println("Item Not Added to the wishlist");
			return false;
		}
		System.out.println("Item added successfully to the wishlist");
		Thread.sleep(3000);
		return true;
	}

	public boolean removeItem() throws InterruptedException {
		driver.findElement(wishListPage).click();
		Thread.sleep(3000);
		driver.findElement(removeBtn).click();
		Thread.sleep(3000);
		System.out.println("Item Removed");
		return true;
	}

	public boolean errorMSG() throws InterruptedException {
		driver.findElement(itemComp).click();
		Thread.sleep(3000);
		driver.findElement(addToWishList).click();
		Thread.sleep(3000);
		boolean displayed = driver.findElement(errMsg).isDisplayed();
		if (!displayed) {
			System.out.println("ErrorMSG Not Displayed");
			return false;
		}
		System.out.println("ErrorMSG Displayed");
		Thread.sleep(1000);
		driver.findElement(closeErrMSG).click();
		return true;
	}
	
	
}
