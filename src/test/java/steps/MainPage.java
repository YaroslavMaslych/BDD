package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    Actions actions;
    private WebDriver driver;
    @FindBy(xpath = "//input[contains(@id,'search_query_top')]")
    private WebElement searchField;
    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement searchButton;
    @FindBy(xpath = "//b[contains(.,'Cart')]")
    private WebElement cartList;
    @FindBy(xpath = "(//img[@itemprop='image'])[1]")
    private WebElement firstItem;
    @FindBy(xpath = "(//span[contains(.,'Add to cart')])[1]")
    private WebElement firstItemAddToCartButton;
    @FindBy(xpath = "(//img[@itemprop='image'])[2]")
    private WebElement secondItem;
    @FindBy(xpath = "(//span[contains(.,'Add to cart')])[2]")
    private WebElement secondItemAddToCartButton;
    @FindBy(xpath = "//span[contains(.,'Proceed to checkout')]")
    private WebElement continueShoppingButton;
    @FindBy(xpath = "(//a[contains(.,'Faded Short Sleeve T-shirts')])[2]")
    private WebElement cartItem;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public MainPage enterText(String text) {
        searchField.sendKeys(text);
        return this;
    }

    public MainPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public MainPage clickCartList() {
        cartList.click();
        return this;
    }

    public MainPage clickFirst() {
        firstItem.click();
        return this;
    }

    public MainPage clickSecond() {
        secondItem.click();
        return this;
    }

    public MainPage clickAddFirst() {
        firstItemAddToCartButton.click();
        return this;
    }

    public MainPage clickAddSecond() {
        secondItemAddToCartButton.click();
        return this;
    }

    public MainPage quit() {
        driver.quit();
        return this;
    }

    public MainPage clickContinue() {
        continueShoppingButton.click();
        return this;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public MainPage moveToFirstElem() {
        actions.moveToElement(firstItem);
        return this;
    }

    public MainPage moveToSecondElem() {
        actions.moveToElement(secondItem);
        return this;
    }

    public MainPage checkItem() {
        Assert.assertTrue(cartItem.isDisplayed());
        driver.quit();
        return this;
    }

    public MainPage addItem(String text) {
        actions.moveToElement(driver.findElement(By.xpath("//img[@title='"+text+"']")));
        driver.findElement(By.xpath("//span[contains(.,'Add to cart')]")).click();
        return this;
    }

    public MainPage checkSpecialItem(String text) {
        Assert.assertTrue(driver.findElement(By.xpath("//td//a[contains(text(),'"+text+"')]")).isDisplayed());
        driver.quit();
        return this;
    }
}
