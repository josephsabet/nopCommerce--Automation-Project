package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	  private final WebDriver driver;
		 
	    // Locators 
	    private final By storeLogo = By.cssSelector("div.header-logo a");
	    private final By voteExcellent=By.xpath("//input[@id=\"pollanswers-1\"]");
	    private final By voteBtn=By.id("vote-poll-1");
	    private final By ErrorMessage=By.xpath("//div[@id=\"block-poll-vote-error-1\"]");
	    private By Shopping_cart=By.xpath("(//a[@href='/cart'])[1]");
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    //click on logo
	    public void clickLogo() {
	        driver.findElement(storeLogo).click();
	    }

//	    click on shopping cart
	     public void clickShoppingCart() {
	    	 driver.findElement(Shopping_cart).click();
	     }
	    
	    //insure in home or not
	
	    public boolean isOnHome() {
	        return driver.getCurrentUrl().equalsIgnoreCase("https://demo.nopcommerce.com/");
	    }
	    //voting
	    public void votingExcellent(){
	        driver.findElement(voteExcellent).click();
	        driver.findElement(voteBtn).click();
	        
	    }
	    public String getErrorMessage() throws InterruptedException {
	    	Thread.sleep(3000);
	    	//System.out.println(driver.findElement(newsletterResult).getText());
	        return driver.findElement(ErrorMessage).getText();
	    }
	    
}
