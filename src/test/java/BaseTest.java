package TestPages;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    private WebDriver driver;
    HomePage homePage;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        homePage= new HomePage(driver);

    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
