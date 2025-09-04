package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));        
        
    }

    private By sortByDropdown = By.id("products-orderby");
    private By displayPerPageDropdown = By.id("products-pagesize");
    private By productTitles = By.cssSelector(".product-item .product-title a");
    private By productPrices = By.cssSelector(".product-item .prices"); 
    private By currencyDropdown = By.id("customerCurrency");
    private By productPricesValue = By.cssSelector(".product-item .prices"); // same selector
    private By electronicsCategory = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']");
  
    public void selectSortBy(String optionText) {
        WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(sortByDropdown));
        new Select(dd).selectByVisibleText(optionText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitles)); // Wait for product titles to load
    }


//    public void selectDisplayPerPage(String optionText) {
//        WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(displayPerPageDropdown));
//        new Select(dd).selectByVisibleText(optionText);
//        wait.until(ExpectedConditions.stalenessOf(dd));
//    }
    
    
//    public void selectDisplayPerPage(String optionText) {
//        WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(displayPerPageDropdown));
//        new Select(dd).selectByVisibleText(optionText);
//        // Wait for product list to refresh after selection
//        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productTitles, 0));
//    }
    
    public void selectDisplayPerPage(String optionText) {
        WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(displayPerPageDropdown));
        new Select(dd).selectByVisibleText(optionText);
        // Wait for product items to be visible
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productTitles, 0));
    }
    
    public List<String> getProductTitles() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTitles))
                   .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Double> getProductPrices() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPricesValue))
                   .stream()
                   .map(e -> e.getText().replaceAll("[^0-9.]", ""))
                   .map(Double::parseDouble)
                   .collect(Collectors.toList());
    }

    public void changeCurrency(String currency) {
        WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(currencyDropdown));
        new Select(dd).selectByVisibleText(currency);
        wait.until(ExpectedConditions.stalenessOf(dd));
    }

    public void navigateToElectronics() {
        wait.until(ExpectedConditions.elementToBeClickable(electronicsCategory)).click();
        wait.until(ExpectedConditions.titleContains("Electronics"));
    }

    public int getProductsCountOnPage() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTitles)).size();
    }
    

}
