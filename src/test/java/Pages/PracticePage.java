package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage {

    WebDriver driver;
    WebElement goToLoginPage;

    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getGoToLoginPage() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    //----------------------

    public void clickOnGoToLoginPage() {
        getGoToLoginPage().click();
    }

}
