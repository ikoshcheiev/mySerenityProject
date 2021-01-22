Feature: Datatable example

#DataTables in Cucumber	
Scenario: As a user, I want to view all the categories 

	Given I Login to the application with valid test and test 
	When I click on a category, then a category is displayed 
		| FISH |
		| CATS |
		| DOGS |
		| REPTILES |