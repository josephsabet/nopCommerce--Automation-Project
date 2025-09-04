package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	private WebDriver driver; 

	private WebDriverWait wait; 

	private By openRegisterPage= By.xpath("//a[text()='Register']"); 

	private By genderMale= By.xpath("//input[@value='M']"); 

	private By genderFemale= By.xpath("//input[@value='F']"); 

	private By firstNameInput= By.xpath("//input[@id='FirstName']"); 

	private By lastNameInput= By.xpath("//input[@id='LastName']"); 

	private By emailInput= By.xpath("//input[@id='Email']"); 

	private By companyNameInput= By.xpath("//input[@id='Company']"); 

	private By newsLetter= By.xpath("//input[@id='Newsletter']");//By default True 

	private By passwordInput= By.xpath("//input[@id='Password']"); 

	private By confirmPasswordInput= By.xpath("//input[@id='ConfirmPassword']"); 

	private By registerButton= By.xpath("//button[@name='register-button']"); 

	private By logoutButton= By.xpath("//a[text()='Log out']"); 

	 

	    public RegisterPage(WebDriver driver) {

	        this.driver = driver; 

	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 

	    } 

	    public void openRegisterPage() { 

	    	WebElement registerPage=wait.until(ExpectedConditions.visibilityOfElementLocated(openRegisterPage)); 

	    	registerPage.click(); 

	    } 

	    public void choseGenderMale() { 

	    	driver.findElement(genderMale).click(); 

	    } 

	    public void choseGenderFemaleale() { 

	    	driver.findElement(genderFemale).click(); 

	    } 

	    public void fillFirstName(String firstName) { 

	    	WebElement first = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)); 

	    	first.clear(); 

	    	first.sendKeys(firstName); 

	    } 

	    public void fillLastName(String lastName) { 

	    	WebElement last=wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)); 

	    	last.clear(); 

	    	last.sendKeys(lastName);; 

	    } 

	    public void fillEmail(String email) { 

	    	WebElement mail= wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)); 

	    	mail.clear(); 

	    	mail.sendKeys(email); 

	    } 

	    public void fillCompanyName(String companyName) { 

	    	WebElement company= wait.until(ExpectedConditions.visibilityOfElementLocated(companyNameInput)); 

	    	company.clear(); 

	    	company.sendKeys(companyName); 

	    } 

	    public void clickNewsLetter() { 

	    	driver.findElement(newsLetter).click(); 

	    } 

	    public void fillPassword(String password) { 

	    	WebElement pass= wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)); 

	    	pass.clear(); 

	    	pass.sendKeys(password); 

	    } 

	    public void fillConfirmPassword(String confirmPassword) { 

	    	WebElement confirm =wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInput)); 

	    	confirm.clear(); 

	    	confirm.sendKeys(confirmPassword); 

	    } 

	    public void clickRegister() { 

	    	WebElement registerButton1 =wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton)); 

	    	registerButton1.click(); 

	    } 

	    public void clickLogout() { 

	    	WebElement logout =wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)); 

	    	logout.click(); 

	    } 

	    public void register(String firstName, String lastName,String email,String password,String confirmPassword) { 

	    	fillFirstName(firstName); 

	    	fillLastName(lastName); 

	    	fillEmail(email); 

	    	fillPassword(confirmPassword); 

	    	fillConfirmPassword(confirmPassword); 

	    	clickNewsLetter(); 

	    	clickRegister(); 

	    } 

	    public void registerUsingOpptionalFieldsMale(String firstName, String lastName,String email,String companyName,String password,String confirmPassword)   { 

	    	choseGenderMale(); 

	    	fillFirstName(firstName); 

	    	fillLastName(lastName); 

	    	fillEmail(email); 

	    	fillCompanyName(confirmPassword); 

	    	fillPassword(confirmPassword); 

	    	fillConfirmPassword(confirmPassword); 

	    	clickRegister(); 

	     

	    } 

	    public void registerUsingOpptionalFieldsFemale(String firstName, String lastName,String email,String companyName,String password,String confirmPassword) { 

	    	choseGenderFemaleale(); 

	    	fillFirstName(firstName); 

	    	fillLastName(lastName); 

	    	fillEmail(email); 

	    	fillCompanyName(companyName); 

	    	fillPassword(password); 

	    	fillConfirmPassword(confirmPassword); 

	    	clickRegister(); 

	    	 

	    } 

	 

	 

}
