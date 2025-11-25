package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    // عناصر الصفحة
    private By genderMaleRadio = By.id("gender-male");
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");

    private By successMessage = By.cssSelector("div.result");
    private By errorSummary = By.cssSelector("div.validation-summary-errors");
    private By fieldErrors = By.cssSelector("span.field-validation-error");


    public boolean areFieldErrorsDisplayed() {
        return driver.findElements(fieldErrors).size() > 0;
    }
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectMaleGender() {
        driver.findElement(genderMaleRadio).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    // طريقة مختصرة لتسجيل يوزر
    public void register(String firstName, String lastName, String email, String password, String confirmPassword) {
        selectMaleGender();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickRegisterButton();
    }

    public boolean isRegistrationSuccessMessageDisplayed() {
        return driver.findElements(successMessage).size() > 0;
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorSummary).size() > 0;
    }

    public String getErrorMessage() {
        if (!isErrorDisplayed()) return "";
        return driver.findElement(errorSummary).getText();
    }
}
