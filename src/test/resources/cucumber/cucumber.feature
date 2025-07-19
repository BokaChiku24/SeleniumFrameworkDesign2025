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
Feature: Title of your feature
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario
    Given I want to write step with <name>
    When I check for the <value> in the step
    Then I verify the <status> in step
    Examples:
      | name |value|status|
      |kunal | 24  |true  |

