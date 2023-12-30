package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver= driver;
    }
    By LoginPageLink = By.linkText("Form Authentication");

    public LoginPage LinkClick(){
        driver.findElement(LoginPageLink).click();
        return new LoginPage(driver);
    }
}
