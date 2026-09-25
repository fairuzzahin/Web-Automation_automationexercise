package com.automationexercise.basedriver;
import com.automationexercise.utilities.ConfigReader;
import com.automationexercise.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        DriverFactory.initializeDriver();

        driver = DriverFactory.getDriver();

        driver.get(
                ConfigReader.get("url")
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}



