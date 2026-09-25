package com.automationexercise.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private final WebDriverWait wait;

    public WaitUtil(WebDriver driver) {

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        ConfigReader.getInt("explicitWait")
                )
        );
    }

    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public boolean waitForUrlContains(String text) {

        return wait.until(
                ExpectedConditions.urlContains(text)
        );
    }

    public boolean waitForTitleContains(String text) {

        return wait.until(
                ExpectedConditions.titleContains(text)
        );
    }
}