Feature: Forgot password for reseting the password of registered user.
  Scenario Outline: Reseting password from login page.
    Given User is present on the login page
      And user clicks on  Forgot password link.
     When user enter the <Email> on Forgot password page and click submit button.
      And user provide the otp <OTP> , new password <new password> and confirm password <confirm password> on password reset page and click on Submit button
     Then an alert stating password changed should be displayed with message as <message>
      And User should be able to Login with email <Email> and changed password <new password> succesfully.
  
    Examples: 
      | Email                    | OTP  | new password | confirm password |message|
      | toddjoyce@yopmail.com | 1234 | Strong@321    | Strong@321       | Password reset Successfully, Please login again|