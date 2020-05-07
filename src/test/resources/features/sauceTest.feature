@saucedemo
Feature:Saucedemo.com website E2E testing

  Scenario: Purchasing a product
    Given A user is on Saucedemo home page
    Then A user logs in with "username" and "password"
    Then A user shorts the items
    Then A user adds "Sauce Labs Bike Light" to the shopping cart
    Then A user adds "Sauce Labs Fleece Jacket" to the shopping cart
    Then A user adds "Sauce Labs Onesie" to the shopping cart
    Then A user checks the shopping cart for the items if they are the chosen
    Then A user removes "Sauce Labs Bike Light" from the cart
    Then A user adds "Sauce Labs Bolt T-Shirt" item to the shopping cart
    And A user checks out by entering "name" , "lastName", "zipCode"
    Then A user checks total price and items










