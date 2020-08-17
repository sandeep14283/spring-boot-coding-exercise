# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As a developer i want to test the github api for repos and older users followers.

  Scenario: Is the hello uri available and functioning
    Given url microserviceUrl
    And path '/github/oldusers/nofollowers/1'
    When method GET
    Then status 200
    	And match header Content-Type contains 'application/json'
			And match $ == [{id : '#string',login : '#string',html_url : '#string'}]
			
	Scenario: Is the hello uri available and functioning
    Given url microserviceUrl
    And path '/github/oldusers/nofollowers/0'
    When method GET
    Then status 404
    	And match header Content-Type contains 'application/json'
			And match $ contains {"message":"ConstraintViolationException"}

	Scenario: Is the hello uri available and functioning
    Given url microserviceUrl
    And path '/github/repos/starred/1'
    When method GET
    Then status 200
			And match header Content-Type contains 'application/json'
  		And match $ == [{name : '#string',html_url : '#string',watchers_count : '#string',language : '#string',description : '#string'}]


Scenario: Is the hello uri available and functioning
    Given url microserviceUrl
    And path '/github/repos/starred/0'
    When method GET
    Then status 404
			And match header Content-Type contains 'application/json'
  		And match $ contains {"message":"ConstraintViolationException"}
