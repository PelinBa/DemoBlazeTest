package pb.pages.signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private final WebDriver webDriver;

    private static final By signUserNameBy = By.id("sign-username");
    private static final By signPasswordBy = By.id("sign-password");
    private static final By signUpButtonBy = By.xpath("//button[.='Sign up']");

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getNameFieldElement() {
        return webDriver.findElement(signUserNameBy);
    }

    public void setUserNameField(String userName) {
        webDriver.findElement(signUserNameBy).sendKeys(userName);
    }

    public void setPasswordField(String password) {
        webDriver.findElement(signPasswordBy).sendKeys(password);
    }

    public void clickSignUpButton() {
        webDriver.findElement(signUpButtonBy).click();
    }
}
