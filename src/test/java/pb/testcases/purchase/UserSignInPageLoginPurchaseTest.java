package pb.testcases.purchase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pb.pages.cart.CartPage;
import pb.pages.home.HomePage;
import pb.pages.login.LoginPage;
import pb.pages.product.ProductPage;
import pb.pages.product.purchase.ProductPurchaseForm;
import pb.pages.signin.SignInPage;

import java.time.Duration;

public class UserSignInPageLoginPurchaseTest {

    private static final String userName = "test-pelin-ba";
    private static final String userPassword = "test-pass";

    private WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    HomePage homePage;
    SignInPage signInPage;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    ProductPurchaseForm productPurchaseForm;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/Users/pelinbasormanci/Downloads/chromedriver-mac-x64/chromedriver");
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(8), Duration.ofSeconds(2));

        // Wait for the sign-up button
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Pages
        homePage = new HomePage(webDriver);
        signInPage = new SignInPage(webDriver);
        loginPage = new LoginPage(webDriver);
        productPage = new ProductPage(webDriver);
        cartPage = new CartPage(webDriver);

        // Purchase form
        productPurchaseForm = new ProductPurchaseForm(webDriver);
    }

    @After
    public void after() {
        webDriver.quit();
        webDriver = null;
        webDriverWait = null;
    }

    @Given("Open main page, register user and check {string} message")
    public void open_main_page_and_register_user(String message) throws InterruptedException {
        // Open the homepage and maximize page
        homePage.openHomePage();
        webDriver.manage().window().maximize();

        // Press the sign-in button and open sign-in page
        homePage.pressToSignInButton();

        // Wait for the name field on the signing page
        webDriverWait.until(ExpectedConditions.visibilityOf(signInPage.getNameFieldElement()));

        // Enter the name and password to the signing page
        signInPage.setUserNameField(userName);
        signInPage.setPasswordField(userPassword);

        // Click the sign-up button
        signInPage.clickSignUpButton();

        //Wait for the success signing message visible
        webDriverWait.until(ExpectedConditions.alertIsPresent());

        //Check the success signing message
        String popupMessage = webDriver.switchTo().alert().getText();
        Assert.assertEquals(message, popupMessage);

        //Accept the signing alert
        webDriver.switchTo().alert().accept();

        // Wait the login button
        Thread.sleep(1000);
    }

    @When("Login user and check the name of user")
    public void login_user_and_check_name_of_user() {
        // Open login page
        homePage.pressToLoginButton();

        // Enter the name and password to the login page
        loginPage.setUserNameField(userName);
        loginPage.setPasswordField(userPassword);

        // Click the login button
        loginPage.clickLoginButton();

        // Wait and check the name of user on the homepage
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(homePage.nameOfUserBy));
        String expectedMessage = "Welcome " + userName;
        Assert.assertEquals(expectedMessage, homePage.getNameOfUserText());
    }

    @And("Go to product, check the product info and add to cart")
    public void go_to_product_check_product_and_add_cart(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        // Go to product
        homePage.openTheSelectedProduct();

        // Wait the product name field on the product page
        webDriverWait.until(ExpectedConditions.visibilityOf(productPage.getProductNameElement()));

        // Get the product details on the product page
        String name = dataTable.cell(0, 1);
        String price = dataTable.cell(1, 1);
        String description = dataTable.cell(2, 1);

        // Check the product details on the product page
        Assert.assertEquals(name, productPage.getProductName());
        Assert.assertEquals(price, productPage.getProductPrice());
        Assert.assertEquals(description, productPage.getProductDescription());

        //Wait the basket button
        Thread.sleep(1000);
        // Add the product to the cart
        productPage.clickAddBasketButton();

        // Wait and accept success adding alert message
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();

        //Wait the cart button
        Thread.sleep(1000);
        // Click the cart button
        productPage.clickCartButtonBy();
    }

    @And("Go to cart page, check the product info and open purchase form")
    public void go_to_cart_page_check_product_info_open_purchase_form(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        //Wait for the product name on the cart page
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.htcNameBy));

        // Compare the product details on the cart page with the details on the product page
        String name = dataTable.cell(0, 1);
        String price = dataTable.cell(1, 1);

        // Check the product details on the cart page
        Assert.assertEquals(name, cartPage.getHtcName());
        Assert.assertEquals(price, cartPage.getHtcPrice());

        //Wait the purchase button
        Thread.sleep(1000);
        // Click the purchase button
        cartPage.clickPurchaseButton();
    }


    @Then("Fill the purchase form and check success message")
    public void fill_the_purchase_form_and_check_success_message(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        // Wait for the name field in the purchase form
        webDriverWait.until(ExpectedConditions.visibilityOf(productPurchaseForm.getNameElement()));

        // Get the user information for the purchase form
        String name = dataTable.cell(0, 1);
        String country = dataTable.cell(1, 1);
        String city = dataTable.cell(2, 1);
        String card = dataTable.cell(3, 1);
        String month = dataTable.cell(4, 1);
        String year = dataTable.cell(5, 1);

        // Write the user information to the purchase form
        productPurchaseForm.setName(name);
        productPurchaseForm.setCountry(country);
        productPurchaseForm.setCity(city);
        productPurchaseForm.setCard(card);
        productPurchaseForm.setMonth(month);
        productPurchaseForm.setYear(year);

        // Click the order button
        productPurchaseForm.clickPurchaseButton();
        Thread.sleep(1000);

        // Get and check the success purchase message
        String successMessageTitle = dataTable.cell(6, 1);
        Assert.assertTrue(productPurchaseForm.getPurchaseSuccessText().contains(successMessageTitle));

        // Click the confirm button on the success purchase message
        Thread.sleep(1000);
        productPurchaseForm.clickPurchaseSuccessButton();
    }
}
