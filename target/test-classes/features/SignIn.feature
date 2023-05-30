@SignInFeature
Feature: Retail SignIn

Background:
Given User is on retail website
When User click on Sign in option

@SingIn
Scenario: Verify user can sign in into Retail Application
And User enter email 'JohnAdams@gmail.com' and password 'Afghanistan@1234'
And User click on login button
Then User should be logged in into Account

@SignUp
Scenario: Verify user can create an account into Retail Website
And User click on Create New Account button
And User fill the signUp information with below data
| name | email | password | confirmPassword |
| Massouda| MassoudaAf2023@tekschool.us | TekSchool129@ | TekSchool129@ |
And User click on SignUp button
Then User should be logged into account page
  