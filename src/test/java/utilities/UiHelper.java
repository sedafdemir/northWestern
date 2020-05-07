package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UiHelper {

    public static void addToCart(String product){
        String element = "//div[text()='" + product + "']/../../..//button[text()='ADD TO CART']";
        Driver.getDriver().findElement(By.xpath(element)).click();
    }

    public static void removeFromCart(String product){
        String element = "//div[text()='" + product + "']/../../..//button[text()='REMOVE']";
        Driver.getDriver().findElement(By.xpath(element)).click();
    }

    public static String getPriceOf(String product){
        String element = "//div[text()='" + product + "']/../../..//div[@class='inventory_item_price']";
        return Driver.getDriver().findElement(By.xpath(element)).getText();
    }

}
