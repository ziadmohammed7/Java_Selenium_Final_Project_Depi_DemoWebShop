package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By loginLink = By.className("ico-login");
    private By logoutLink = By.className("ico-logout");
    private By registerLink = By.className("ico-register");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    public void openLoginPage() {
        driver.findElement(loginLink).click();
    }

    public void openRegisterPage() {
        driver.findElement(registerLink).click();
    }

    public boolean isLogoutVisible() {
        return driver.findElements(logoutLink).size() > 0;
    }

    public boolean isUserLoggedIn() {
        return isLogoutVisible();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
}
