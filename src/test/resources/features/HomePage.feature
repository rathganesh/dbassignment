#Validate scenario related to HomePage
Feature: feature to test HomePage functionality

  @smoke
  Scenario: Verify ESPN CricInfo homepage loads successfully
    When User navigate to CricInfo homepage
    Then validate homepage load successfully
    And validate header section
    | Live Scores |
    | Series |
    | Teams |
    | News |
    | Features |
    | Videos |
    | Stats |
    And validate body other sections
    | Match Coverage |
    | Featured |
    | Top Stories |
    | Trending Players |
    | Featured |
    | In Depth |
    | Writers |
    | Key Series |
    | Must Watch |

  @regression
  Scenario: Verify search functionality for invalid data
    Given User navigate to CricInfo homepage
    When user search for "Sumalia"
    Then validate message "No results found for ‘Sumalia’"