package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ComputersDesktopsPage {
	private  WebDriver driver;
	 // Locators: منيو "Computers" ثم "Desktops" + عنوان الصفحة
    private  By computersTopMenu = By.linkText("Computers");
    private  By desktopsLink = By.linkText("Desktops");
    private  By pageTitle = By.cssSelector(".page-title h1");
    private By list=By.xpath("//a[@data-viewmode=\"list\"]");
    private By Grid=By.xpath("//a[@data-viewmode=\"grid\"]");
    public ComputersDesktopsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Go to Desktops page from the top menu 
    public void goToDesktopsFromTopMenu() {
        driver.findElement(computersTopMenu).click();
        driver.findElement(desktopsLink).click();
    }

   // insure in Desktops or not
    public boolean isOnDesktops() {
        return driver.findElement(pageTitle).getText().trim().equals("Desktops");
    }
    
    public void convertTOlist() {
        driver.findElement(list).click();
    }
    public void convertTOGride() {
        driver.findElement(Grid).click();
    }
}
