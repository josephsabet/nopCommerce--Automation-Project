package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage {
    private WebDriver driver;

    // Locators
    private By searchInput = By.id("small-searchterms");
    private By searchButton = By.cssSelector("button.search-box-button");
    private By resultItems = By.cssSelector(".product-item");
    private By noResultsMessage = By.cssSelector(".no-result");
    private By autoCompleteSuggestions = By.cssSelector("ul.ui-autocomplete li");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterSearchText(String text) {
        WebElement input = driver.findElement(searchInput);
        input.clear();
        input.sendKeys(text);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
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
