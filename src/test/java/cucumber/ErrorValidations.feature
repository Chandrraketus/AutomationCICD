@tag
Feature: Error validations
	I want to use this template for my feature file
	
	
	@tag2
	Scenario OutLine Title of your scenario outLine
		Given I landed on e-commerce Page
		When Logged in with user name<name> and password<password>
		Then "Incorrect email or password." message is displayed
		
		Examples:
      | name                     | password    | 
      | rahulshetty@gmail.com    | IamKing@00 |
		
