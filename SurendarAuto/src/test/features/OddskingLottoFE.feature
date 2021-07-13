@front-end
Feature: Oddsking Lotto

  Background: Open browser
    Given User is on Irish Lotto page

  Scenario: Successful lotto filtering of results
    When User clicks on Result
    Then User should be able to filter results by date