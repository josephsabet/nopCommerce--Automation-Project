package tests;

import base.baseTest;
import pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class LoginTest extends baseTest {
	private LoginPage loginPage; 

	 

	@BeforeMethod 

	public void pageSetup() { 

	loginPage = new LoginPage(driver); 

	} 

	 

	@Test 

	public void openLoginPage() { 

	loginPage.openLoginrPage(); 

	WebElement actualTitle = driver.findElement(By.xpath("//strong[text()='Returning Customer']")); 

	Assert.assertTrue(actualTitle.isDisplayed(), "Login page did not open!"); 

	} 

	 

	@Test(dataProvider = "inValidLogin", dependsOnMethods = "openLoginPage") 

	public void inValidLogin(String email, String password, String description) throws InterruptedException { 

	System.out.println("Running test case: " + description); 

	loginPage.login(email, password); 

	WebElement text = driver.findElement(By.xpath("//button[text()='Log in']")); 
	Thread.sleep(2000); 


	String invalid = text.getText(); 

	Assert.assertEquals(invalid, "LOG IN"); 

	} 

	 

	@DataProvider(name = "inValidLogin") 

	public Object[][] dataProvider1() { 
 

	return new Object[][] {  

	{ "rcolbeck1a@umich.edu", "gN4.rCu", "check if user can login without registering" }, 

	{ " ", " ", "check if user can login without filling the credentials" }, 

	{ "tZ7~LoT'9a&V", "awillmottb1@google.de", "Verify login fails when email and password fields are swapped" } }; 

	} 

	 

	@Test(dataProvider = "showPassword",dependsOnMethods = "inValidLogin") 

	public void clickEyeIcon(String email, String password, String description) throws InterruptedException { 

	System.out.println("Running test case: " + description); 

	loginPage.clickEyeIcon(); 

	WebElement open = driver.findElement(By.xpath("//span[@class='password-eye password-eye-open']")); 

	boolean eyeOpen = open.isEnabled(); 
	Thread.sleep(2000); 


	Assert.assertTrue(eyeOpen); 

	} 

	@DataProvider(name = "showPassword") 

	public Object[][] dataProvider2() { 

	 

	return new Object[][] { 

	{ "awillmottb1@google.de", "tZ7~LoT'9a&V", "Verify that the \\\"Show/Hide Password button\\\" works" } }; 

	} 

	@Test(dependsOnMethods = "clickEyeIcon") 

	public void clickRegister() throws InterruptedException { 

	System.out.println("Running test case: Verify that Register button in  login page works"); 

	loginPage.clickRegisterButton(); 

	WebElement register = driver.findElement(By.xpath("//strong[text()='Your Personal Details']")); 

	String acessRegister = register.getText(); 
	Thread.sleep(2000); 


	Assert.assertEquals(acessRegister, "Your Personal Details"); 

	loginPage.openLoginrPage(); 

	} 

	 

	 

	@Test(dataProvider = "validLogin", dependsOnMethods = "clickRegister") 

	public void validLogin(String email, String password, String description) throws InterruptedException { 

	System.out.println("Running test case: " + description); 

	loginPage.login(email, password); 

	Thread.sleep(2000); 

	WebElement text = driver.findElement(By.xpath("//a[text()='Log out']")); 

	String successfulLogin = text.getText(); 

	 

	Assert.assertEquals(successfulLogin, "Log out"); 

	} 

	 
//الايميل لازم يكون نفس اregister  validregister
	@DataProvider(name = "validLogin") 

	public Object[][] dataProvider3() { 
	return new Object[][] { 

	{ "faisal304800@google.de", "tZ7~LoT'9a&V", "check if user can login with valid credentials" } }; 

	} 

	@Test( dependsOnMethods = "validLogin") 

	public void accessToMyAccount() throws InterruptedException { 

	System.out.println("Running test case: Verify that after valid login, user can access My account page"); 

	loginPage.accessMyAccountPageAfterLogin(); 

	 

	WebElement account = driver.findElement(By.xpath("//a[@class='ico-account']")); 

	Boolean acessMyAccount = account.isDisplayed(); 
	Thread.sleep(2000); 


	Assert.assertTrue(acessMyAccount); 

	} 

	@Test( dependsOnMethods = "accessToMyAccount") 

	public void logout() throws InterruptedException { 

	System.out.println("Running test case: Verify that the \"logout\" button works "); 

	loginPage.clickLogout(); 

	Thread.sleep(2000); 


	WebElement login = driver.findElement(By.xpath("//a[text()='Log in']")); 

	Boolean acesslogin = login.isDisplayed(); 

	Assert.assertTrue(acesslogin); 

	} 

	@Test( dataProvider = "rememberMe",dependsOnMethods = "logout") 

	public void testRememberMeButton(String email, String password, String description) throws InterruptedException { 

	System.out.println("Running test case: " + description); 

	loginPage.rememberMe(email, password); 
	Thread.sleep(2000); 

	driver.findElement(By.xpath("//a[text()='Log in']")).click(); 

	WebElement emailfield = driver.findElement(By.xpath("//input[@id='Email']")); 

	Assert.assertEquals(emailfield.getAttribute("value"), ""); 

	}	 

	@DataProvider(name = "rememberMe") 

	public Object[][] dataProvider4() { 

	 

	return new Object[][] { 

	{ "awillmottb1@google.de", "tZ7~LoT'9a&V", "check if \"Remember me\" button works " } }; 

	} 

	@Test(dependsOnMethods = "testRememberMeButton") 

	public void testForgotPasswordButton() throws InterruptedException  { 

	System.out.println("Running test case: check if \"forgot Password\" function works "); 

	loginPage.clickForgotPasswordButton(); 

	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("awillmottb1@google.de"); 

	Thread.sleep(2000); 

	driver.findElement(By.xpath("//button[text()='Recover']")).click(); 

	WebElement text=driver.findElement(By.xpath("//p[text()='Email with instructions has been sent to you.']")); 

	Assert.assertEquals(text.getText(),"Email with instructions has been sent to you."); 

	}	 

	 

	@Test(dependsOnMethods = "testForgotPasswordButton") 

	public void sendUnregisterdEmail() throws InterruptedException  { 

	WebElement email=driver.findElement(By.xpath("//input[@id='Email']")); 

	email.clear(); 

	email.sendKeys("rcolbeck1a@umich.edu"); 

	driver.findElement(By.xpath("//button[text()='Recover']")).click(); 

	Thread.sleep(2000); 

	WebElement text=driver.findElement(By.xpath("//p[text()='Email not found.']")); 

	Assert.assertEquals(text.getText(),"Email not found."); 

	 

	} 
}
