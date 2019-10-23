

Feature: As a user I want to login so that can enjoy account facility

  Background:
  Given User is on login page

  @login
  Scenario Outline:  User should be logged in successfully and navigate to Homepage so can access functionality

    When User enter Username as "<username>" and Password as "<password>"
    Then user should be logged in successfully
    Examples:
      | username | password |
      | Admin    | admin123 |
      | admin    | Admin124 |
      | Admin    | Admin124 |
      | admin123 | admin123 |
      | Admin    |          |
      |          | admin123 |
      | admin    |          |
      |          | Admin124 |



