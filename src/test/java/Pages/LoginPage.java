package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    //-------------------------------

    public void inputUsername() {
        getUsernameField().clear();
        getUsernameField().sendKeys("student");
    }

    public void inputPassword() {
        getPasswordField().clear();
        getPasswordField().sendKeys("Password123");
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }

}
