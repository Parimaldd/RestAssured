package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;

    // Executes before suite starts
    @Override
    public void onStart(ITestContext context) {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                .format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

        // Report Configuration
        sparkReporter.config().setDocumentTitle("RestAssured Automation Project");
        sparkReporter.config().setReportName("Pet Store Users API Automation");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // System & Suite Details
        extent.setSystemInfo("Application", "Pet Store Users API");
        extent.setSystemInfo("Module", "API Automation");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Suite Name", context.getSuite().getName());
        extent.setSystemInfo("Tester", "Parimal");

        System.out.println("===== Test Suite Started =====");
        System.out.println("Suite Name: " + context.getName());
        System.out.println("Start Time: " + new Date(context.getStartDate().getTime()));
    }

    // Executes when each test method starts
    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());

        test.info("Test Method Started: " + result.getName());
        test.info("Test Class: " + result.getTestClass().getName());
        test.info("Test Description: " + result.getMethod().getDescription());
        test.info("Start Time: " + new Date(result.getStartMillis()));
        test.info("Thread ID: " + Thread.currentThread().getId());

        System.out.println("Test Started: " + result.getName());
    }

    // When test passes
    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test PASSED");
        test.pass("Test Method: " + result.getName());
        test.pass("Test Class: " + result.getTestClass().getName());
        test.pass("Execution Time: " 
                + (result.getEndMillis() - result.getStartMillis()) + " ms");
        test.pass("Status Code: SUCCESS");

        System.out.println("Test Passed: " + result.getName());
    }

    // When test fails (Most important for API projects)
    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test FAILED");
        test.fail("Test Method: " + result.getName());
        test.fail("Test Class: " + result.getTestClass().getName());
        test.fail("Failure Reason: " + result.getThrowable());
        test.fail("Execution Time: " 
                + (result.getEndMillis() - result.getStartMillis()) + " ms");
        test.fail("End Time: " + new Date(result.getEndMillis()));

        // Stack trace (very useful in debugging)
        String stackTrace = result.getThrowable().toString();
        test.fail("Exception Details: " + stackTrace);

        System.out.println("Test Failed: " + result.getName());
        System.out.println("Reason: " + result.getThrowable());
    }

    // When test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test SKIPPED");
        test.skip("Test Method: " + result.getName());
        test.skip("Test Class: " + result.getTestClass().getName());
        test.skip("Skip Reason: " + result.getThrowable());
        test.skip("Skipped Time: " + new Date(result.getEndMillis()));

        System.out.println("Test Skipped: " + result.getName());
    }

    // Rare case but good for completeness
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        test.warning("Test Failed But Within Success Percentage");
        test.warning("Test Method: " + result.getName());
        test.warning("Success Percentage: " 
                + result.getMethod().getSuccessPercentage());

        System.out.println("Partial Failure: " + result.getName());
    }

    // Timeout specific logging (important for API timeouts)
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

        test.fail("Test FAILED due to TIMEOUT");
        test.fail("Test Method: " + result.getName());
        test.fail("Class Name: " + result.getTestClass().getName());
        test.fail("Execution Time: " 
                + (result.getEndMillis() - result.getStartMillis()) + " ms");

        System.out.println("Test Failed Due To Timeout: " + result.getName());
    }

    // Executes after suite finishes (MANDATORY for report generation)
    @Override
    public void onFinish(ITestContext context) {

        test.info("===== Test Suite Execution Finished =====");
        test.info("Total Tests Passed: " + context.getPassedTests().size());
        test.info("Total Tests Failed: " + context.getFailedTests().size());
        test.info("Total Tests Skipped: " + context.getSkippedTests().size());
        test.info("End Time: " + new Date(context.getEndDate().getTime()));

        extent.flush(); // Generates the final report file

        System.out.println("===== Test Suite Finished =====");
        System.out.println("Passed Tests: " + context.getPassedTests().size());
        System.out.println("Failed Tests: " + context.getFailedTests().size());
        System.out.println("Skipped Tests: " + context.getSkippedTests().size());
    }
}