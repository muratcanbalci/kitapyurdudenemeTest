Feature: All Scenario
  Scenario: Go to website and test user login
    Given navigate to Website
    And click login button
    And type email
    And type password
    When click on login button
    Then verify success message

  Scenario: Select a book about computer science
    Given Navigate to All Books Tab
    And Click to All Books Tab
    And Click to Bilgisayar
    And Click to List all products
    And Find number of total books
    And Add all books about special word to list and click to tabs according to number
    And Select a random one
    And Find its price
    And If its price under our total money
    And Click to add basket and verify success message
    And Click to my basket button
    And Find to book
    When Click delete button
    Then Control info button