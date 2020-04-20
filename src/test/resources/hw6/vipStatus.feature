Feature: Give VIP status to User
  Scenario: Log in and give status
    Given I open JDI GitHub site
    And I log in as user Roman Iovlev on the home page
    And I click on Service tab on the Header menu
    And I click on 'User Table' button in Service dropdown
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section