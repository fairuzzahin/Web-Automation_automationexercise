# Automation Exercise - Selenium Automation

A web automation project using **Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM)**.

This project automates the **Login User with Valid Credentials** scenario on [Automation Exercise](https://www.automationexercise.com/).

## Tech Stack

* **Language:** Java 17
* **Automation:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)
* **Reporting:** TestNG & ExtentReports
* **Browsers:** Chrome / Firefox

## Test Scenario

1. Launch Automation Exercise.
2. Navigate to **Signup / Login**.
3. Verify the Login page.
4. Enter the registered email and password.
5. Click **Login**.
6. Verify successful login.
7. Verify **"Logged in as username"**.
8. Capture a screenshot if the test fails.

> **Note:** A user account must be created manually before running the automation, as required by the assignment.

## Project Structure

```text
AutomationExerciseSelenium/
│
├── pom.xml
├── testng.xml
├── README.md
│
├── src/
│   ├── main/java/com/automationexercise/
│   │   ├── base/
│   │   │   └── BaseTest.java
│   │   │
│   │   ├── pages/
│   │   │   ├── HomePage.java
│   │   │   └── LoginPage.java
│   │   │
│   │   └── utilities/
│   │       ├── ConfigReader.java
│   │       ├── DriverFactory.java
│   │       ├── ExtentManager.java
│   │       ├── ScreenshotUtil.java
│   │       └── WaitUtil.java
│   │
│   └── test/
│       ├── java/com/automationexercise/
│       │   ├── listeners/
│       │   │   └── TestListener.java
│       │   │
│       │   └── tests/
│       │       └── LoginTest.java
│       │
│       └── resources/
│           └── config.properties
│
└── test-output/
```

## Configuration

Update your registered credentials in:

```text
src/test/resources/config.properties
```

Example:

```properties
browser=chrome
url=https://www.automationexercise.com/

email=YOUR_REGISTERED_EMAIL
password=YOUR_REGISTERED_PASSWORD

headless=false
implicitWait=5
explicitWait=15
```

**Do not commit real credentials to GitHub.**

## Run the Tests

Clone the repository:

```bash
git clone YOUR_REPOSITORY_URL
cd AutomationExerciseSelenium
```

Run the TestNG suite using Maven:

```bash
mvn clean test
```

Or run `testng.xml` directly from Eclipse/STS:

```text
Right Click testng.xml
→ Run As
→ TestNG Suite
```

## Reports

After execution, reports are generated in:

```text
test-output/
```

Available reports include:

* `ExtentReport.html`
* `index.html`
* `emailable-report.html`
* Failure screenshots

Open the following file to view the detailed Extent Report:

```text
test-output/ExtentReport.html
```

## Framework Features

* Page Object Model (POM)
* Reusable WebDriver management
* Explicit waits
* External configuration
* TestNG assertions
* ExtentReports
* Automatic failure screenshots
* Maven dependency management
* Chrome and Firefox support

## Author

**Fairuz Zahin**

Software Quality Assurance | Test Automation | Selenium | Java

## Application Under Test

[Automation Exercise](https://www.automationexercise.com/)
