# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As a developer i want to test the github api for repos and older users followers.

  Scenario: Is the hello uri available and functioning
    Given url microserviceUrl
    And path '/github/oldusers/nofollowers/1'
    When method GET
    Then status 200
    


	Scenario: Is the hello uri available and functioning
    Given url microserviceUrl
    And path '/github/repos/starred/1'
    When method GET
    Then status 200


