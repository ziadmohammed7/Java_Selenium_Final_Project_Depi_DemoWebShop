package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.*;

public class ExtentListener implements ITestListener, ISuiteListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onStart(ISuite suite) {
        extent = ExtentManager.getExtent();
        System.out.println("[ExtentListener] Suite Started: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        if (extent != null) {
            extent.flush();
            System.out.println("[ExtentListener] Suite Finished & Report Generated.");
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        ExtentTest test = extent.createTest(testName)
                .assignCategory(result.getTestClass().getName())
                .assignAuthor("Ziad Mohamed");

        testThread.set(test);

        test.info("Test Started...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().pass("Test Passed Successfully ✅");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = testThread.get();

        test.fail("Test Failed ❌");
        test.fail(result.getThrowable()); // يكتب السبب كامل Stacktrace

        // لو عايز وقت الفشل وغيره
        test.info("Failure Time: " + new java.util.Date());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().skip("Test Skipped ⚠️");
        if (result.getThrowable() != null) {
            testThread.get().skip(result.getThrowable());
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        testThread.get().warning("Test partially failed but within success percentage.");
    }
}
