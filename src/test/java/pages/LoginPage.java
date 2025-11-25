package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector("input.login-button");
    private By errorSummary = By.cssSelector("div.validation-summary-errors");
    private By rememberMeCheckbox = By.id("RememberMe");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorSummary).size() > 0;
    }

    public String getErrorMessage() {
        if (!isErrorDisplayed()) return "";
        return driver.findElement(errorSummary).getText();
    }
    public void clickRememberMe() {
        driver.findElement(rememberMeCheckbox).click();
    }

    public boolean isRememberMeSelected() {
        return driver.findElement(rememberMeCheckbox).isSelected();
    }
}
