package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Saucedemo_Pages;
import utilities.Config;
import utilities.Driver;
import utilities.UiHelper;

import java.util.ArrayList;
import java.util.List;

public class Saucedemo_Steps {

    Saucedemo_Pages saucedemo = new Saucedemo_Pages();
    List<String> chosenItemName = new ArrayList<>();
    List<Double> chosenItemPrice = new ArrayList<>();
    double expectedTotalPrice;
    double actualTotalPrice;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @Given("A user is on Saucedemo home page")
    public void a_user_is_on_Saucedemo_home_page() {
        Driver.getDriver().get(Config.getProperty("URL"));

    }

    @Then("A user logs in with {string} and {string}")
    public void a_user_logs_in_with_and(String username, String password) {
        username = Config.getProperty("userName");
        saucedemo.username.sendKeys(username);
        password = Config.getProperty("password");
        saucedemo.password.sendKeys(password);
        saucedemo.loginBtn.click();


    }

    @Then("A user shorts the items")
    public void a_user_shorts_the_items() {
        Select selectBox = new Select(saucedemo.dropdown);
        selectBox.selectByIndex(0);

    }

    @Then("A user adds {string} to the shopping cart")
    public void aUserAddsToTheShoppingCart(String product) {
        UiHelper.addToCart(product);
        chosenItemName.add(product);
        chosenItemPrice.add(Double.valueOf(UiHelper.getPriceOf(product).substring(1)));
        System.out.println("Price: " + UiHelper.getPriceOf(product));

    }

    @Then("A user checks the shopping cart for the items if they are the chosen")
    public void a_user_checks_the_shopping_cart_for_the_items_if_they_are_the_chosen() {

        saucedemo.shoppingCart.click();
        Assert.assertEquals(chosenItemPrice.get(0), Double.valueOf(saucedemo.itemPriceInTheCart.get(0).getText()));
        Assert.assertEquals(chosenItemPrice.get(1), Double.valueOf(saucedemo.itemPriceInTheCart.get(1).getText()));
        Assert.assertEquals(chosenItemPrice.get(2), Double.valueOf(saucedemo.itemPriceInTheCart.get(2).getText()));

        Assert.assertEquals(chosenItemName.get(0), saucedemo.itemNameInTheCart.get(0).getText());
        Assert.assertEquals(chosenItemName.get(1), saucedemo.itemNameInTheCart.get(1).getText());
        Assert.assertEquals(chosenItemName.get(2), saucedemo.itemNameInTheCart.get(2).getText());

    }

    @Then("A user removes {string} from the cart")
    public void aUserRemovesFromTheCart(String product) {
        chosenItemPrice.remove(Double.valueOf(UiHelper.getPriceOf(product)));
        chosenItemName.remove(product);
        UiHelper.removeFromCart(product);
        Driver.getDriver().navigate().back();
    }

    @Then("A user adds {string} item to the shopping cart")
    public void aUserAddsItemToTheShoppingCart(String product) {
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + product + "']")));
        UiHelper.addToCart(product);
        chosenItemName.add(product);
        chosenItemPrice.add(Double.valueOf(UiHelper.getPriceOf(product).substring(1)));

    }

    @Then("A user checks out by entering {string} , {string}, {string}")
    public void a_user_finishes_the_checkout_by_entering(String name, String lastName, String zipCode) {


        saucedemo.shoppingCart.click();
        saucedemo.checkOutButton.click();
        name = Config.getProperty("name");
        lastName = Config.getProperty("lastName");
        zipCode = Config.getProperty("zipCode");

        saucedemo.firstName.sendKeys(name);
        saucedemo.lastName.sendKeys(lastName);
        saucedemo.zipCode.sendKeys(zipCode);
        saucedemo.continueButton.click();


    }

    @Then("A user checks total price and items")
    public void a_user_checks_total_price_and_items() {


        for (int i = 0; i < chosenItemPrice.size(); i++) {
            System.out.println("Price: 1. loop " + chosenItemPrice.get(i));
            expectedTotalPrice += chosenItemPrice.get(i);
        }

        for (int i = 0; i < saucedemo.itemPriceInTheCart.size(); i++) {
            System.out.println("Price: 2. loop " + saucedemo.itemPriceInTheCart.get(i).getText().substring(1));
            actualTotalPrice += Double.valueOf(saucedemo.itemPriceInTheCart.get(i).getText().substring(1));
        }

        Assert.assertEquals(expectedTotalPrice, actualTotalPrice, 0.001);

        Assert.assertEquals(chosenItemPrice.get(0), Double.valueOf(saucedemo.itemPriceInTheCart.get(0).getText().substring(1)));
        Assert.assertEquals(chosenItemPrice.get(1), Double.valueOf(saucedemo.itemPriceInTheCart.get(1).getText().substring(1)));
        Assert.assertEquals(chosenItemPrice.get(2), Double.valueOf(saucedemo.itemPriceInTheCart.get(2).getText().substring(1)));

        Assert.assertEquals(chosenItemName.get(0), saucedemo.itemNameInTheCart.get(0).getText());
        Assert.assertEquals(chosenItemName.get(1), saucedemo.itemNameInTheCart.get(1).getText());
        Assert.assertEquals(chosenItemName.get(2), saucedemo.itemNameInTheCart.get(2).getText());

        double taxRate = 0.08;
        double expectedTaxResult = taxRate * expectedTotalPrice;
        Double expectedTotalWithTax = expectedTaxResult + actualTotalPrice;

        Assert.assertEquals(expectedTotalWithTax,Double.valueOf(saucedemo.actualResultWithTax.getText().
                substring(8)),0.01);

        saucedemo.finishButton.click();
        Assert.assertTrue(saucedemo.completeHeader.isDisplayed());

    }



}




