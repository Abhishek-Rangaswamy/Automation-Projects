#Author: Abhishek R
#Email_id: abhi86365@gmail.com
#Date: 27/07/2024
#Description: Searching the Products.

Feature: Search the Product

  @Smoke
  Scenario Outline: Product search
    Given I want to search <Pname>
    When "<Pname>" products first page displayed
    And Fetch for the Lowest "<Pname>"
    Then Click on it

    Examples: 
      | Pname             | status  |
      | OnePlus Mobile 5G | success |
     #| Samsung Mobile 5G | success |
  
  @Smoke
  Scenario: Add the product to cart
    Given User is in product details page and add product to cart
    And Verify product in cart 
    Then Close the bowser
