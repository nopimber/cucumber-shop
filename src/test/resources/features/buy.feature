# Natthanan Sriwichean 6410450931
Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given Prepare Service
    And a product "Bread" with price 20.50 and stock of 5 exists
    And a product "Jam" with price 80.00 and stock of 10 exists
    And a product "Soda" with price 15.00 and stock of 20 exists

Scenario: Buy one product
    When I buy "Bread" with quantity 2
    Then total should be 41.00

Scenario: Buy multiple products
    When I buy "Bread" with quantity 2
    And I buy "Jam" with quantity 1
    Then total should be 121.00

Scenario: Check Stock
    When I buy "Soda" with quantity 5
    Then "Soda" in stock should be 15
