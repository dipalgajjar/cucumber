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

Feature: LoginPage Feature


  Scenario: Validate Login Page
    Given User lands on login page
    When Enter "<username>"
    When Clear "<password>"
    And Click on Log in button
    Then User should see error message

Examples:
| username      | password |
|dipal@test.com |          |

Scenario: Validate Login Page
    Given User lands on login page
    When Enter "<username>"
    When Clear "<password>"
    When Click on Remember Me
    And Click on Login button
    Then User should see the Home page
    When User Logout
    Then Username should displayed on Login page
   
Examples:
| username     | password |
|dipal@test.com|Diptest@123|

Scenario: Validate Login Page
    Given User lands on login page
    When Enter "<username>"
    When Clear "<password>"
    When Click on Remember Me
    And Click on Login button
    Then User should see the Home page
    When User Logout
    Then Username should displayed on Login page

Examples:
| username     | password |
|dipal@test.com|Diptest@123|
 