package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    private WebDriver driver;

    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("input.button-1.search-box-button");
    private By productList = By.cssSelector(".product-item");
    private By noResultMessage = By.cssSelector("strong.result");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String keyword) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public void searchUsingEnter(String keyword) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(keyword + Keys.ENTER);
    }

    public boolean isProductListDisplayed() {
        return driver.findElements(productList).size() > 0;
    }

    public boolean isNoResultsDisplayed() {
        return driver.findElements(noResultMessage).size() > 0;
    }
}
