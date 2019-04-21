package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AddItemSteps {

    MainPage mainPage;
    String search;

    @Given("^user has (.+) page opened$")
    public void user_has_main_page_opened(String pageName) {
        mainPage = PageFactory.initElements(PageDriver.getDriver(), MainPage.class);
        mainPage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.getDriver().get("http://automationpractice.com/index.php");
    }

    @When("^user adds one item$")
    public void user_adds_one_item() {
        mainPage.moveToFirstElem();
        mainPage.clickAddFirst();
        mainPage.clickContinue();
    }

    @Then("^cart should have an item$")
    public void cart_has_one_item() {
        mainPage.clickCartList();
        mainPage.checkItem();
    }

    @When("^user searches for (.+)$")
    public void search_for(String text) {
        search = text;
        mainPage.enterText(text);
        mainPage.clickSearchButton();
    }

    @And("^user adds it$")
    public void add_an_item () {
        mainPage.addItem(search);
        mainPage.clickContinue();
    }

    @Then("^cart should have this item$")
    public void cartShouldHaveThisItem() {
        mainPage.clickCartList();
        mainPage.checkSpecialItem(search);
    }
}
