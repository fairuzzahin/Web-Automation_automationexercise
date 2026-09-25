package com.automationexercise.tests;

import com.automationexercise.basedriver.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(
            description = "Verify user can login with valid credentials",
            priority = 1
    )
    public void verifyValidUserLogin() {

        // Step 1:
        // Navigate to Login page

        HomePage homePage =
                new HomePage(driver);

        LoginPage loginPage =
                homePage.clickSignupLogin();

        // Step 2:
        // Verify Login page

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page was not displayed."
        );

        // Step 3:
        // Get registered credentials

        String email =
                ConfigReader.get("email");

        String password =
                ConfigReader.get("password");

        // Step 4:
        // Login

        HomePage loggedInHomePage =
                loginPage.login(
                        email,
                        password
                );

        // Step 5:
        // Verify successful login

        Assert.assertTrue(
                loggedInHomePage.isLoggedIn(),
                "User was not logged in successfully."
        );

        // Step 6:
        // Verify username text

        String loggedInText =
                loggedInHomePage
                        .getLoggedInUserText();

        Assert.assertTrue(
                loggedInText.contains("Logged in as"),
                "Expected 'Logged in as' text was not displayed."
        );

        System.out.println(
                "Login successful: "
                + loggedInText
        );
    }
}