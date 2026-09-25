package com.automationexercise.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportPath =
                    "test-output/ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            // Report title
            sparkReporter.config().setDocumentTitle(
                    "Automation Exercise Test Report"
            );

            // Report name
            sparkReporter.config().setReportName(
                    "Selenium Automation Test Report"
            );

            // Create ExtentReports
            extent = new ExtentReports();

            // Attach Spark Reporter
            extent.attachReporter(sparkReporter);

            // System Information
            extent.setSystemInfo(
                    "Application",
                    "Automation Exercise"
            );

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + Java + TestNG"
            );

            extent.setSystemInfo(
                    "Design Pattern",
                    "Page Object Model"
            );

            extent.setSystemInfo(
                    "Browser",
                    ConfigReader.get("browser")
            );

            extent.setSystemInfo(
                    "Environment",
                    "QA"
            );
        }

        return extent;
    }
}