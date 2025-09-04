package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    // Locators
    private By searchInput = By.id("small-searchterms");
    private By searchInputWithEuro = By.xpath("//input[@id=\"small-searchterms\"]");
    private By searchButton = By.cssSelector("button.search-box-button");
    private By resultItems = By.cssSelector(".product-item");
    private By noResultsMessage = By.cssSelector(".no-result");
    private By autoCompleteSuggestions = By.cssSelector("ul.ui-autocomplete li");
    private By warningMessage = By.cssSelector(".warning"); // adjust selector if needed
    private By noresult = By.xpath("//div[@class=\"no-result\"]");
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterSearchText(String text) {
        WebElement input = driver.findElement(searchInput);
        input.clear();
        input.sendKeys(text);
        
        Actions actions = new Actions(driver);
        actions
          .click(input)
          .keyDown(Keys.CONTROL)
          .sendKeys(Keys.SPACE)
          .keyUp(Keys.CONTROL)
          .perform();
    }
    public void enterSearchTextWithNoItem(String text) {
        WebElement input = driver.findElement(searchInputWithEuro); 
        input.sendKeys(text);
    }

    public boolean isWarningMessageDisplayed() {
        return !driver.findElements(warningMessage).isEmpty() &&
               driver.findElement(warningMessage).isDisplayed();
    }

    public By getWarningMessageLocator() {
        return warningMessage;
    }

    
    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
    public boolean getTextWithNoproduct() {
        String text = driver.findElement(noresult).getText();
        String expectedText = "No products were found that matched your criteria.";
        
        if (text.equals(expectedText)) {
            return true;
        } else {
            return false;
        }
    }

    public List<WebElement> getResults() {
        return driver.findElements(resultItems);
    }

    public boolean isNoResultsMessageDisplayed() {
        return !driver.findElements(noResultsMessage).isEmpty() &&
               driver.findElement(noResultsMessage).isDisplayed();
    }

    public boolean isSearchBoxVisible() {
        return driver.findElement(searchInput).isDisplayed();
    }

    public String getPlaceholderText() {
        return driver.findElement(searchInput).getAttribute("placeholder");
    }

    public List<WebElement> getAutoCompleteSuggestions() {
        return driver.findElements(autoCompleteSuggestions);
    }

    // Locator getters for explicit waits
    public By getResultItemsLocator() {
        return resultItems;
    }

    public By getNoResultsLocator() {
        return noResultsMessage;
    }

    public By getAutoCompleteSuggestionsLocator() {
        return autoCompleteSuggestions;
    }
}
