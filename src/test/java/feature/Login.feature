
Feature: Application Login 
  Scenario: Login with valid credentials
    Given Open the bowser
    And Navigate to login page 
    When User enters username and Password 
    |sujal@gmail.com|sujal@12345|
   And click on login button
    Then user should be able to successfully login 


