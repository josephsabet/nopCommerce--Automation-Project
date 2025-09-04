package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.baseTest;
import pages.NewsPage;

public class NewsPageTest extends baseTest {
	NewsPage news;

	@BeforeMethod
	public void object() {
		news = new NewsPage(driver);
	}

	@Test(priority = 1)
	public void TC_NEWS_01_VerifyClickingNewsTitleOpensDetails() {
		news.clickFirstNewsTitle();
		Assert.assertTrue(news.getNewsDetailsTitle().length() > 0, "News details page not opened!");
	}

	@Test(priority = 2)
	public void TC_NEWS_02_VerifyClickingDetailsButtonOpensSameNewsPage() {
//        driver.get(baseUrl);
		driver.navigate().back();
		news.clickFirstNewsDetailsButton();
		Assert.assertTrue(news.getNewsDetailsTitle().length() > 0, "Details button did not open news page!");
	}

	@Test(priority = 3)
	public void TC_NEWS_03_VerifyClickingViewArchiveOpensArchivePage() {
//        driver.get(baseUrl);
		driver.navigate().back();

		news.clickViewArchive();
		Assert.assertEquals(news.getArchivePageTitle(), "News", "Archive page not opened correctly!");
	}

}
