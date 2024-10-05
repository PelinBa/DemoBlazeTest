package pb.pages.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver webDriver;

    public static final By htcNameBy = By.xpath("//td[.='HTC One M9']");
    private static final By htcPriceBy = By.xpath("//td[.='700']");
    private static final By purchaseButtonBy = By.cssSelector(".btn-success");

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getHtcName() {
        return webDriver.findElement(htcNameBy).getText();
    }

    public String getHtcPrice() {
        return webDriver.findElement(htcPriceBy).getText();
    }

    public void clickPurchaseButton() {
        webDriver.findElement(purchaseButtonBy).click();
    }
}
