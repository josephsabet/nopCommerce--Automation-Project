package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseTest;
import pages.SearchPage;

public class SearchTest extends baseTest {
	SearchPage searchPage;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() {
		super.setUp();
		searchPage = new SearchPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@DataProvider(name = "searchTerms")
	public Object[][] searchData() {
		return new Object[][] { { "computer", true }, { "nonexistentproduct", false }, { "!@#$%", false },
				{ "", false }, { "comp", true } };
	}

	@Test(dataProvider = "searchTerms")
	public void testSearch(String term, boolean hasResults) throws InterruptedException {
		searchPage.enterSearchText(term);
		searchPage.clickSearch();
//		Thread.sleep(4000);
//		if (term.isEmpty()) {
//			try {
//				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//				Assert.assertEquals(alert.getText(), "Please enter some search keyword");
//				alert.accept();
//			} catch (Exception e) {
//				Assert.fail("Expected an alert for empty search, but none appeared");
//			}
//			return;
//		}
		
		if (term.isEmpty()) {
		    try {
		        wait.until(ExpectedConditions.visibilityOfElementLocated(searchPage.getWarningMessageLocator()));
		        Assert.assertTrue(searchPage.isWarningMessageDisplayed(), "Expected warning message for empty search");
		    } catch (Exception e) {
		        Assert.fail("Expected a warning message for empty search, but none appeared");
		    }
		    return;
		}


		// Wait for either results or no-result message to appear
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(searchPage.getResultItemsLocator()),
				ExpectedConditions.visibilityOfElementLocated(searchPage.getNoResultsLocator())));

		List<WebElement> results = searchPage.getResults();
		if (hasResults) {
			Assert.assertTrue(results.size() > 0, "Expected search results for term: " + term);
		} else {
			boolean noResultMsg = searchPage.isNoResultsMessageDisplayed();
			Assert.assertTrue(results.isEmpty() || noResultMsg, "Expected no results (or message) for term: " + term);
		}
	}

	@Test
	public void testSearchBoxVisible() {
		Assert.assertTrue(searchPage.isSearchBoxVisible(), "Search box should be visible on page load");
	}

	@Test
	public void testPlaceholderText() {
		String placeholder = searchPage.getPlaceholderText();
		Assert.assertEquals(placeholder, "Search store", "Placeholder text should guide the user");
	}

	@Test
	public void testAutocompleteSuggestions() {
		searchPage.enterSearchText("comp");

		List<WebElement> suggestions = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(searchPage.getAutoCompleteSuggestionsLocator()));

		Assert.assertFalse(suggestions.isEmpty(), "Expected autocomplete suggestions for partial term");
	}

	@AfterTest
	public void tearDownTest() {
		tearDown();
	}
}
