package tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseTest;
import pages.RegisterPage;

public class RegisterTest extends baseTest {
	private RegisterPage registerPage;

	@BeforeMethod

	public void pageSetup() {

		registerPage = new RegisterPage(driver);

	}

	@Test

	public void openRegisterPage() {

		registerPage.openRegisterPage();

		WebElement actualTitle = driver.findElement(By.xpath("//strong[text()='Your Personal Details']"));

		Assert.assertTrue(actualTitle.isDisplayed(), "Register page did not open!");

	}

	@Test(dataProvider = "invalidRegister", dependsOnMethods = "openRegisterPage")

	public void testInvalidRegister(String firstName, String lastName, String email, String password,

			String confirmPassword, String description) {

		System.out.println("Running test case: " + description);

		registerPage.register(firstName, lastName, email, password, confirmPassword);

		WebElement text = driver.findElement(By.xpath("//button[text()='Register']"));

		String invalidRegister = text.getText();

		Assert.assertEquals(invalidRegister, "REGISTER");

	}

	@DataProvider(name = "invalidRegister")

	public Object[][] dataProvider1() {
		String uniqueEmail = "user" + (System.currentTimeMillis() + new Random().nextInt(1000)) + "@gmail.com";
// new email
		return new Object[][] {

				{ "Zolly", "Howood", "a", "aO5},v$c", "aO5},v$c",

						"check if user can register a new account using invalid E-mail format" },

				{ "Ardyce", "Mabone", uniqueEmail, "1", "1",

						"Check if the user can register a new account using a password with only 1 character" },

				{ "Genevra", "Ortas", "gortas1@geocities.jp",

						"1111111111111111111111111111111111111111111111111111111111111111111111",

						"1111111111111111111111111111111111111111111111111111111111111111111111",

						"check if user can register a new account by filling the password field with 70 charecter" },

				{ "Isidor", "Leyman", "مستخدم1@hotmail.com", "jB2%e\\B4", "jB2%e\\B4",

						"check if user can register a new account by filling the E-mail field in arabic " },

				{ " ", " ", " ", " ", " ", "check if user can register a new account without filling any field " },

				{ "Shayne", "Shayne", "svand enhof7  @1und1.de", "mR7)Q#T!Y", "mR7)Q#T!Y",

						"Verify registration fails with spaces in email" },

		};

	}

	@Test(dataProvider = "usedEmail1", dependsOnMethods = "testInvalidRegister")

	public void usedEmail1(String firstName, String lastName, String email, String password,

			String confirmPassword, String description) {

		System.out.println("Running test case: " + description);

		registerPage.register(firstName, lastName, email, password, confirmPassword);

		registerPage.clickLogout();

		registerPage.openRegisterPage();

	}

//dyanmic same email  here
	@DataProvider(name = "usedEmail1")

	public Object[][] dataProvider9() {

		return new Object[][] { { "Cletis", "Guntrip", "aya300700@hotmail.com", "iB6}9{D\\dbE", "iB6}9{D\\dbE",

				"check if user can register a new account by using a used Email address(registering for the email for the first time)" } };

	}

	@Test(dataProvider = "usedEmail2", dependsOnMethods = "usedEmail1")

	public void usedEmail2(String firstName, String lastName, String email, String password,

			String confirmPassword, String description) throws InterruptedException {

		System.out.println("Running test case: " + description);

		registerPage.register(firstName, lastName, email, password, confirmPassword);

		Thread.sleep(2000);

		WebElement text = driver.findElement(By.xpath("//button[text()='Register']"));

		String invalidRegister = text.getText();

		Assert.assertEquals(invalidRegister, "REGISTER");

	}

//dyanmic same email here
	@DataProvider(name = "usedEmail2")

	public Object[][] dataProvider10() {

		return new Object[][] { { "Cletis", "Guntrip", "aya300700@hotmail.com", "iB6}9{D\\dbE", "iB6}9{D\\dbE",

				"check if user can register a new account by using a used Email address(registering for the email for the second time)" } };

	}

	@Test(dataProvider = "optionalFieldsMale", dependsOnMethods = "usedEmail2")

	public void testValidRegisterWithOptionalFieldsMale(String firstName, String lastName, String email,

			String companyName, String password, String confirmPassword, String description) {

		System.out.println("Running test case: " + description);

		registerPage.registerUsingOpptionalFieldsMale(firstName, lastName, email, companyName, password,

				confirmPassword);

		WebElement text = driver.findElement(By.xpath("//div[@class='result']"));

		String successfulRegister = text.getText();

		Assert.assertEquals(successfulRegister, "Your registration completed");

	}

//danamic  //new email

	@DataProvider(name = "optionalFieldsMale")
	public Object[][] dataProvider2() {
		String uniqueEmail2 = "user" + (System.currentTimeMillis() + new Random().nextInt(1000)) + "@gmail.com";
		return new Object[][] { { "Damien", "Faithorn", uniqueEmail2, "google", "aU3)eSc|", "aU3)eSc|",

				"Verify registration succeeds with valid optional fields and Male as gender." } };

	}

	@Test(dataProvider = "optionalFieldsFemale", dependsOnMethods = "testValidRegisterWithOptionalFieldsMale")

	public void testValidRegisterWithOptionalFieldsFelamle(String firstName, String lastName, String email,

			String companyName, String password, String confirmPassword, String description)

			throws InterruptedException {

		System.out.println("Running test case: " + description);

		driver.findElement(By.xpath("//a[text()='Log out']")).click();

		driver.findElement(By.xpath("//a[text()='Register']")).click();

		registerPage.registerUsingOpptionalFieldsFemale(firstName, lastName, email, companyName, password,

				confirmPassword);

		Thread.sleep(2000);

		WebElement text = driver.findElement(By.xpath("//div[text()='Your registration completed']"));

		String successfulRegister = text.getText();

		Assert.assertEquals(successfulRegister, "Your registration completed");

	}

//		 dYNAMI   //new email

	@DataProvider(name = "optionalFieldsFemale")

	public Object[][] dataProvider3() {
		String uniqueEmail3 = "user" + (System.currentTimeMillis() + new Random().nextInt(1000)) + "@gmail.com";
		return new Object[][] { { "Judy", "Erasmus", uniqueEmail3, "google", "yM8'AT", "yM8'AT",

				"Verify registration succeeds with valid optional fields and Female as gender." } };

	}

	@Test(dataProvider = "validRegister", dependsOnMethods = "testValidRegisterWithOptionalFieldsFelamle")

	public void testValidRegister(String firstName, String lastName, String email, String password,

			String confirmPassword, String description) {

		System.out.println("Running test case: " + description);

		driver.findElement(By.xpath("//a[text()='Log out']")).click();

		driver.findElement(By.xpath("//a[text()='Register']")).click();

		registerPage.register(firstName, lastName, email, password, confirmPassword);

		WebElement text = driver.findElement(By.xpath("//div[text()='Your registration completed']"));

		String successfulRegister = text.getText();

		Assert.assertEquals(successfulRegister, "Your registration completed");

	}

//new email here
	@DataProvider(name = "validRegister")
	public Object[][] dataProvider4() {
		return new Object[][] { { "Ali", "Willmott", "faisal304800@google.de", "tZ7~LoT'9a&V", "tZ7~LoT'9a&V",
				"check if user can register a new account using valid credentials" } };
	}
}
