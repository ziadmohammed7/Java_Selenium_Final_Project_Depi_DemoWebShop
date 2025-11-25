package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test(priority = 1)
    public void searchWithValidKeyword() {
        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);

        home.openHomePage();
        search.search("computer");

        Assert.assertTrue(search.isProductListDisplayed(), "Products list NOT displayed for valid keyword!");
    }

        @Test(priority = 2)
        public void searchWithInvalidKeyword() {
            HomePage home = new HomePage(driver);
            SearchPage search = new SearchPage(driver);

            home.openHomePage();
            search.search("xyz123");

            Assert.assertTrue(search.isNoResultsDisplayed(), "No-result message NOT displayed!");
        }

    @Test(priority = 3)
    public void searchUsingEnterButton() {
        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);

        home.openHomePage();
        search.searchUsingEnter("book");

        Assert.assertTrue(search.isProductListDisplayed(), "Products NOT displayed when searching with ENTER!");
    }
}
