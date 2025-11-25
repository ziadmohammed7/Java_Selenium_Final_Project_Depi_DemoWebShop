package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    String validEmail = "mohammedziad@gmail.com";
    String validPassword = "3E#QrMXKZ3qaJb";

    @Test(priority = 1)
    public void validLoginTest() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.openLoginPage();
        login.login(validEmail, validPassword);

        Assert.assertTrue(home.isUserLoggedIn(), "User should be logged in!");

        // Logout عشان نخلي التست اللي بعده يبدأ نظيف
        home.clickLogout();
        Assert.assertFalse(home.isUserLoggedIn(), "User still logged in after logout!");
    }

    @Test(priority = 2)
    public void invalidPasswordTest() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.openLoginPage();
        login.login(validEmail, "wrongPassword");

        Assert.assertTrue(login.isErrorDisplayed(), "Error should appear!");
        Assert.assertTrue(login.getErrorMessage().contains("Login was unsuccessful"),
                "Expected error message not found!");
    }

    @Test(priority = 3)
    public void emptyEmailTest() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.openLoginPage();
        login.login("", "anyPass");

        Assert.assertTrue(login.isErrorDisplayed(), "Error summary should appear!");
    }

    @Test(priority = 4)
    public void emptyPasswordTest() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.openLoginPage();
        login.login(validEmail, "");

        Assert.assertTrue(login.isErrorDisplayed(), "Error summary should appear!");
    }

    @Test(priority = 5)
    public void rememberMeCheckboxTest() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.openLoginPage();
        login.clickRememberMe();

        Assert.assertTrue(login.isRememberMeSelected(), "Remember Me should be selected!");
    }

    @Test(priority = 6)
    public void logoutTest() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.openLoginPage();
        login.login(validEmail, validPassword);

        Assert.assertTrue(home.isUserLoggedIn(), "User should be logged in!");

        home.clickLogout();
        Assert.assertFalse(home.isUserLoggedIn(), "User should be logged out!");
    }
}
