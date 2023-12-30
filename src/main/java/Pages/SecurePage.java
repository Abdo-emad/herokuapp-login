package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {
    private WebDriver driver;

    public SecurePage(WebDriver driver){
        this.driver= driver;
    }
    By passText = By.id("flash");
    public String getText(){
       return driver.findElement(passText).getText();
    }
}
