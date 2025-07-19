#Author: kunalchavan
#Keyword Summary:
#Feature: List of scenarios.
#Scenarioes: Business rule though list of steps with arguments
#Given: Some precondition step
#When:Some key actions
#Then: To observe outcome or validations
#And, But: To enumerate more Given, When, Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for scenario outline table
#Background: List of steps run before each of the scenarioes
#""" (Doc Strings)
#| (Data tables)
#@ (Tags/labels): To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Purchase the order from E-commerce website
  I want to use this template for my feature file

  Background:
    Given I landed on Ecommerce Page
  @tag2
  Scenario Outline: Positive test of submitting order
    Given Login to the application with username <name> and password <password>
    When I add <product> to the cart
    And Checkout <product> and submit the order <country>
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
    Examples:
      |name             |password   |product      |country  |
      |testkc@gmail.com |Admin@123  |ZARA COAT 3  |India    |

