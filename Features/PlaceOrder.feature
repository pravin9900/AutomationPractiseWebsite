#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Shopping
Feature: Buy the product from automation practise Url
  I want to place the order and get the order confirmation ID and store in excel sheet

  Background: 
    Given open chrome driver browser and launch the automation practise url

  @order
  Scenario: place the order and store order confirmation ID in excel workbook
    When I clicked on signin button
    And I entered Login credentials and clicked on login button
    And I entered productName in search box and clicked on search button
    And I added product to the cart
    And I Checked out the product
    And I completed the payment
    Then I stored the order conformation ID into excel workbook
    And I clicked on sign out button
