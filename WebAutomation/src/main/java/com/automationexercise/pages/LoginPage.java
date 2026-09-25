package com.automationexercise.pages;

import com.automationexercise.utilities.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final WaitUtil wait;

    private final By loginHeader =
            By.xpath("//h2[contains(text(),'Login to your account')]");

    private final By emailInput =
            By.xpath("//form[@action='/login']//input[@type='email']");

    private final By passwordInput =
            By.xpath("//form[@action='/login']//input[@type='password']");

    private final By loginButton =
            By.xpath("//form[@action='/login']//button[contains(text(),'Login')]");

    private final By loginError =
            By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    public boolean isLoginPageDisplayed() {

        return wait
                .waitForVisibility(loginHeader)
                .isDisplayed();
    }

    public void enterEmail(String email) {

        wait.waitForVisibility(emailInput)
                .clear();

        wait.waitForVisibility(emailInput)
                .sendKeys(email);
    }

    public void enterPassword(String password) {

        wait.waitForVisibility(passwordInput)
                .clear();

        wait.waitForVisibility(passwordInput)
                .sendKeys(password);
    }

    public HomePage clickLogin() {

        wait.waitForClickable(loginButton)
                .click();

        return new HomePage(driver);
    }

    public HomePage login(
            String email,
            String password) {

        enterEmail(email);
        enterPassword(password);

        return clickLogin();
    }

    public boolean isLoginErrorDisplayed() {

        return wait
                .waitForVisibility(loginError)
                .isDisplayed();
    }
}