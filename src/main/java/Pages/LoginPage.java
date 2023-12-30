package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    public  LoginPage(WebDriver driver){
        this.driver=driver;
    }
    By userName = By.id("username");
    By password = By.id("password");
    By loginBtn = By.className("radius");

    public void SetUserName(String username){
        driver.findElement(userName).sendKeys(username);

    }
    public void SetPassword(String password1){
        driver.findElement(password).sendKeys(password1);

    }
    public SecurePage LoginClick(){
        driver.findElement(loginBtn).click();
        return new SecurePage(driver);

    }
}
