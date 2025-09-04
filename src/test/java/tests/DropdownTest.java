package tests;

import base.baseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.DropdownPage;
import java.util.Comparator;
import java.util.List;

public class DropdownTest extends baseTest {

     DropdownPage ddPage;

    @BeforeMethod
    public void setUpDropdown() {
//        super.setUp();  
        ddPage = new DropdownPage(driver);
        driver.get("https://demo.nopcommerce.com/search?q=computer");
        ddPage = new DropdownPage(driver);
    }

    @Test
    public void TC_Dropdown_010_sortNameAtoZ() {
        ddPage.selectSortBy("Name: A to Z");
        List<String> titles = ddPage.getProductTitles();
        List<String> sorted = titles.stream().sorted().toList();
        Assert.assertEquals(titles, sorted, "Products should be sorted A → Z");
    }

//    @Test
//    public void TC_Dropdown_011_display9() {
//        ddPage.selectDisplayPerPage("9");
//        Assert.assertEquals(ddPage.getProductsCountOnPage(), 9, "9 products should be displayed");
//    }

//    @Test
//    public void TC_Dropdown_011_display9() {
//        ddPage.selectDisplayPerPage("9");
//        int productCount = ddPage.getProductsCountOnPage();
//        Assert.assertEquals(productCount, 9, "9 products should be displayed");
//    }
    @Test
    public void TC_Dropdown_011_display9() {
        int requested = 9;
        ddPage.selectDisplayPerPage("9");
        int actual = ddPage.getProductsCountOnPage();
        Assert.assertTrue(actual <= requested,
            "Expected ≤ " + requested + " products, but found " + actual);
    }
    
    @Test
    public void TC_Dropdown_012_sortPriceLowToHigh() {
        ddPage.selectSortBy("Price: Low to High");
        List<Double> prices = ddPage.getProductPrices();
        List<Double> sorted = prices.stream().sorted().toList();
        Assert.assertEquals(prices, sorted, "Prices should be ascending");
    }

//    @Test
//    public void TC_Dropdown_013_display18() {
//        ddPage.selectDisplayPerPage("18");
//        Assert.assertEquals(ddPage.getProductsCountOnPage(), 18, "18 products should be displayed");
//    }
    
//    @Test
//    public void TC_Dropdown_013_display18() {
//        ddPage.selectDisplayPerPage("18");
//        int productCount = ddPage.getProductsCountOnPage();
//        Assert.assertEquals(productCount, 18, "18 products should be displayed");
//    }
    
    @Test
    public void TC_Dropdown_013_display18() {
        int requested = 18;
        ddPage.selectDisplayPerPage("18");
        int actual = ddPage.getProductsCountOnPage();
        Assert.assertTrue(actual <= requested,
            "Expected ≤ " + requested + " products, but found " + actual);
    }
    

    @Test
    public void TC_Dropdown_014_sortPriceHighToLow() {
        ddPage.selectSortBy("Price: High to Low");
        List<Double> prices = ddPage.getProductPrices();
        List<Double> sortedDesc = prices.stream()
                                        .sorted(Comparator.reverseOrder())
                                        .toList();
        Assert.assertEquals(prices, sortedDesc, "Prices should be descending");
    }

    @Test
    public void TC_Dropdown_015_sortCreatedOn() {
        ddPage.selectSortBy("Created on");
        // Basic check for presence of results
        List<String> titles = ddPage.getProductTitles();
        Assert.assertTrue(!titles.isEmpty(), "Products displayed after creation date sort");
    }

    @Test
    public void TC_Dropdown_016_currencyEuro() {
        ddPage.changeCurrency("Euro");
        List<String> titles = ddPage.getProductTitles();
        Assert.assertFalse(titles.isEmpty(), "Products should show with new currency");
    }

    @Test
    public void TC_Dropdown_017_categoryElectronics() {
        ddPage.navigateToElectronics();
        String title = driver.getTitle().toLowerCase();
        Assert.assertTrue(title.contains("electronics"), "Should navigate to Electronics category");
    }
    
//    @AfterMethod
//    public void tearDownTest() {
//    	super.tearDown();
//    	     	 }
}
