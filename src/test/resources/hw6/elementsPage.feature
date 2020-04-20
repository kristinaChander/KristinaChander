Feature: Elements selection
  Scenario: Log in and select elements
    Given I open JDI GitHub site
    And I log in as user Roman Iovlev on the home page
    When I click on Service tab on the Header menu
    And I click the link 'Different elements' in Service dropdown
    And I select checkbox Water on the Elements page
    And I select checkbox Wind on the Elements page
    And I select radiobutton Selen on the Elements page
    And I select color Yellow in colors dropdown
    Then A log row should be for each selected value on the log panel
    And value of chosen checkboxes, radiobuttons and dropdowns should correspond to their status on the Elements Page