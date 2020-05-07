package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Saucedemo_Pages {

    public Saucedemo_Pages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='LOGIN']")
    public WebElement loginBtn;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement dropdown;

    @FindBy(xpath = "//div[@class='inventory_item']")
    public List<WebElement> itemList;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> itemNames;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> itemPrice;

    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    public List <WebElement> addButtons;

    @FindBy(xpath = "//div[@class='shopping_cart_container']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> itemNameInTheCart;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> itemPriceInTheCart;

    @FindBy(xpath = "//button[@class='btn_secondary cart_button']")
    public List<WebElement> removeButtons;

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    public WebElement checkOutButton;

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    public WebElement actualResultWithTax;

    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    public WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement completeHeader;


}
