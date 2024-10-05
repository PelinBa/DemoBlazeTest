package pb.pages.product.purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPurchaseForm {

    private final WebDriver webDriver;

    private static final By nameBy = By.id("name");
    private static final By countryBy = By.id("country");
    private static final By cityBy = By.id("city");
    private static final By cardBy = By.id("card");
    private static final By monthBy = By.id("month");
    private static final By yearBy = By.id("year");
    private static final By purchaseButtonBy = By.xpath("//button[.='Purchase']");

    private static final By purchaseSuccessTextBy = By.className("showSweetAlert");
    private static final By purchaseSuccessButtonBy = By.cssSelector(".confirm");

    public ProductPurchaseForm(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getNameElement() {
        return webDriver.findElement(nameBy);
    }

    public void setName(String name) {
        webDriver.findElement(nameBy).sendKeys(name);
    }

    public void setCountry(String country) {
        webDriver.findElement(countryBy).sendKeys(country);
    }

    public void setCity(String city) {
        webDriver.findElement(cityBy).sendKeys(city);
    }

    public void setCard(String card) {
        webDriver.findElement(cardBy).sendKeys(card);
    }

    public void setMonth(String month) {
        webDriver.findElement(monthBy).sendKeys(month);
    }

    public void setYear(String year) {
        webDriver.findElement(yearBy).sendKeys(year);
    }

    public void clickPurchaseButton() {
        webDriver.findElement(purchaseButtonBy).click();
    }

    public String getPurchaseSuccessText() {
        return webDriver.findElement(purchaseSuccessTextBy).getText();
    }

    public void clickPurchaseSuccessButton() {
        webDriver.findElement(purchaseSuccessButtonBy).click();
    }
}
