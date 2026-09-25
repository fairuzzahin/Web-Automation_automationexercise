package com.automationexercise.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initializeDriver() {

        String browser = ConfigReader.get("browser");

        boolean headless =
                ConfigReader.getBoolean("headless");

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions chromeOptions =
                        new ChromeOptions();

                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }

                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");

                webDriver =
                        new ChromeDriver(chromeOptions);

                break;

            case "firefox":

                FirefoxOptions firefoxOptions =
                        new FirefoxOptions();

                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }

                webDriver =
                        new FirefoxDriver(firefoxOptions);

                break;

            default:

                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        driver.set(webDriver);

        getDriver().manage()
                .timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(
                                ConfigReader.getInt("implicitWait")
                        )
                );

        getDriver().manage()
                .window()
                .maximize();
    }

    public static WebDriver getDriver() {

        if (driver.get() == null) {

            throw new IllegalStateException(
                    "WebDriver has not been initialized."
            );
        }

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();
            driver.remove();
        }
    }
}
