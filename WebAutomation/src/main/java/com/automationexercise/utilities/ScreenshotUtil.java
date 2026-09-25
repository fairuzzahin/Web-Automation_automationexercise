package com.automationexercise.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        try {

            // Create timestamp
            String timestamp = new SimpleDateFormat(
                    "yyyyMMdd_HHmmss"
            ).format(new Date());

            // Screenshot directory
            String directory = "test-output/screenshots/";

            // Create directory if it doesn't exist
            File screenshotDirectory = new File(directory);
            screenshotDirectory.mkdirs();

            // Create screenshot file name
            String filePath = directory
                    + testName
                    + "_"
                    + timestamp
                    + ".png";

            // Take screenshot
            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            // Destination file
            File destination = new File(filePath);

            // Copy screenshot
            FileUtils.copyFile(source, destination);

            // Get absolute path
            String absolutePath = destination.getAbsolutePath();

            // Print success message in console
            System.out.println(
                    "Screenshot captured successfully: "
                            + absolutePath
            );

            return absolutePath;

        } catch (Exception e) {

            System.out.println(
                    "Failed to capture screenshot: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return null;
        }
    }
}