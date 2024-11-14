#Validate scenario related to HomePage
Feature: feature to test HomePage functionality

  @smoke
  Scenario: Verify ESPN CricInfo homepage loads successfully
    When User navigate to CricInfo homepage
    Then validate homepage load successfully