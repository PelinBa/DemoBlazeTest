package pb.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver webDriver;

    private static final By loginUserNameBy = By.id("loginusername");
    private static final By loginPasswordBy = By.id("loginpassword");
    private static final By loginButtonBy = By.xpath("//button[.='Log in']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setUserNameField(String userName) {
        webDriver.findElement(loginUserNameBy).sendKeys(userName);
    }

    public void setPasswordField(String password) {
        webDriver.findElement(loginPasswordBy).sendKeys(password);
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButtonBy).click();
    }
}
