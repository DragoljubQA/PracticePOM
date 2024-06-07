package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }

    @Test
    public void userCanLogIn() {
        sidebarPage.clickOnPracticeButton();
        practicePage.clickOnGoToLoginPage();
    }

}
