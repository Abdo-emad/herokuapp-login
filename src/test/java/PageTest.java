import Pages.HomePage;
import Pages.LoginPage;
import Pages.SecurePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class PageTest {
    private WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SecurePage securePage;
    SoftAssert softAssert;

@BeforeTest
    public void InitiateBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

    }
    @Test
    public void CheckLoginScript(){
        homePage = new HomePage(driver);
        homePage.LinkClick();
        loginPage= new LoginPage(driver);
        loginPage.SetUserName("tomsmith");
        loginPage.SetPassword("SuperSecretPassword!");
        loginPage.LoginClick();
        securePage = new SecurePage(driver);
        String Msg = securePage.getText();
        softAssert = new SoftAssert();
        softAssert.assertTrue(Msg.contains("You logged into a secure area!"));
        softAssert.assertAll();

    }

 @AfterTest
    public void CloseBrowser(){
        driver.quit();
 }
}
