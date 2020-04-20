Feature: log in
  Scenario: Log in on the home page
    Given I open JDI GitHub site
    And I log in as user Roman Iovlev on the home page
    Then browser title should be 'Home Page' on the home page
    And logged in user name  should be 'ROMAN IOVLEV' on the header
