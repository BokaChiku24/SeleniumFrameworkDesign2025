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
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Error validation in the Ecommerce
    Given I landed on Ecommerce Page
    When Login to the application with username <name> and password <password>
    Then "Incorrect email or password." message is displayed
    Examples:
      |name                 |password   |
      |testkc3232@gmail.com |Admin@123  |
      |tddfc3232@gmail.com  |Admin24@123  |

