package Base;

import Pages.LoginPage;
import Pages.PracticePage;
import Pages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public SidebarPage sidebarPage;
    public PracticePage practicePage;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sidebarPage = new SidebarPage(driver);
        practicePage = new PracticePage(driver);
        loginPage = new LoginPage(driver);
    }



}
