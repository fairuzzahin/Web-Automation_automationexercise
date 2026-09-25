package com.automationexercise.listeners;

import com.automationexercise.utilities.DriverFactory;
import com.automationexercise.utilities.ExtentManager;
import com.automationexercise.utilities.ScreenshotUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getInstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();


    // ==========================================
    // Test Suite Started
    // ==========================================
    @Override
    public void onStart(ITestContext context) {

        System.out.println(
                "Test Suite Started: "
                        + context.getName()
        );
    }


    // ==========================================
    // Test Started
    // ==========================================
    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod().getMethodName()
                );

        test.set(extentTest);

        System.out.println(
                "Test Started: "
                        + result.getMethod().getMethodName()
        );
    }


    // ==========================================
    // Test Passed
    // ==========================================
    @Override
    public void onTestSuccess(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        test.get().pass(
                "Test Passed Successfully"
        );

        System.out.println(
                "Test Passed Successfully: "
                        + testName
        );

        try {

            String screenshot =
                    ScreenshotUtil.captureScreenshot(
                            DriverFactory.getDriver(),
                            testName
                    );

            if (screenshot != null) {

                test.get().addScreenCaptureFromPath(
                        screenshot
                );

                System.out.println(
                        "Success screenshot attached to Extent Report."
                );
            }

        } catch (Exception e) {

            test.get().warning(
                    "Unable to attach success screenshot: "
                            + e.getMessage()
            );
        }
    }


    // ==========================================
    // Test Failed
    // ==========================================
    @Override
    public void onTestFailure(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        test.get().fail(
                result.getThrowable()
        );

        System.out.println(
                "Test Failed: "
                        + testName
        );

        try {

            String screenshot =
                    ScreenshotUtil.captureScreenshot(
                            DriverFactory.getDriver(),
                            testName
                    );

            if (screenshot != null) {

                test.get().addScreenCaptureFromPath(
                        screenshot
                );

                System.out.println(
                        "Failure screenshot attached to Extent Report."
                );
            }

        } catch (Exception e) {

            test.get().warning(
                    "Unable to attach failure screenshot: "
                            + e.getMessage()
            );
        }
    }


    // ==========================================
    // Test Skipped
    // ==========================================
    @Override
    public void onTestSkipped(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        test.get().skip(
                "Test Skipped"
        );

        System.out.println(
                "Test Skipped: "
                        + testName
        );
    }


    // ==========================================
    // Test Failed But Within Success Percentage
    // ==========================================
    @Override
    public void onTestFailedButWithinSuccessPercentage(
            ITestResult result) {

        test.get().warning(
                "Test Failed But Within Success Percentage"
        );
    }


    // ==========================================
    // Test Suite Finished
    // ==========================================
    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println(
                "Test Suite Finished: "
                        + context.getName()
        );
    }
}