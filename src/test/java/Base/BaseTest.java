package Base;

import Pages.LoginPage;
import Pages.PracticePage;
import Pages.ProfilePage;
import Pages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public SidebarPage sidebarPage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        //excelReader = new ExcelReader("C:\\Users\\drago\\Desktop\\TestData.xlsx");
        excelReader = new ExcelReader("TestData.xlsx");
    }


}
