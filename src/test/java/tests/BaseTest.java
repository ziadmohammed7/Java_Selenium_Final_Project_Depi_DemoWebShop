package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void openBrowserOnce() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ⬅️ هنا ظبطنا التايم
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   // يستنى لحد 5 ثواني على أي عنصر
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40)); // يستنى تحميل الصفحة نفسها

        driver.get("https://demowebshop.tricentis.com/");
    }

    @BeforeMethod
    public void goHomeBeforeEachTest() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterMethod
    public void resetAfterEachTest() {
        // لو اليوزر داخل بالفعل → اعمل Logout عشان التست اللي بعده يبدأ نضيف
        if (driver.findElements(By.className("ico-logout")).size() > 0) {
            driver.findElement(By.className("ico-logout")).click();
        }
    }

    @AfterSuite
    public void closeBrowserAtEnd() {
        if (driver != null) {
            driver.quit();
        }
    }
}
