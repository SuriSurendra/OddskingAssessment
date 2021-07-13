@front-end
Feature: Oddsking Registration

  Background: Open browser
    Given User is on Oddsking homepage

  Scenario: User registration successful
    When I click on Join button
    And I enter email address "surendharsuri@gmail.com" on registration page
    And I enter username "surendharsuri" on registration page
    And I enter password "Password123" on registration page
    And I click on Terms and Conditions checkbox
    And I click Continue

    And I enter first name "Surendhar" on registration page
    And I enter last name "Suri" on registration page
    And I enter day "01" month "01" year "1990" as date of birth on registration page
    And I click Continue

    And I enter phone number "07777777777" on registration page
    And I select a security question "Mothers Maiden Name" on registration page
    And I enter an answer "Test" on registration page
    And I click on Continue

    And I enter address or postcode "M11 3NP"
    And I click on Continue

    And I click on email checkbox
    And I click Continue
    Then I should see a message for successful registration

  Scenario: Successful lotto filtering of results
    Given User is on Irish Lotto page
    When User clicks on Result
    Then User should be able to filter results by date

