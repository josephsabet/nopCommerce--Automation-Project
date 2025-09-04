package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;

	private WebDriverWait wait;

	private By openLoginPage = By.xpath("//a[text()='Log in']");

	private By emailInput = By.xpath("//input[@id='Email']");

	private By passwordInput = By.xpath("//input[@id='Password']");

	private By eyeIconButton = By.xpath("//span[@class='password-eye']");// Button That Shows Written Password

	private By rememberMeButton = By.xpath("//input[@id='RememberMe']");

	private By forgotPasswordButton = By.xpath("//a[text()='Forgot password?']");

	private By loginButton = By.xpath("//button[text()='Log in']");

	private By registerButton = By.xpath("//button[text()='Register']");

	private By myaccoountButton = By.xpath("//a[@class='ico-account']");

	private By logoutButton = By.xpath("//a[text()='Log out']");

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void openLoginrPage() {

		WebElement loginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(openLoginPage));

		loginPage.click();

	}

	public void fillEmail(String email) {

		WebElement mail = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));

		mail.clear();

		mail.sendKeys(email);
		;

	}

	public void fillPassword(String password) {

		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));

		pass.clear();

		pass.sendKeys(password);

	}

	public void clickEyeIcon() {

		driver.findElement(eyeIconButton).click();

	}

	public void clickRememberMeButton() {

		driver.findElement(rememberMeButton).click();

	}

	public void clickForgotPasswordButton() {

		driver.findElement(forgotPasswordButton).click();

	}

	public void clickLoginButton() {

		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

		login.click();

	}

	public void clickRegisterButton() {

		WebElement register = wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));

		register.click();

	}

	public void accessMyAccountPageAfterLogin() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(myaccoountButton));

	}

	public void clickLogout() {

		WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

		logout.click();

	}

	public void login(String email, String password) {

		fillEmail(email);

		fillPassword(password);

		clickLoginButton();

	}

	public void invalidLogin(String email, String password) {

		fillEmail(email);

		fillPassword(password);

		clickLoginButton();

	}

	public void clickEyeIconButton() {

		clickEyeIcon();

	}

	public void rememberMe(String email, String password) {

		openLoginrPage();

		fillEmail(email);

		fillPassword(password);

		clickRememberMeButton();

		clickLoginButton();

		clickLogout();

		openLoginrPage();

	}

}
