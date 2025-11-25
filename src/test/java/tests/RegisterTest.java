package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    // غير الإيميل ده كل فترة أو خليه دايمًا جديد
    String newEmail = "newuser35684@gmail.com";
    String existingEmail = "mohammedziad@gmail.com";  // ده اللي عامل بيه لوجين

    @Test(priority = 1)
    public void validRegistrationTest() {
        HomePage home = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        // إيميل مختلف في كل تشغيل للتست
        String newEmail = "newuser" + System.currentTimeMillis() + "@gmail.com";
        System.out.println("Registering with email: " + newEmail);

        home.openHomePage();
        home.openRegisterPage();

        registerPage.register("Mohammed", "Ziad", newEmail, "123456", "123456");

        Assert.assertTrue(registerPage.isRegistrationSuccessMessageDisplayed(),
                "Registration success message not displayed!");
    }


    @Test(priority = 2)
    public void registrationWithExistingEmailShowsError() {
        HomePage home = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        home.openHomePage();
        home.openRegisterPage();

        registerPage.register("Mohammed", "Ziad", existingEmail, "123456", "123456");

        Assert.assertTrue(registerPage.isErrorDisplayed(), "Error message not displayed!");
        Assert.assertTrue(registerPage.getErrorMessage().contains("The specified email already exists"),
                "Expected 'email already exists' message not found!");
    }

    @Test(priority = 3)
    public void registrationWithEmptyFieldsShowsError() {
        HomePage home = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        home.openHomePage();
        home.openRegisterPage();

        // دوس Register من غير ما تملى حاجة
        registerPage.clickRegisterButton();

        Assert.assertTrue(registerPage.areFieldErrorsDisplayed(),
                "Field error messages should be displayed when fields are empty!");
    }

}
