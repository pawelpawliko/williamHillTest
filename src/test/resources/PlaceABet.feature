@run
Feature: place a bet

Scenario: place a bet on a English Premier League event
Given I am logged-in User
When I navigate to a Premiership football events
And I place a bet of "0.05" for home team to win
Then I should get correct odds and return value for bet "0.05"