Feature: MHS mobile app login
Scenario: Login to the mobile App using Email and Password
Given User is present on the login page
When User provide the credentials
|Email|
|testpatient@yopmail.com|
Then User is logged in the App succesfully And land on App dashboard

#Scenario: Login without email and password
#Given User is present on the login page
#When User provide the credentials
#|Email|
#|-|
#But User see field validation error on Email and password fields
#
#Scenario: Login with invalid credential
#Given User is present on the login page
#When User provide the credentials
#|Email|
#|hashton44@yopmail.com|
#But User see field validation error on Email and password fields




