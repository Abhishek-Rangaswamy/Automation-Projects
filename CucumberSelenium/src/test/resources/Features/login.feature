#Author: Abhishek R
#Email_id: abhi86365@gmail.com
#Date: 27/07/2024
#Description: Opening browser and the launching the Url.

#@SmokeScenario
Feature: Flipkart login feature

  @Smoke
  Scenario Outline: Login Test_scenario
    Given Open the browser <BrowserName>
    When Enter the FlipKart URL <Url>
    Then Login page title is <Title>

    Examples: 
      | BrowserName | Url                       | Title                                                                                                    |
      | Chrome      | https://www.flipkart.com/ | Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers! |
     #| FireFox     | https://www.flipkart.com/ | Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers! |
