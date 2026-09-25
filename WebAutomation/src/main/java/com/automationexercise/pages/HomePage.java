package com.automationexercise.pages;

import com.automationexercise.utilities.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    private final WaitUtil wait;

    private final By signupLoginLink =
            By.xpath("//a[contains(.,'Signup / Login')]");

    private final By loggedInUser =
            By.xpath("//a[contains(.,'Logged in as')]");

    private final By logoutLink =
            By.xpath("//a[contains(.,'Logout')]");

    private final By deleteAccountLink =
            By.xpath("//a[contains(.,'Delete Account')]");

    public HomePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtil(driver);
    }

    public LoginPage clickSignupLogin() {

        wait.waitForClickable(signupLoginLink).click();

        return new LoginPage(driver);
    }

    public boolean isLoggedIn() {

        return wait
                .waitForVisibility(loggedInUser)
                .isDisplayed();
    }

    public String getLoggedInUserText() {

        return wait
                .waitForVisibility(loggedInUser)
                .getText();
    }

    public void logout() {

        wait.waitForClickable(logoutLink).click();
    }

    public void deleteAccount() {

        wait.waitForClickable(deleteAccountLink).click();
    }
}
