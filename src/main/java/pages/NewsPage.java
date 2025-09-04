package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class NewsPage {
	  private WebDriver driver;
	 // Locators
    private By firstNewsTitle = By.xpath("//a[@href=\"/new-online-store-is-open\"]"); // أول خبر بالهوم
    private By firstNewsDetailsButton = By.cssSelector(".news-items .read-more"); // زر DETAILS لأول خبر
    private By newsPageTitle = By.cssSelector(".page-title h1"); // العنوان في صفحة التفاصيل
    private By viewArchiveLink = By.linkText("View News Archive"); // لينك الأرشيف
    private By archivePageTitle = By.cssSelector(".page-title h1"); // العنوان في صفحة الأرشيف

    // Constructor
    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Click on the first news title 
    public void clickFirstNewsTitle() {
        driver.findElement(firstNewsTitle).click();
    }

    //Click on the first news DETAILS button 
    public void clickFirstNewsDetailsButton() {
        driver.findElement(firstNewsDetailsButton).click();
    }

    // Get the page title after opening a news details 
    public String getNewsDetailsTitle() {
        return driver.findElement(newsPageTitle).getText().trim();
    }

    // Click on View News Archive link 
    public void clickViewArchive() {
        driver.findElement(viewArchiveLink).click();
    }

    // Get archive page title 
    public String getArchivePageTitle() {
        return driver.findElement(archivePageTitle).getText().trim();
    }
}

