package TestPages;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SecurePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends  BaseTest{
    SoftAssert softAssert = new SoftAssert();
    @Test (priority = 1)
    public void TestLoginSuccessfully(){
        LoginPage loginPage = homePage.LinkClick();
        loginPage.SetUserName("tomsmith");
        loginPage.SetPassword("SuperSecretPassword!");
      SecurePage securePage= loginPage.LoginClick();
      String Message = securePage.getText();
      softAssert.assertTrue(Message.contains("\"You logged into a secure area!\""),"Incorrect Assertion Message");
    }
    @Test (priority = 2)
    public void TestInvalidLogin(){
        LoginPage loginPage = homePage.LinkClick();
        loginPage.SetUserName("tomsmith");
        loginPage.SetPassword("tomsmith");
        SecurePage securePage= loginPage.LoginClick();
        String Message = securePage.getText();
        softAssert.assertFalse(Message.contains("\"You logged into a secure area!\""),"Incorrect Assertion Message");
    }
}
