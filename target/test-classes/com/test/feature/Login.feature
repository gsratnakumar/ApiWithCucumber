Feature: Application Login

Scenario: Home page login
Given When user landing the login page
When Enter valid user name "suresh@sureify.com" and password "Black@123" and click login button
Then User sucessfully login and Home page should be displayed
And User profile icon displyed
And Displayed "All" modules

Scenario: Home page login
Given When user landing the login page
When Enter valid user name "suresh+1@sureify.com" and password "Black+1@123" and click login button
Then User sucessfully login and Home page should be displayed
And User profile icon displyed
And Displayed "Spec" modules




