package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {

        // 1) تقرير جديد لكل Run بتوقيت مختلف
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String reportPath = "target/ExtentReport_" + timeStamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

        // 2) إعدادات شكل احترافية جاهزة
        spark.config().setDocumentTitle("Demo Web Shop | Automation Report");
        spark.config().setReportName("Full Regression Suite");
        spark.config().setTheme(Theme.DARK);
        spark.config().setTimeStampFormat("MMM dd, yyyy hh:mm:ss a");

        // 3) ربط CSS خارجي (مرن: يدور في test/resources ثم main/resources)
        attachCustomCssIfExists(spark);

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(spark);

        // 4) System/Environment info
        extentReports.setSystemInfo("Project", "Demo Web Shop Automation");
        extentReports.setSystemInfo("Tester", "Ziad Mohamed");
        extentReports.setSystemInfo("Email", "mohammedziad118@gmail.com");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("Execution Time", timeStamp);

        return extentReports;
    }

    private static void attachCustomCssIfExists(ExtentSparkReporter spark) {
        // المسارات المحتملة
        String[] possiblePaths = {
                "src/test/resources/extent-custom.css",
                "src/main/resources/extent-custom.css"
        };

        for (String path : possiblePaths) {
            File css = new File(path);
            if (css.exists()) {
                spark.config().setCss(css.getAbsolutePath());
                System.out.println("[ExtentManager] Custom CSS loaded: " + css.getAbsolutePath());
                return;
            }
        }

        System.out.println("[ExtentManager] CSS file not found in test/resources or main/resources.");
    }
}
