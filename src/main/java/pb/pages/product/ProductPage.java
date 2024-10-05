package pb.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private final WebDriver webDriver;

    private static final By productNameBy = By.className("name");
    private static final By productPriceBy = By.className("price-container");
    private static final By productDescriptionBy = By.xpath("//div[@id='more-information']/p[1]");
    private static final By productAddBasketButtonBy = By.cssSelector(".btn-success");
    private static final By openCartButtonBy = By.id("cartur");

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getProductNameElement() {
        return webDriver.findElement(productNameBy);
    }

    public String getProductName() {
        return getProductNameElement().getText();
    }

    public String getProductPrice() {
        return webDriver.findElement(productPriceBy).getText();
    }

    public String getProductDescription() {
        return webDriver.findElement(productDescriptionBy).getText();
    }

    public void clickAddBasketButton() {
        webDriver.findElement(productAddBasketButtonBy).click();
    }

    public void clickCartButtonBy() {
        webDriver.findElement(openCartButtonBy).click();
    }
}
