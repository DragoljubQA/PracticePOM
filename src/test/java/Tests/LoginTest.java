package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.PracticePage;
import Pages.ProfilePage;
import Pages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        sidebarPage = new SidebarPage(driver);
        practicePage = new PracticePage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.manage().window().maximize();
        driver.get(excelReader.getStringData("URL", 0,0));
    }

    public void goToLoginPage() {
        sidebarPage.clickOnPracticeButton();
        practicePage.clickOnGoToLoginPage();
    }

    @Test (priority = 10)
    public void userCanLogIn() {
        goToLoginPage();

        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getMessage().isDisplayed());
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test(priority = 20)
    public void userCanLogOut() {
        goToLoginPage();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        profilePage.clickOnLogoutButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }

    @Test(priority = 30)
    public void userCannotLogInWithInvalidUsername() {
        goToLoginPage();
        loginPage.inputUsername("non-student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
    }

    @Test(priority = 40)
    public void userCannotLogInWithInvalidUsernameAndInvalidPassword() {

        for (int i = 1; i <= excelReader.getLastRow("Login"); i++) {
            goToLoginPage();

            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", i, 3);

            loginPage.inputUsername(invalidUsername);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnSubmitButton();
            wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
            Assert.assertTrue(loginPage.getError().isDisplayed());
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
