Feature: User Table
  Scenario: User Table Page test
    Given I open JDI GitHub site
    And I log in as user Roman Iovlev on the home page
    When I click on Service tab on the Header menu
    And I click on 'User Table' button in Service dropdown
    Then 'User Table' page should be opened
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 User names should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table should contain following values:
    |Number|User|Description|
    |1|Roman|Wolverine|
    |2|Sergey Ivan|Spider Man|
    |3|Vladzimir|Punisher|
    |4|Helen Bennett|Captain America\nsome description|
    |5|Yoshi Tannamuri|Cyclope\nsome description|
    |6|Giovanni Rovelli|Hulk\nsome description|
    And droplist should contain values in column Type for user Roman
    |Dropdown Values|
    |Admin|
    |User|
    |Manager|
