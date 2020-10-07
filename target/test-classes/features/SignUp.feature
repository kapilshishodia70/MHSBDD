Feature: Sign up for the MHS App
  Background: User is present on Registration page
    Given User is present on the login page
     When user click on Signup link
     Then user is navigated to Pre Registration page
  
#  Scenario Outline: Patient Sign up using Email
#    Given user choose to sign up as a <user type>
#     When user fill the required form details i.e. <FullName>, <Email> , <Password> , <ConfirmPassword> and click on register button.
#      And User provide the valid OTP <OTP> as recived on <Email> and click on Submit button.
#     Then user should be registered successfully and lands on login page.
#    Examples: 
#      | user type  | FullName      | Email                    | Password   |ConfirmPassword| OTP  | 
#      | Patient    | Pramodm Jain   | PramomDjain@yopmail.com   | Strong@129 |Strong@129 | 1234 | 
#      | Specialist | Dhruv Bhargav | DhruvBhargav@yopmail.com | Strong@129 | 1234 | 
#  
#  Scenario Outline: Patient Sign up using invalid format of Email or password
#    Given user choose to sign up as a <user type>
#     When user fill the required form details i.e. <FullName>, <Email> , <Password> , <ConfirmPassword> and click on register button.
#      But User see validation error message when used <FullName>, <Email>, <Password> and <ConfirmPassword>.
#    Examples: 
#      | user type | FullName | Email | Password | OTP | 
#      |Patient|Pramod@1|Pramod1@yopmail.com|Strong@129|1234| 
#      |Patient|Pramod|Pramod1@yopmail|Strong@129|1234|
#      |Patient|Pramod|Pramod1@yopmail.com|Strong129|1234| 
  
  Scenario Outline: Patient try to Sign up using invalid OTP
    Given user choose to sign up as a <user type>
     When user fill the required form details i.e. <FullName>, <Email> , <Password> , <ConfirmPassword> and click on register button.
      And User provide the invalid  <OTP> that is not associated with <Email> and click on Submit button.
      But User see validation error message when used  <OTP> as OTP. 
    Examples: 
      | user type | FullName | Email | Password |ConfirmPassword| OTP | 
      |Patient|Pramod z|Pramodz1@yopmail.com|Strong@129|Strong@129|1235|
 #     |           |          |       |          |     | 

 
