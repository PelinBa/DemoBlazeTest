package pb.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private static final String homePageUrl = "https://www.demoblaze.com";

    private final WebDriver webDriver;

    private static final By signingButtonBy = By.id("signin2");
    private static final By loginButtonBy = By.id("login2");
    public static final By nameOfUserBy = By.id("nameofuser");
    private static final By selectedProductBy = By.xpath("//a[@href = 'prod.html?idp_=7']");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openHomePage() {
        webDriver.get(homePageUrl);
    }

    public void pressToSignInButton() {
        webDriver.findElement(signingButtonBy).click();
    }

    public void pressToLoginButton() {
        webDriver.findElement(loginButtonBy).click();
    }

    public void openTheSelectedProduct() {
        webDriver.findElement(selectedProductBy).click();
    }

    public String getNameOfUserText() {
        return webDriver.findElement(nameOfUserBy).getText();
    }
}
