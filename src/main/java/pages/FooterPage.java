package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class FooterPage {
	 private WebDriver driver;

	    // Locators
	    private By footerLinks = By.cssSelector("div.footer a"); // كل الروابط بالفوتر
	    private By socialIcons = By.cssSelector("div.footer .social a"); // أيقونات السوشال
	    private By newsletterInput = By.id("newsletter-email");
	    private By newsletterButton = By.id("newsletter-subscribe-button");
	    private By newsletterResult = By.id("newsletter-result-block"); // رسالة النجاح/الفشل

	    // Constructor
	    public FooterPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    //Return all footer links 
	    public List<WebElement> getAllFooterLinks() {
	        return driver.findElements(footerLinks);
	    }

	    // Check if all footer links are clickable (enabled + href موجود) 
	    public boolean areAllFooterLinksClickable() {
	        List<WebElement> links = getAllFooterLinks();
	        for (WebElement link : links) {
	            if (!link.isDisplayed() || !link.isEnabled() || link.getAttribute("href") == null) {
	                return false;
	            }
	        }
	        return true;
	    }

	    //Return all social media icons 
	    public List<WebElement> getAllSocialIcons() {
	        return driver.findElements(socialIcons);
	    }

	    //Check if all social icons are clickable (href موجودة) 
	    public boolean areAllSocialIconsClickable() {
	        List<WebElement> icons = getAllSocialIcons();
	        for (WebElement icon : icons) {
	            if (!icon.isDisplayed() || !icon.isEnabled() || icon.getAttribute("href") == null) {
	                return false;
	            }
	        }
	        return true;
	    }

	    // Subscribe to newsletter with a given email 
	    public void subscribeToNewsletter(String email) {
	        driver.findElement(newsletterInput).clear();
	        driver.findElement(newsletterInput).sendKeys(email);
	        driver.findElement(newsletterButton).click();
	    }

	    // Get the result message after subscription 
	    public String getNewsletterResultMessage() throws InterruptedException {
	    	Thread.sleep(3000);
	    	//System.out.println(driver.findElement(newsletterResult).getText());
	        return driver.findElement(newsletterResult).getText();
	    }
}
