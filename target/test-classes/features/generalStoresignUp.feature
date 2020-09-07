Feature: sign up
Scenario: sign up from general store home page
Given User is on general store home page
     When user provide sign up information
     |Fields|Value|
     |Name|Kapil|
      And user click on Lets shop button
     Then User is navigated to products page