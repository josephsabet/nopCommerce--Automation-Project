package workflows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.baseTest;
import pages.DropdownPage;
import pages.SearchPage;

public class ItemNotFound extends baseTest {
	// homepage => Choose Euro Currency => Negative Search => Item Not Found
	private DropdownPage dropdown;
	private SearchPage search;

	@BeforeMethod
	public void setUpDropdown() {
		dropdown = new DropdownPage(driver);
		search = new SearchPage(driver);
	}

	@Test
	public void testITemNoTfoundWithEuro() throws InterruptedException {
		dropdown.changeCurrency("Euro");
		search.enterSearchTextWithNoItem("Toyota Land Cruiser");
		Thread.sleep(5000);
		search.clickSearch();
		Thread.sleep(5000);

		boolean result = search.getTextWithNoproduct();
		Thread.sleep(3000);
		Assert.assertTrue(result, "It should check out successfully.");
		// return value

//  Assert.assertTrue(result, "The item should not be found.");
	}
}
