#Author
#Date
#Description
Feature: orangehrm login

  Scenario: Successful login with valid credentails
    Given I launch chrome browser
    When user opens URL "https://opensource-demo.orangehrmlive.com/"
    Then enter username "Admin" and password "admin123"
    Then click an login
    Then verfiy orangehrm dashbord brandbanner
    And close browser
